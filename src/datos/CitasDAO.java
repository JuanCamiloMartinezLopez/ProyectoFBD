package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Agenda;
import negocio.Categoria;
import negocio.Cita;
import negocio.Consultorio;
import negocio.Especialidad;
import negocio.Medico;
import negocio.Multa;
import negocio.Paciente;
import negocio.Sede;
import negocio.Tipo_cita;
import negocio.Usuario;

import util.CaException;
import util.ServiceLocator;

/**
 *
 * @author CAMILO
 */
public class CitasDAO {

    private boolean existe = false;
    private Agenda agenda;
    private Categoria categoria;
    private Cita cita;
    private Consultorio consultorio;
    private Especialidad especialidad;
    private Paciente paciente;
    private Usuario usuario;
    private Medico medico;
    private Multa multa;
    private Sede sede;
    private Tipo_cita tCita;

    public CitasDAO() {
        this.agenda = new Agenda();
        this.categoria = new Categoria();
        this.cita = new Cita();
        this.consultorio = new Consultorio();
        this.especialidad = new Especialidad();
        this.multa = new Multa();
        this.sede = new Sede();
        this.tCita = new Tipo_cita();
        this.paciente = new Paciente();
        this.usuario = new Usuario();
        this.medico = new Medico();

    }

    public void ValidarUsuario(String id, String contraseña) throws CaException {

        try {
            String strSQL = "SELECT * FROM usuario WHERE k_identificacion=" + id + " AND contrasea='" + contraseña + "'";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()) {
                    usuario.setIdentificacion(rs.getString(1));
                    usuario.setTipo_id(rs.getString(2));
                    usuario.setContraseña(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setTelefono_fijo(rs.getString(5));
                    usuario.setTelefono_cel(rs.getString(6));
                    usuario.setSexo(rs.getString(7));
                    usuario.setNombre(rs.getString(8));
                    usuario.setFecha(rs.getString(9));
            }
            existe = true;
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo logearse " + e.getMessage());
        }
    }

    public void registrarUsuario() throws CaException {
        try {

            String strSQL = "INSERT INTO usuario( k_identificacion, i_tipo_document, contrasea, \"eMail\", q_tel_fijo, q_tel_cel, i_sexo, n_persona, f_nacimiento)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, Integer.parseInt(usuario.getIdentificacion()));
            prepStmt.setString(2, usuario.getTipo_id());
            prepStmt.setString(3, usuario.getContraseña());
            prepStmt.setString(4, usuario.getEmail());
            prepStmt.setString(5, usuario.getTelefono_fijo());
            prepStmt.setString(6, usuario.getTelefono_cel());
            prepStmt.setString(7, usuario.getSexo());
            prepStmt.setString(8, usuario.getNombre());
            prepStmt.setDate(9, Date.valueOf(usuario.getFecha()));
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo crear el Usuario" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void registrarPaciente() throws CaException {
        try {

            String strSQL = "INSERT INTO afiliado(k_identificacion, parentezco, k_identificacion_afiliado, i_estado, i_estado_multa, k_id_categoria)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, Integer.parseInt(usuario.getIdentificacion()));
            prepStmt.setString(2, usuario.getTipo_id());
            prepStmt.setString(3, usuario.getContraseña());
            prepStmt.setString(4, usuario.getEmail());
            prepStmt.setString(5, usuario.getTelefono_fijo());
            prepStmt.setString(6, usuario.getTelefono_cel());
            prepStmt.setString(7, usuario.getSexo());
            prepStmt.setString(8, usuario.getNombre());
            prepStmt.setDate(9, Date.valueOf(usuario.getFecha()));
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo crear el Usuario" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void traerCategoria(){
        
    }

    public boolean isExiste() {
        return existe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Tipo_cita gettCita() {
        return tCita;
    }

    public void settCita(Tipo_cita tCita) {
        this.tCita = tCita;
    }

}
