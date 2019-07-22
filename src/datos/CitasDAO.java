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

    private boolean existeUsuario = false;
    private boolean existePaciente = false;
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
            String strSQL = "SELECT * FROM usuario WHERE k_identificacion=" + id + " AND contrasea='" + contraseña + "';";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                usuario.setIdentificacion(rs.getString(1));
                usuario.setTipo_id(rs.getString(2));
                usuario.setContraseña(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setTelefono_fijo(rs.getString(5));
                usuario.setTelefono_cel(rs.getString(6));
                usuario.setSexo(rs.getString(7));
                usuario.setNombre(rs.getString(8));
                usuario.setFecha(rs.getString(9));

                existeUsuario = true;
            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo logearse " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
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
            //prepStmt.close();
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
            prepStmt.setInt(1, Integer.parseInt(paciente.getIdentificacion()));
            prepStmt.setString(2, paciente.getParentesco());
            prepStmt.setInt(3, Integer.parseInt(paciente.getIdAfiliado()));
            prepStmt.setString(4, paciente.getEstado());
            prepStmt.setString(5, paciente.getEstado_multa());
            prepStmt.setInt(6, Integer.parseInt(paciente.getCategoria()));
            prepStmt.executeUpdate();
            //prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo crear el paciente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void validarPaciente() throws CaException {
        try {
            String strSQL = "SELECT * FROM afiliado WHERE k_identificacion=" + usuario.getIdentificacion() + ";";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                paciente.setIdentificacion(rs.getString(1));
                paciente.setParentesco(rs.getString(2));
                paciente.setIdAfiliado(rs.getString(3));
                paciente.setEstado(rs.getString(4));
                paciente.setEstado_multa(rs.getString(5));
                paciente.setCategoria(rs.getString(6));
                existePaciente = true;
            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo logearse " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void traerCategoria() throws CaException {
        try {
            String strSQL = "SELECT * FROM categoria WHERE k_id_categoria=" + paciente.getCategoria() + ";";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                categoria.setIdCategoria(rs.getString(1));
                categoria.setvCopago(rs.getString(2));
                categoria.setvMulta(rs.getString(3));

            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo logearse " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificarEstadoPaciente() throws CaException {
        try {
            String estado;
            if (paciente.getEstado() == "Activo") {
                estado = "Inactivo";
            } else {
                estado = "Activo";
            }
            String strSQL = "UPDATE public.afiliado\n"
                    + "   SET i_estado= '" + estado + "'\n"
                    + " WHERE k_identificacion =" + paciente.getIdentificacion() + ";";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.executeUpdate();
            //prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo modificar estado" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void consultarAgenda(String especialidad,String idSede,String yyyy,String mm, String dd,String tCita) throws CaException {
        try {
            String strSQL = "SELECT * FROM agenda a, sede s,especialidad e, medico m, consultorio c"
                    + "WHERE m.k_identificacion=a.k_identificacion"
                    + "AND e.k_codigo=m.k_codigo_especiali"
                    + "AND s.k_id_sede=c.k_id_sede"
                    + "AND e.k_codigo="+especialidad+" "
                    + "AND s.k_id_sede='"+idSede+"'"
                    + "AND a.fecha ='"+yyyy+"-"+mm+"-"+dd+"';";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                paciente.setIdentificacion(rs.getString(1));
                paciente.setParentesco(rs.getString(2));
                paciente.setIdAfiliado(rs.getString(3));
                paciente.setEstado(rs.getString(4));
                paciente.setEstado_multa(rs.getString(5));
                paciente.setCategoria(rs.getString(6));
                existePaciente = true;
            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo logearse " + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public boolean isExiste() {
        return existeUsuario;
    }

    public boolean isExistePaciente() {
        return existePaciente;
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
