package Controlador;

import Modelo.*;

import java.util.ArrayList;

public class ElControlador {
    Departamento departamento;

    public ElControlador() {
        departamento = Departamento.singleton();
    }

    // CRUD Departamento
    public void crearDepartamento(String nombre) {
        departamento.setNombre(nombre);
    }

    public boolean adicionarDepartamento(String nombre) {
        if (departamento.getNombre() == null || departamento.getNombre().isEmpty()) {
            departamento.setNombre(nombre);
            return true;
        }
        return false;
    }

    public String consultarDepartamento(String nombre) {
        return departamento.getNombre();
    }

    public boolean modificarDepartamento(String nombreNuevo, String nuevo) {
        if (!departamento.getNombre().isEmpty()) {
            departamento.setNombre(nombreNuevo);
            return true;
        }
        return false;
    }

    // Gestión de estudiantes en el departamento
    public boolean registrarEstudianteEnDepartamento(String nombres, String apellidos, String tipoDoc, String numDoc) {
        Estudiante e = new Estudiante(nombres, apellidos, tipoDoc, numDoc);
        return departamento.registrarEstudiante(e);
    }

    public String consultarEstudianteEnDepartamento(String tipo, String num) {
        Estudiante e = departamento.consultarEstudiante(tipo, num);
        if (e != null) {
            return "Estudiante: " + e.getNombres() + " " + e.getApellidos();
        }
        return "Estudiante no encontrado";
    }

    public boolean modificarEstudianteEnDepartamento(String tipo, String num, String nuevosNombres, String nuevosApellidos, String nuevoTipoDoc) {
        return departamento.modificarEstudiante(tipo, num, nuevosNombres, nuevosApellidos, nuevoTipoDoc);
    }

    // CRUD Asignatura
    public boolean adicionarAsignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        return departamento.adicionarAsignatura(nombre, creditos, codigo, seccion, semestre);
    }

    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        return departamento.consultarAsignatura(codigo, seccion, semestre);
    }

    public boolean modificarAsignatura(String codigo, String seccion, String semestre, String nombre, int creditos) {
        return departamento.actualizarAsignatura(codigo, seccion, semestre, nombre, creditos);
    }

    // Gestión de estudiantes en asignatura
    public boolean registrarEstudianteEnAsignatura(String tipoDoc, String numDoc, String codigo, String seccion, String semestre) {
        // Primero se busca el estudiante en el departamento
        Estudiante e = departamento.consultarEstudiante(tipoDoc, numDoc);
        if (e != null) {
            Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
            if (a != null) {
                return a.registrarEstudiante(e);
            }
        }
        return false;
    }

    public String consultarEstudiantesEnAsignatura(String codigo, String seccion, String semestre) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            StringBuilder sb = new StringBuilder();
            for (Estudiante e : a.getEstudiantes()) {
                sb.append(e.getTipoDocumento()).append("-")
                        .append(e.getNumeroDocumento()).append("\n");
            }
            return sb.toString();
        }
        return "Asignatura no encontrada";
    }

    // Gestión de asistencia en asignatura
    public boolean crearListaAsistencia(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            return a.crearListaAsistencia(fecha, horaInicio, horaFinal);
        }
        return false;
    }

    public boolean llenarAsistencia(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal,
                                    String claveEstudiante, String nuevoEstado) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            Asistencia asistencia = a.consultarAsistencia(fecha, horaInicio, horaFinal);
            if (asistencia != null) {
                return asistencia.modificarAsistencia(claveEstudiante, nuevoEstado);
            }
        }
        return false;
    }

    public String listarAsistencias(String codigo, String seccion, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = departamento.consultarAsignatura(codigo, seccion, semestre);
        if (a != null) {
            Asistencia asistencia = a.consultarAsistencia(fecha, horaInicio, horaFinal);
            if (asistencia != null) {
                StringBuilder sb = new StringBuilder();
                ArrayList<String> codigos = asistencia.getCodigos();
                ArrayList<String> estados = asistencia.getEstados();
                for (int i = 0; i < codigos.size(); i++) {
                    sb.append(codigos.get(i)).append(": ").append(estados.get(i)).append("\n");
                }
                return sb.toString();
            }
        }
        return "No se encontró la asistencia";
    }
}
