package negocio;

/**
 *
 * @author CAMILO
 */
public class Multa {
    private String estado;
    private String vMulta;
    private String idMulta;
    
    public Multa(){
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getvMulta() {
        return vMulta;
    }

    public void setvMulta(String vMulta) {
        this.vMulta = vMulta;
    }

    public String getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(String idMulta) {
        this.idMulta = idMulta;
    }
    
}
