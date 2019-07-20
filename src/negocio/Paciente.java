package negocio;

/**
 *
 * @author CAMILO
 */
public class Paciente extends Usuario {
    private String parentesco;
    private String idAfiliado;
    private String estado;
    private String estado_multa;
    private Categoria categoria;
    
    public Paciente(){
        
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String par) {
        this.parentesco = par;
    }

    public String getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(String idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado_multa() {
        return estado_multa;
    }

    public void setEstado_multa(String estado_multa) {
        this.estado_multa = estado_multa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
