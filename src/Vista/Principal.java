package Vista;

import java.util.ArrayList;
import java.util.Scanner;
import Controlador.ElControlador;

public class Principal {
    public static void main(String[] args) {
        String opcion = "";
        Scanner input = new Scanner(System.in);
        ElControlador controlador = new ElControlador();

        while (!opcion.equals("0")) {
            System.out.println("***** SISTEMA ASISTENCIA *******"
                    + "\n1. Adicionar Departamento"
                    + "\n2. Consultar Departamento"
                    + "\n3. Modificar Departamento"
                    + "\n4. Registrar Estudiantes en Asignaturas"
                    + "\n5. Generar Lista de Asistencia"
                    + "\n6. Cambiar estado de lista de asistencia"
                    + "\n7. Adicionar Asignatura"
                    + "\n8. Consultar Asignatura"
                    + "\n9. Modificar Asignatura"
                    + "\n10. Eliminar Asignatura"
                    + "\n11. Adicionar Estudiante"
                    + "\n12. Consultar Estudiante"
                    + "\n13. Modificar Estudiante"
                    + "\n14. Eliminar Estudiante"
                    + "\n15. Adicionar Asistencia"
                    + "\n16. Consultar Asistencia"
                    + "\n17. Modificar Asistencia"
                    + "\n18. Eliminar Asistencia"
                    + "\n0. Salir"
                    + "\nSeleccione la opción que desee:");
            opcion = input.nextLine();
            if (opcion.equals("1")) {
                // Adicionar Departamento
                System.out.print("Nombre del departamento: ");
                String nombreDept = input.nextLine();
                System.out.println(controlador.adicionarDepartamento(nombreDept) ? "Departamento adicionado." : "Ya existe un departamento.");
            } else if (opcion.equals("2")) {
                // Consultar Departamento
                System.out.println(" Departamento actual: " + controlador.consultarDepartamento());
            } else if (opcion.equals("3")) {
                // Modificar Departamento
                System.out.print("Nuevo nombre del departamento: ");
                String nuevoNombre = input.nextLine();
                System.out.println(controlador.modificarDepartamento(nuevoNombre) ? " Nombre actualizado." : " No se puede modificar.");
            } else if (opcion.equals("4")) {
                // Registrar Estudiantes en Asignaturas
                System.out.print("Código asignatura: ");
                String codA = input.nextLine();
                System.out.print("Cantidad de estudiantes a registrar: ");
                int n = Integer.parseInt(input.nextLine());
                ArrayList<String> cods = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    System.out.print("Código estudiante " + (i + 1) + ": ");
                    cods.add(input.nextLine());
                }
                System.out.println(controlador.registrarEstudiantesEnAsignatura(codA, cods) ? "✔ Estudiantes registrados." : "✖ Error.");
            } else if (opcion.equals("5")) {
                // Generar Lista de Asistencia
                System.out.print("Código asignatura: ");
                String codAsist = input.nextLine();
                System.out.println(controlador.generarListaAsistencia(codAsist));
            } else if (opcion.equals("6")) {
                // Cambiar estado de lista de asistencia
                System.out.print("Código asignatura: ");
                String codAsign = input.nextLine();
                System.out.print("Código estudiante: ");
                String codEst = input.nextLine();
                System.out.print("Nueva asistencia (Presente/Ausente): ");
                String estado = input.nextLine();
                System.out.println(controlador.cambiarEstadoAsistencia(codAsign, codEst, estado) ? " Estado cambiado." : " No se pudo cambiar.");
            } else if (opcion.equals("7")) {
                // Adicionar Asignatura
                System.out.print("Nombre asignatura: ");
                String nomA = input.nextLine();
                System.out.print("Créditos: ");
                int creditos = Integer.parseInt(input.nextLine());
                System.out.print("Código: ");
                String codigo = input.nextLine();
                System.out.print("Sección: ");
                String seccion = input.nextLine();
                System.out.print("Semestre: ");
                String semestre = input.nextLine();
                System.out.println(controlador.adicionarAsignatura(nomA, creditos, codigo, seccion, semestre) ? " Asignatura adicionada." : " No se pudo adicionar.");
            } else if (opcion.equals("8")) {
                // Consultar Asignatura
                System.out.print("Código asignatura: ");
                String cA = input.nextLine();
                System.out.println(controlador.consultarAsignatura(cA));
            } else if (opcion.equals("9")) {
                // Modificar Asignatura
                System.out.print("Código asignatura a modificar: ");
                String codAm = input.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNom = input.nextLine();
                System.out.print("Nuevos créditos: ");
                int nuevosCred = Integer.parseInt(input.nextLine());
                System.out.print("Nueva sección: ");
                String nuevaSec = input.nextLine();
                System.out.print("Nuevo semestre: ");
                String nuevoSem = input.nextLine();
                System.out.println(controlador.modificarAsignatura(codAm, nuevoNom, nuevosCred, nuevaSec, nuevoSem) ? "Modificada." : "No se pudo modificar.");
            } else if (opcion.equals("10")) {
                // Eliminar Asignatura
                System.out.print("Código asignatura: ");
                String codAEli = input.nextLine();
                System.out.println(controlador.eliminarAsignatura(codAEli) ? " Eliminada." : " No existe.");
            } else if (opcion.equals("11")) {
                // Adicionar Estudiante
                System.out.print("Nombre estudiante: ");
                String nomE = input.nextLine();
                System.out.print("Código: ");
                String codE = input.nextLine();
                System.out.println(controlador.adicionarEstudiante(nomE, codE) ? " Estudiante adicionado." : " Ya existe.");
            } else if (opcion.equals("12")) {
                // Consultar Estudiante
                System.out.print("Código estudiante: ");
                String codEstu = input.nextLine();
                System.out.println(controlador.consultarEstudiante(codEstu));
            } else if (opcion.equals("13")) {
                // Modificar Estudiante
                System.out.print("Código estudiante: ");
                String codMod = input.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNomEst = input.nextLine();
                System.out.println(controlador.modificarEstudiante(codMod, nuevoNomEst) ? " Modificado." : " No se encontró.");
            } else if (opcion.equals("14")) {
                // Eliminar Estudiante
                System.out.print("Código estudiante a eliminar: ");
                String codEliminar = input.nextLine();
                System.out.println(controlador.eliminarEstudiante(codEliminar) ? " Eliminado." : " No se encontró.");
            } else if (opcion.equals("15")) {
                // Adicionar Asistencia
                System.out.print("Código asignatura: ");
                String codAsist2 = input.nextLine();
                System.out.print("Fecha: ");
                String fecha = input.nextLine();
                System.out.print("Hora inicio: ");
                String hi = input.nextLine();
                System.out.print("Hora final: ");
                String hf = input.nextLine();
                System.out.print("Cantidad de estudiantes: ");
                int m = Integer.parseInt(input.nextLine());
                ArrayList<String> codigos = new ArrayList<>();
                ArrayList<String> estados = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    System.out.print("Código estudiante " + (i + 1) + ": ");
                    codigos.add(input.nextLine());
                    System.out.print("Estado (Presente/Ausente): ");
                    estados.add(input.nextLine());
                }
                System.out.println(controlador.adicionarAsistencia(codAsist2, fecha, hi, hf, codigos, estados) ? " Asistencia registrada." : " Error.");
            } else if (opcion.equals("16")) {
                // Consultar Asistencia
                System.out.print("Código asignatura: ");
                String codAsisCon = input.nextLine();
                System.out.println(controlador.consultarAsistencias(codAsisCon));
            } else if (opcion.equals("17")) {
                // Modificar Asistencia
                System.out.print("Código asignatura: ");
                String codAsisMod = input.nextLine();
                System.out.print("Fecha de asistencia: ");
                String fechaMod = input.nextLine();
                System.out.print("Nuevo estado: ");
                String estadoMod = input.nextLine();
                System.out.print("Código estudiante: ");
                String codEstMod = input.nextLine();
                System.out.println(controlador.modificarAsistencia(codAsisMod, fechaMod, codEstMod, estadoMod) ? " Asistencia modificada." : " Error.");
            } else if (opcion.equals("18")) {
                // Eliminar Asistencia
                System.out.print("Código asignatura: ");
                String codAsisDel = input.nextLine();
                System.out.print("Fecha a eliminar: ");
                String fechaDel = input.nextLine();
                System.out.println(controlador.eliminarAsistencia(codAsisDel, fechaDel) ? " Asistencia eliminada." : "No se encontró.");
            } else {
                // Número no válido
            }
        }

        input.close();
    }
}
