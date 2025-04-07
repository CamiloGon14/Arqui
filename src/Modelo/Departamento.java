package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Estudiante> estudiantes;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void adicionarAsignatura(Asignatura a) {
        asignaturas.add(a);
    }

    public Asignatura buscarAsignatura(String codigo) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }

    public boolean eliminarAsignatura(String codigo) {
        Asignatura a = buscarAsignatura(codigo);
        if (a != null) {
            asignaturas.remove(a);
            return true;
        }
        return false;
    }

    public void adicionarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public Estudiante buscarEstudiante(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEstudiante(String codigo) {
        Estudiante e = buscarEstudiante(codigo);
        if (e != null) {
            estudiantes.remove(e);
            return true;
        }
        return false;
    }
}
