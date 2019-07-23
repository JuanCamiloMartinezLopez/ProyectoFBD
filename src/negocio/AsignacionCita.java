
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
    
    public void calcularMayor() throws CaException{
        CDAO.ConsultarId_cita();
    }
    
    public void agendar(String id) throws CaException{
        CDAO.agregarCita(id);
    }
    
    public boolean validarUsuario(String id, String contraseña) throws CaException {
        CDAO.ValidarUsuario(id, contraseña);
        return CDAO.isExiste();
    }
    
    public boolean validarPaciente() throws CaException{
        CDAO.validarPaciente();
        return CDAO.isExistePaciente();
    }
    
    public void registrarUsuario() throws CaException{
        CDAO.registrarUsuario();
    }
    
    public void registrarPaciente() throws CaException{
        CDAO.registrarPaciente();
    }
    
    public void consultarCitas() throws CaException{
        CDAO.consultarCitas();
    }
    
    public void consultarAgenda(String especialidad, String idSede, String yyyy, String mm, String dd, String tCita, String horario) throws CaException{
        CDAO.consultarAgenda(especialidad, idSede, yyyy, mm, dd, tCita, horario);
    }
    
    public void eliminarCita(String id) throws CaException{
        CDAO.cancelarCita(id);
    }

    public CitasDAO getCDAO() {
        return CDAO;
    }
    
    
    
    
    
}
