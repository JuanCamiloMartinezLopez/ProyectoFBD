package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import negocio.AsignacionCita;
import util.CaException;

public class Opciones extends JFrame implements ActionListener {

    JButton info = new JButton("Ver informacion del usuario");
    JButton consultar = new JButton("Consultar citas agendadas");
    JButton agendar = new JButton("Agendar una cita");
    JButton cancelar = new JButton("Cancelar una cita");
    JButton cerrar = new JButton("Cerrar sesión");

    public Avisos aviso;

    public AsignacionCita AC = AsignacionCita.getInstance();

    public boolean Multado = false;
    public boolean Inactivo = false;

    public Opciones() {

        aviso = new Avisos();

        if ("Multado".equals(AC.getCDAO().getPaciente().getEstado_multa())) {
            Multado = true;
        }

        if ("Inactivo".equals(AC.getCDAO().getPaciente().getEstado()) || "Retirado".equals(AC.getCDAO().getPaciente().getEstado())) {
            Inactivo = true;
        }

        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();

        c.setBackground(Color.gray);

        c.add(info);
        info.setBounds(30, 20, 230, 20);
        info.addActionListener(this);

        c.add(consultar);
        consultar.setBounds(30, 60, 230, 20);
        consultar.addActionListener(this);

        c.add(agendar);
        agendar.setBounds(30, 100, 230, 20);
        agendar.addActionListener(this);

        c.add(cancelar);
        cancelar.setBounds(30, 140, 230, 20);
        cancelar.addActionListener(this);

        c.add(cerrar);
        cerrar.setBounds(80, 180, 130, 20);
        cerrar.addActionListener(this);
    }

    public void mostrar() {

        setSize(300, 250);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == consultar) {

            this.dispose();
            try {
                AC.Ncitas();
                AC.consultarCitas();
            } catch (CaException ex) {
                Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConfirmarCita cc = new ConfirmarCita();
            cc.mostrar();

        } else if (e.getSource() == agendar && !Multado && !Inactivo) {
            this.dispose();
            EleccionCita ec = new EleccionCita();
            ec.mostrar();

        } else if (e.getSource() == agendar && (Multado || Inactivo)) {

            aviso.setText("Multado o Inactivo");
            aviso.mostrar();

        } else if (e.getSource() == cancelar) {

            this.dispose();
            BorrarCita bc = new BorrarCita();
            bc.mostrar();

        } else if (e.getSource() == cerrar) {

            this.dispose();
            Ingreso i = new Ingreso();
            i.mostrar();

        } else if (e.getSource() == info) {

            this.dispose();
            Datos o = new Datos();
            o.mostrar();
        }

    }

}
