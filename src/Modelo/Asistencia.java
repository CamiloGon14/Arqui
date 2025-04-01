package Modelo;

import java.util.ArrayList;

public class Asistencia {
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    private String fecha;
    private String hora_inicio;
    private String hora_final;
    private ArrayList<String> codigos;
    private ArrayList<String> estados;

    public Asistencia(String fecha, String hora_inicio, String hora_final) {
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.codigos = new ArrayList<>();
        this.estados = new ArrayList<>();
    }


    public boolean adicionarAsistencia(String codigo, String estado) {
        codigos.add(codigo);
        estados.add(estado);
        return true;
    }

    public String consultarAsistencia(String codigo) {
        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i).equalsIgnoreCase(codigo)) {
                return estados.get(i);
            }
        }
        return null;
    }

    public boolean modificarAsistencia(String codigo, String estado) {
        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i).equalsIgnoreCase(codigo)) {
                estados.set(i, estado);
                return true;
            }
        }
        return false;
    }

    public void setCodigos(ArrayList<String> codigos) {
        this.codigos = codigos;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }
}