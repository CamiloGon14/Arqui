package Modelo;

import java.util.ArrayList;

public class Departamento {

    private String nombre;
    private ArrayList<Asignatura>asignaturas=null;
    private static Departamento instancia=null;


    public Departamento() {
        nombre = "";
        asignaturas=new ArrayList<Asignatura>();
    }
    public static Departamento singlenton(){
        if(instancia==null){
            instancia=new Departamento();
        }
        return instancia;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //CRUD - Create, Read, Update, Delete
    public boolean adicionarAsignatura(String nombre, int creditos, String codigo, String seccion, String semestre){
        Asignatura asignatura=new Asignatura(nombre,creditos,codigo,seccion,semestre);
        asignatura.add(asignatura);
        return true;
    }
    public Asignatura consultarAsignatura(String codigo, String seccion, String semestre){
        for(int v=0; v<Asignaturas.size(); v++){
            Asignatura copia=asignaturas.get(v);
            if(copia.getCodigo().equalsIgnoreCase(codigo) == true &&
                    copia.getCodigo().equalsIgnoreCase(seccion) == true &&
                    copia.getCodigo().equalsIgnoreCase(semestre) == true) {
                return copia;
            }
        }
        return null;
    }
    public boolean actualizarAsignatura (String codigo, String seccion, String semestre, String nombre, int creditos){
        Asignatura asignatura=this.consultarAsignatura(codigo, seccion, semestre);
        if(asignatura!=null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);

            return true;
        }
        return false;
    }
    public boolean borrarAsignatura(String codigo, String seccion, String semestre){
        for(int v=0; v<Asignaturas.size(); v++) {
            Asignatura copia = asignaturas.get(v);
            if(copia.getCodigo().equalsIgnoreCase(codigo) == true &&
                    copia.getCodigo().equalsIgnoreCase(seccion) == true &&
                    copia.getCodigo().equalsIgnoreCase(semestre) == true) {
                asignaturas.remove(v);
                return true;
            }
        }
    }


}
