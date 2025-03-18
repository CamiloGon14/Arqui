package Modelo;

import java.util.ArrayList;

public class Asistencia {
    private String fecha=""; //aaaa/mm/dd
    private String hora_inicio=""; //hh/mm:ss
    private String hora_final=""; //hh/mm:ss
    private ArrayList<String> codigos=new ArrayList<String>();
    private ArrayList<String> estados=new ArrayList<String>(); //0: A tiempo, 1:Tarde, 2:No llego

    public Asistencia(){

    }
    public Asistencia(String fecha, String hora_inicio, String hora_final){
        this.fecha=fecha;
        this.hora_inicio=hora_inicio;
        this.hora_final=hora_final;
    }
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
    public boolean adicionarAsistencia(String codigo, String estado){
        codigos.add(codigo);
        estados.add(estado);
        return true;
    }
    public String consultarAsistencia(String codigo){
        for(int vc=0; vc<codigos.size();vc++){
            if(codigos.get(vc).equalsIgnoreCase(codigo)==true){
                return estados.get(vc);
            }
        }
        return null;
    }

    /**
     * Este metodo adiciona la asistencia a una asignatura de un estudiante
     * @param codigo Corresponde al numero de documento de identidad del estudiante
     * @param estado Corresponde a 0 si Asistio, 1 si llego tarde , 2 no llego
     * @return true si se adiciono la asistencia o false si no lo hizo
     */

    public boolean modificarAsistencia(String codigo, String estado) {
        for (int vc = 0; vc < codigos.size(); vc++) {
            if (codigos.get(vc).equalsIgnoreCase(codigo)) {
                estados.set(vc, estado);
                return true;
            }
        }
        return false;
    }

    public boolean setCodigos(ArrayList<String> codigos){
        this.codigos=codigos;
        return true;
    }
    public boolean setEstados(ArrayList<String> codigos){
        this.estados=estados;
        return true;
    }
}
