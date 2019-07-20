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
    private Usuario usuario;
    private Multa multa;
    private Sede sede;
    private Tipo_cita tCita;

    public CitasDAO(String user) {
        this.agenda = new Agenda();
        this.categoria = new Categoria();
        this.cita = new Cita();
        this.consultorio = new Consultorio();
        this.especialidad = new Especialidad();
        this.multa = new Multa();
        this.sede = new Sede();
        this.tCita = new Tipo_cita();

        if (user == "medico") {
            this.usuario = new Medico();
        }
        if (user == "paciente") {
            this.usuario = new Paciente();
        }

    }

}
