
package negocio;

/**
 *
 * @author CAMILO
 */
public class Categoria {
    private String idCategoria;
    private String vCopago;
    private String vMulta;

    public Categoria() {
    }
    
    
    
    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getvCopago() {
        return vCopago;
    }

    public void setvCopago(String vCopago) {
        this.vCopago = vCopago;
    }

    public String getvMulta() {
        return vMulta;
    }

    public void setvMulta(String vMulta) {
        this.vMulta = vMulta;
    }
    
}
