package Controlador;

import Modelo.*;

import java.util.ArrayList;

public class ElControlador {
    private Departamento departamento;

    public boolean adicionarDepartamento(String nombre) {
        if (departamento == null) {
            departamento = new Departamento(nombre);
            return true;
        }
        return false;
    }

    public String consultarDepartamento() {
        return (departamento != null) ? departamento.getNombre() : "No existe un departamento.";
    }

    public boolean modificarDepartamento(String nuevoNombre) {
        if (departamento != null) {
            departamento.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

    public boolean adicionarAsignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        if (departamento != null && departamento.buscarAsignatura(codigo) == null) {
            departamento.adicionarAsignatura(new Asignatura(nombre, creditos, codigo, seccion, semestre));
            return true;
        }
        return false;
    }

    public String consultarAsignatura(String codigo) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codigo);
            return (a != null) ? a.toString() : "No existe.";
        }
        return "No hay departamento.";
    }

    public boolean modificarAsignatura(String codigo, String nuevoNombre, int nuevosCreditos, String nuevaSeccion, String nuevoSemestre) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codigo);
            if (a != null) {
                a.setNombre(nuevoNombre);
                a.setCreditos(nuevosCreditos);
                a.setSeccion(nuevaSeccion);
                a.setSemestre(nuevoSemestre);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarAsignatura(String codigo) {
        return departamento != null && departamento.eliminarAsignatura(codigo);
    }

    public boolean adicionarEstudiante(String nombre, String codigo) {
        if (departamento != null && departamento.buscarEstudiante(codigo) == null) {
            departamento.adicionarEstudiante(new Estudiante(nombre, codigo));
            return true;
        }
        return false;
    }

    public String consultarEstudiante(String codigo) {
        if (departamento != null) {
            Estudiante e = departamento.buscarEstudiante(codigo);
            return (e != null) ? e.toString() : "No encontrado.";
        }
        return "No hay departamento.";
    }

    public boolean modificarEstudiante(String codigo, String nuevoNombre) {
        if (departamento != null) {
            Estudiante e = departamento.buscarEstudiante(codigo);
            if (e != null) {
                e.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(String codigo) {
        return departamento != null && departamento.eliminarEstudiante(codigo);
    }

    public boolean registrarEstudiantesEnAsignatura(String codAsignatura, ArrayList<String> codEstudiantes) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null) {
                for (String cod : codEstudiantes) {
                    Estudiante e = departamento.buscarEstudiante(cod);
                    if (e != null) {
                        a.adicionarEstudiante(e);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String generarListaAsistencia(String codAsignatura) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null) {
                return a.getEstudiantes().toString();
            }
        }
        return "Asignatura no encontrada.";
    }

    public boolean cambiarEstadoAsistencia(String codAsignatura, String codEstudiante, String nuevoEstado) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null && !a.getAsistencias().isEmpty()) {
                Asistencia asistencia = a.getAsistencias().get(a.getAsistencias().size() - 1);
                asistencia.cambiarEstado(codEstudiante, nuevoEstado);
                return true;
            }
        }
        return false;
    }

    public boolean adicionarAsistencia(String codAsignatura, String fecha, String hi, String hf, ArrayList<String> codigos, ArrayList<String> estados) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null) {
                Asistencia asistencia = new Asistencia(fecha, hi, hf);
                for (int i = 0; i < codigos.size(); i++) {
                    asistencia.registrarEstado(codigos.get(i), estados.get(i));
                }
                a.adicionarAsistencia(asistencia);
                return true;
            }
        }
        return false;
    }

    public String consultarAsistencias(String codAsignatura) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            return (a != null) ? a.getAsistencias().toString() : "No encontrada.";
        }
        return "No hay departamento.";
    }

    public boolean modificarAsistencia(String codAsignatura, String fecha, String codEstudiante, String nuevoEstado) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null) {
                Asistencia asistencia = a.buscarAsistenciaPorFecha(fecha);
                if (asistencia != null) {
                    asistencia.cambiarEstado(codEstudiante, nuevoEstado);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarAsistencia(String codAsignatura, String fecha) {
        if (departamento != null) {
            Asignatura a = departamento.buscarAsignatura(codAsignatura);
            if (a != null) {
                Asistencia asistencia = a.buscarAsistenciaPorFecha(fecha);
                if (asistencia != null) {
                    a.getAsistencias().remove(asistencia);
                    return true;
                }
            }
        }
        return false;
    }
}
