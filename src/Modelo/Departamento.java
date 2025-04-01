package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;
    private static Departamento instancia = null;

    private Departamento() {
        nombre = "";
        asignaturas = new ArrayList<>();
    }

    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean adicionarAsignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        Asignatura asignatura = new Asignatura(nombre, creditos, codigo, seccion, semestre);
        asignaturas.add(asignatura);
        return true;
    }

    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equalsIgnoreCase(codigo) &&
                    asignatura.getSeccion().equalsIgnoreCase(seccion) &&
                    asignatura.getSemestre().equalsIgnoreCase(semestre)) {
                return asignatura;
            }
        }
        return null;
    }

    public boolean actualizarAsignatura(String codigo, String seccion, String semestre, String nombre, int creditos) {
        Asignatura asignatura = consultarAsignatura(codigo, seccion, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }

    public boolean borrarAsignatura(String codigo, String seccion, String semestre) {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura asignatura = asignaturas.get(i);
            if (asignatura.getCodigo().equalsIgnoreCase(codigo) &&
                    asignatura.getSeccion().equalsIgnoreCase(seccion) &&
                    asignatura.getSemestre().equalsIgnoreCase(semestre)) {
                asignaturas.remove(i);
                return true;
            }
        }
        return false;
    }
}
