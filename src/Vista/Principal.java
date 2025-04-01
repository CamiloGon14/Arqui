package Vista;

import java.util.Scanner;
import Controlador.ElControlador;

public class Principal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String opcion = "";
        Scanner input = new Scanner(System.in);
        ElControlador controlador = new ElControlador();
        boolean rta = false;
        String msg = "";
        String nombre = "";

        while (opcion.equals("4") == false) {
            System.out.println("*****SISTEMA ASISTENCIA *******"
                    + "\n1. Adicionar Departamento"
                    + "\n2. Consultar Departamento"
                    + "\n3. Modificar Departamento"
                    + "\n4. Salir"
                    + "\nSeleccione la opción que desee:?");
            opcion = input.nextLine();

            if (opcion.equals("1")) {
                System.out.println("Nombre del departamento?:");
                nombre = input.nextLine();
                rta = controlador.adicionarDepartamento(nombre);
                if(rta) {
                    System.out.println("Departamento " + nombre + "adicionado");
                } else {
                    System.out.println("No se pudo adicionar");
                }

            } else if (opcion.equals("2")) {
                System.out.println("Nombre del departamento?:");
                nombre = input.nextLine();
                msg = controlador.consultarDepartamento(nombre);
                System.out.println(msg);

            } else if (opcion.equals("3")) {
                System.out.println("Nombre del departamento?:");
                String nombreAntiguo = input.nextLine();
                System.out.println("Nuevo nombre del departamento?:");
                String nombreNuevo = input.nextLine();
                rta = controlador.modificarDepartamento(nombreAntiguo, nombreNuevo);
                if(rta) {
                    System.out.println("Departamento " + nombreAntiguo + "modificado");
                } else {
                    System.out.println("No se pudo modificar");
                }
            }
        }
    }
}