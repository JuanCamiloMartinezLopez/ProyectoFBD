package negocio;
/**
 *
 * @author CAMILO
 */
public class Medico extends Usuario {
    private Boolean tiene_agenda;
    private String franja;
    private Especialidad especialidad;
    private Consultorio consultorio;
    
    public Boolean getTiene_agenda() {
        return tiene_agenda;
    }

    public void setTiene_agenda(Boolean tiene_agenda) {
        this.tiene_agenda = tiene_agenda;
    }

    public String getFranja() {
        return franja;
    }

    public void setFranja(String franja) {
        this.franja = franja;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    
    
}
