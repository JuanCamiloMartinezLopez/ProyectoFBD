package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Agenda;
import negocio.Agendas;
import negocio.Categoria;
import negocio.Cita;
import negocio.Citas;
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
    private boolean tieneCitas = false;
    private boolean tieneAgenda = false;
    private Agenda agenda;
    private Agendas agendas;
    private Categoria categoria;
    private Cita cita;
    private Citas citas;
    private Consultorio consultorio;
    private Especialidad especialidad;
    private Paciente paciente;
    private Usuario usuario;
    private Medico medico;
    private Multa multa;
    private Sede sede;
    private Tipo_cita tCita;
    private int id_cita;

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    public Agendas getAgendas() {
        return agendas;
    }

    public void setAgendas(Agendas agendas) {
        this.agendas = agendas;
    }

    public CitasDAO(){
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
    

    public void agregarCita(String id_agenda) throws CaException {
        try {
            for(int i=0;i<agendas.getAgendas().length;i++){
                if(id_agenda.equals(agendas.getAgendas()[i].getIdAgenda())){
                    agenda=agendas.getAgendas()[i];
                }
            }
            String strSQL = "INSERT INTO cita(f_cita, k_id_cita, i_estado, prescripcion, diagnostico, k_id_agenda, k_identificacion, k_id_multa)\n"
                    + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setDate(1, Date.valueOf(agenda.getFecha()));
            prepStmt.setInt(2, id_cita);
            prepStmt.setString(3, "Pendiente");
            prepStmt.setNull(4, java.sql.Types.VARCHAR);
            prepStmt.setNull(5, java.sql.Types.VARCHAR);
            prepStmt.setInt(6, Integer.valueOf(agenda.getIdAgenda()));
            prepStmt.setInt(7, Integer.valueOf(paciente.getIdentificacion()));
            prepStmt.setNull(8,java.sql.Types.INTEGER );
           
            prepStmt.executeUpdate();
            //prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No pudo crear el Usuario" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void ConsultarId_cita() throws CaException {

        try {
            String strSQL = "SELECT MAX (k_id_cita)FROM cita;";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                id_cita = Integer.parseInt(rs.getString(1)) + 1;
            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No se encontro mayor " + e.getMessage());
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

    public void consultarCitas() throws CaException {
        try {
            String strSQL = "SELECT ct.f_cita,ct.k_id_cita,ag.h_inicio,ag.k_id_tipo,s.n_nombre,m.k_id_consultirio FROM sede s, consultorio c, medico m, agenda ag, afiliado aa, usuario u, tipo_cita t,cita ct WHERE s.k_id_sede=c.k_id_sede AND  c.k_id_consultirio=m.k_id_consultirio AND  t.k_id_tipo=ag.k_id_tipo AND m.k_identificacion=ag.k_identificacion AND ag.fecha=ct.f_cita AND u.k_identificacion=aa.k_identificacion AND ct.k_id_agenda=ag.k_id_agenda AND aa.k_identificacion=" + paciente.getIdentificacion() + " AND ct.i_estado='Pendiente';";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            System.out.println(rs.getRow());
            if (rs.getRow() > 0) {
                citas = new Citas(rs.getRow());
                tieneCitas = true;
            }
            int i = 0;
            while (rs.next()) {
                citas.getCitas()[i].setFecha(rs.getString(1));
                citas.getCitas()[i].setIdCita(rs.getString(2));
                citas.getCitas()[i].setHora(rs.getString(3));
                citas.getCitas()[i].setTipo_consulta(rs.getString(4));
                citas.getCitas()[i].setSede(rs.getString(5));
                citas.getCitas()[i].setConsultrio(rs.getString(6));
            }

        } catch (SQLException e) {
            throw new CaException("CitasDAO", "no pudo traer las citas " + e.getMessage());
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

    public void cancelarCita(String idCita) throws CaException {
        try {
            String strSQL = "DELETE FROM public.cita"
                    + " WHERE k_id_cita =" + idCita + " AND k_identificacion=" + usuario.getIdentificacion() + ";";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.executeUpdate();
            //prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("CitasDAO", "No se pudo eliminar la cita " + idCita + " ." + e.getMessage());
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

    public void consultarAgenda(String especialidad, String idSede, String yyyy, String mm, String dd, String tCita, String horario) throws CaException {
        try {
            String strSQL = "SELECT a.k_id_agenda,u.n_persona,a.h_inicio,c.k_id_consultirio"
                    + "FROM agenda a, sede s,especialidad e, medico m, consultorio c,usuario u"
                    + "WHERE m.k_identificacion=a.k_identificacion"
                    + "AND e.k_codigo=m.k_codigo_especiali"
                    + "AND s.k_id_sede=c.k_id_sede"
                    + "AND c.k_id_consultirio=m.k_id_consultirio"
                    + "AND m.k_identificacion=u.k_identificacion"
                    + "AND e.n_nombre='" + especialidad + "' "
                    + "AND s.n_nombre='" + idSede + "'"
                    + "AND a.fecha ='" + yyyy + "-" + mm + "-" + dd + "'"
                    + "AND a.k_id_tipo='" + tCita + "'"
                    + "AND m.franja='" + horario + "';";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            System.out.println(rs.getRow());
            if (rs.getRow() > 0) {
                agendas = new Agendas(rs.getRow());
                tieneAgenda = true;
            }
            int i = 0;
            while (rs.next()) {
                agenda.setIdAgenda(rs.getString(1));
                agenda.setMedico(rs.getString(2));
                agenda.sethInicio(rs.getString(3));
                agenda.setConsultorio(rs.getString(4));

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

    public boolean isTieneCitas() {
        return tieneCitas;
    }

    public void setTieneCitas(boolean tieneCitas) {
        this.tieneCitas = tieneCitas;
    }

    public boolean isTieneAgenda() {
        return tieneAgenda;
    }

    public void setTieneAgenda(boolean tieneAgenda) {
        this.tieneAgenda = tieneAgenda;
    }

}
