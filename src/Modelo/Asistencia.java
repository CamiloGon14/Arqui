package Modelo;

import java.util.HashMap;

public class Asistencia {
    private String fecha;
    private String horaInicio;
    private String horaFinal;
    private HashMap<String, String> estadoEstudiantes;

    public Asistencia(String fecha, String horaInicio, String horaFinal) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.estadoEstudiantes = new HashMap<>();
    }

    public void registrarEstado(String codigoEstudiante, String estado) {
        estadoEstudiantes.put(codigoEstudiante, estado);
    }

    public void cambiarEstado(String codigoEstudiante, String nuevoEstado) {
        estadoEstudiantes.put(codigoEstudiante, nuevoEstado);
    }

    public HashMap<String, String> getEstadoEstudiantes() {
        return estadoEstudiantes;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "fecha='" + fecha + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFinal='" + horaFinal + '\'' +
                ", estadoEstudiantes=" + estadoEstudiantes +
                '}';
    }
}
