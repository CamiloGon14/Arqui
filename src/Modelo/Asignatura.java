package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Asignatura {
    private String nombre;
    private int creditos;
    private String codigo;
    private String seccion;
    private String semestre;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asistencia> asistencias;

    public Asignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.codigo = codigo;
        this.seccion = seccion;
        this.semestre = semestre;
        this.estudiantes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void adicionarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void adicionarAsistencia(Asistencia a) {
        asistencias.add(a);
    }

    public Asistencia buscarAsistenciaPorFecha(String fecha) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", codigo='" + codigo + '\'' +
                ", seccion='" + seccion + '\'' +
                ", semestre='" + semestre + '\'' +
                ", estudiantes=" + estudiantes +
                '}';
    }
}

