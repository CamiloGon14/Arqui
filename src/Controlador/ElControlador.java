package Controlador;

import Modelo.*;
import java.util.ArrayList;

import static Modelo.Departamento.singleton;

public class ElControlador {
     Departamento departamento = null;
    public  ElControlador() {
        departamento =Departamento.singleton();
    }
    public void CrearDepartamento (String nombre) {
        departamento.setNombre (nombre);
    }
    public boolean adicionarAsignatura(String nombre,int creditos,String codigo,String seccion,String semestre){
        departamento.adicionarAsignatura(nombre,creditos,codigo,seccion,semestre);
        return true;
    }

    public boolean adicionarDepartamento(String nombre) {

    }

    public String consultarDepartamento(String nombre) {
    }

    public boolean modificarDepartamento(String nombreAntiguo, String nombreNuevo) {
    }
}