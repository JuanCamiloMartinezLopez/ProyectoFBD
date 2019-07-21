package datos;

import java.sql.Connection;
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

    private Agenda agenda;
    private Categoria categoria;
    private Cita cita;
    private Consultorio consultorio;
    private Especialidad especialidad;
    private Paciente usuario = new Paciente();
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
        this.usuario = new Paciente();
    }

    public boolean ValidarAfiliado(String id, String contraseña) throws CaException {
        boolean existe = false;
        try {

            String strSQL = "SELECT * FROM afiliado a, usuario u WHERE a.k_identificacion=u.k_identificacion AND k_identificacion= ? AND contrasea= ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, Integer.valueOf(id));
            prepStmt.setString(9, contraseña);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                usuario.setIdentificacion(rs.getString(1));
                usuario.setParentesco(rs.getString(2));
                usuario.setIdAfiliado(rs.getString(3));
                usuario.setEstado(rs.getString(4));
                usuario.setEstado_multa(rs.getString(5));
                usuario.setCategoria(rs.getString(6));
                usuario.setTipo_id(rs.getString(8));
                usuario.setContraseña(rs.getString(9));
                usuario.setEmail(rs.getString(10));
                usuario.setTelefono_fijo(rs.getString(11));
                usuario.setTelefono_cel(rs.getString(12));
                usuario.setSexo(rs.getString(13));
                usuario.setNombre(rs.getString(14));
                usuario.setFecha(rs.getString(15));

            }

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
            existe = true;
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo crear el municipio" + e.getMessage());

        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return existe;
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

    public void setUsuario(Paciente usuario) {
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
