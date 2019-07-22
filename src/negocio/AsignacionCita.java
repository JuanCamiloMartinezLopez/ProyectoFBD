
package negocio;

import datos.CitasDAO;
import util.CaException;

/**
 *
 * @author CAMILO
 */
public class AsignacionCita {
    private static AsignacionCita instance = null;
    private CitasDAO CDAO;
    
    public static AsignacionCita getInstance() {
		if (instance == null) {
			try {
				instance = new AsignacionCita();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
    
    
    public AsignacionCita(){
        CDAO = new CitasDAO();
    }
    
    public boolean validarUsuario(String id, String contraseña) throws CaException {
        CDAO.ValidarUsuario(id, contraseña);
        return CDAO.isExiste();
    }
    
    public void registrarUsuario() throws CaException{
        CDAO.registrarUsuario();
    }

    public CitasDAO getCDAO() {
        return CDAO;
    }
    
    
    
    
    
}
