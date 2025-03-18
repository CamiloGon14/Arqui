import java.util.ArrayList;

public class Asignatura {
    private String nombre="";
    private int creditos=0;
    private String codigo="";
    private String seccion="";
    private String semestre="";
    private ArrayList<Asistencia> asistencias=new ArrayList<Asistencia>();

    public Asignatura(){


    }
    public Asignatura(String nombre, int creditos, String codigo, String seccion, String semestre){
        this.nombre=nombre;
        this.creditos=creditos;
        this.codigo=codigo;
        this.seccion=seccion;
        this.semestre=semestre;
    }
    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public boolean adicionarAsistencia(String fecha, String hora_inicio, String hora_final
        , ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia asistencia = new Asistencia(fecha, hora_inicio, hora_final);
        for(int vc=0; vc<codigos.size();vc++){
            String codigo= codigos.get(vc);
            String estado= estados.get(vc);
            asistencia.adicionarAsistencia(codigo,estado);
        }
        asistencias.add(asistencia);
        return true;
    }
    public Asistencia consultarAsistencia(String fecha, String hora_inicio, String hora_final
           ) {
        for (int vc = 0; vc < asistencias.size(); vc++) {
            if(asistencias.get(vc).getFecha().equalsIgnoreCase(fecha)&&asistencias.get(vc).getHora_inicio().equalsIgnoreCase(fecha)&&asistencias.get(vc).getHora_final().equalsIgnoreCase(hora_final)){
                return asistencias.get(vc)
            }
        }
        return null;
        }
    }
    public boolean modificarAsistencia(String fecha, String hora_inicio, String hora_final
        , String fechan, String hora_inicion, String hora_finaln, ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia laasistencia = this.consulatrAsistencia(fecha, hora_inicio,hora_final);
        if(laasistencia!=null) {
            laasistencia.setFecha(fecha);
            laasistencia.setHora_inicio(hora_inicio);
            laasistencia.setHora_final(hora_final);
            laasistencia.setCodigos(codigos);
            laasistencia.setEstados(estados);
            return true;
        }
        return false;
    }
}