package negocio;

/**
 *
 * @author CAMILO
 */
public class Agenda {
    private String idAgenda;
    private String estado;
    private String fecha;
    private String hInicio;
    private String hFinal;
    private String consultorio;
    private String medico;
    private String tCita;

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String gettCita() {
        return tCita;
    }

    public void settCita(String tCita) {
        this.tCita = tCita;
    }

    public Agenda(){
        
    }
    
    

    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(String idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String gethInicio() {
        return hInicio;
    }

    public void sethInicio(String hInicio) {
        this.hInicio = hInicio;
    }

    public String gethFinal() {
        return hFinal;
    }

    public void sethFinal(String hFinal) {
        this.hFinal = hFinal;
    }

   
}
