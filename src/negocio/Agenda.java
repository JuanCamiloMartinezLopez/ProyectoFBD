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
    private Medico medico;
    private Tipo_cita tCita;

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Tipo_cita gettCita() {
        return tCita;
    }

    public void settCita(Tipo_cita tCita) {
        this.tCita = tCita;
    }
    
}
