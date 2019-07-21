
package negocio;

import datos.CitasDAO;
import util.CaException;

/**
 *
 * @author CAMILO
 */
public class AsignacionCita {
    private CitasDAO CDAO;
    
    public AsignacionCita(){
        CDAO = new CitasDAO();
    }
    
    public boolean validarpaciente(String id, String contraseña) throws CaException {
        return CDAO.ValidarAfiliado(id, contraseña);
    }

    public CitasDAO getCDAO() {
        return CDAO;
    }
    
    
    
    
    
}
