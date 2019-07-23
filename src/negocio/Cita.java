package negocio;

/**
 *
 * @author CAMILO
 */
public class Cita {

    private String fecha;
    private String idCita;
    private String medico;
    private String hora;
    private String tipo_consulta;
    private String sede;
    private String consultrio;
    private String estado;
    private String prescripcion;
    private String diagnostico;
    private String agenda;
    private String paciente;
    private String multa;

    public Cita() {

    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getConsultrio() {
        return consultrio;
    }

    public void setConsultrio(String consultrio) {
        this.consultrio = consultrio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

}
