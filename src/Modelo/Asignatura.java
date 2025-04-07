package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private int creditos;
    private String codigo;
    private String seccion;
    private String semestre;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Estudiante> estudiantes; // estudiantes registrados en la asignatura

    public Asignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.codigo = codigo;
        this.seccion = seccion;
        this.semestre = semestre;
        this.asistencias = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    // Constructor vacío
    public Asignatura() {
        this("", 0, "", "", "");
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }
    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public ArrayList<Asistencia> getAsistencias() { return asistencias; }
    public void setAsistencias(ArrayList<Asistencia> asistencias) { this.asistencias = asistencias; }
    public ArrayList<Estudiante> getEstudiantes() { return estudiantes; }
    public void setEstudiantes(ArrayList<Estudiante> estudiantes) { this.estudiantes = estudiantes; }

    // Métodos de asistencia
    public boolean adicionarAsistencia(String fecha, String hora_inicio, String hora_final,
                                       ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia asistencia = new Asistencia(fecha, hora_inicio, hora_final);
        for (int i = 0; i < codigos.size(); i++) {
            asistencia.adicionarAsistencia(codigos.get(i), estados.get(i));
        }
        asistencias.add(asistencia);
        return true;
    }

    public Asistencia consultarAsistencia(String fecha, String hora_inicio, String hora_final) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equalsIgnoreCase(fecha) &&
                    a.getHora_inicio().equalsIgnoreCase(hora_inicio) &&
                    a.getHora_final().equalsIgnoreCase(hora_final)) {
                return a;
            }
        }
        return null;
    }

    public boolean modificarAsistencia(String fecha, String hora_inicio, String hora_final,
                                       String fechan, String hora_inicion, String hora_finaln,
                                       ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia asistencia = consultarAsistencia(fecha, hora_inicio, hora_final);
        if (asistencia != null) {
            asistencia.setFecha(fechan);
            asistencia.setHora_inicio(hora_inicion);
            asistencia.setHora_final(hora_finaln);
            asistencia.setCodigos(codigos);
            asistencia.setEstados(estados);
            return true;
        }
        return false;
    }

    public boolean eliminarAsistencia(String fecha, String horaInicio, String horaFinal) {
        for (int i = 0; i < asistencias.size(); i++) {
            Asistencia asistencia = asistencias.get(i);
            if (asistencia.getFecha().equals(fecha) &&
                    asistencia.getHora_inicio().equals(horaInicio) &&
                    asistencia.getHora_final().equals(horaFinal)) {
                asistencias.remove(i);
                return true;
            }
        }
        return false;
    }

    // Métodos para gestionar estudiantes en la asignatura
    public boolean registrarEstudiante(Estudiante e) {
        // Se puede agregar validación para que no se dupliquen
        estudiantes.add(e);
        return true;
    }

    public ArrayList<Estudiante> consultarEstudiantes() {
        return estudiantes;
    }

    // Método para crear lista de asistencia vacía:
    // Se crea una asistencia con todos los estudiantes marcados "No asistió"
    public boolean crearListaAsistencia(String fecha, String hora_inicio, String hora_final) {
        ArrayList<String> codigos = new ArrayList<>();
        ArrayList<String> estados = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            // Se usa una clave única para cada estudiante (por ejemplo, tipo-numero)
            codigos.add(e.getTipoDocumento() + "-" + e.getNumeroDocumento());
            estados.add("No asistió");
        }
        return adicionarAsistencia(fecha, hora_inicio, hora_final, codigos, estados);
    }
}
