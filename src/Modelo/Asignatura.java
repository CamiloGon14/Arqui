package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private int creditos;
    private String codigo;
    private String seccion;
    private String semestre;



    public Asignatura(String nombre, int creditos, String codigo, String seccion, String semestre) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.codigo = codigo;
        this.seccion = seccion;
        this.semestre = semestre;
        this.asistencias = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    private ArrayList<Asistencia> asistencias;

    public Asignatura() {
        this("", 0, "", "", "");
    }



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
    // En la clase Asignatura:
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
}//Crud

