package negocio;

/**
 *
 * @author CAMILO
 */
public class Consultorio {
    private String idConsultorio;
    private String tipo;
    private String descripcionEquipo;
    private Sede sede;
    
    public Consultorio(){
        
    }

    public String getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(String idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
}
