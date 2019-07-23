package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import negocio.Agenda;
import negocio.AsignacionCita;
import util.CaException;

/**
 *
 * @author danbr
 */
class TablaCitas extends JFrame implements ActionListener {

    JLabel datos = new JLabel("Ingrese Id de la cita deseada: ");
    JButton agendar = new JButton("Agendar");
    JButton volver = new JButton("Volver");
    JTextField idCita = new JTextField();
    JPanel jp = new JPanel();
    JTable table;

    public AsignacionCita AC;
    public Agenda[] agendas;
    public Avisos aviso;

    public TablaCitas() {

        AC = AsignacionCita.getInstance();
        aviso = new Avisos();

        setResizable(false);
        this.getContentPane().setBackground(Color.gray);
        setLayout(null);
        Container c = getContentPane();

        c.setBackground(Color.gray);

        jp.setPreferredSize(new Dimension(700, 700));
        String[] columnNames = {"Id cita", "Médico",
            "Hora",
            "Consultorio"};
        if (AC.getCDAO().isTieneAgenda()) {
            agendas = AC.getCDAO().getAgendas().getAgendas();
            System.out.println("agendas:");
            System.out.println(agendas.length);
            Object[][] data = new Object[agendas.length][4];
            for (int i = 0; i < agendas.length; i++) {
                data[i][0] = agendas[i].getIdAgenda();
                data[i][1] = agendas[i].getMedico();
                data[i][2] = agendas[i].gethInicio();
                data[i][3] = agendas[i].getConsultorio();

            }

            table = new JTable(data, columnNames);
        } else {
            aviso.mostrar();
            aviso.setText("No hay citas");
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jp.add(jScrollPane, BorderLayout.CENTER);
        c.add(jp);
        jp.setBackground(Color.gray);
        jp.setBounds(10, 50, 600, 400);

        c.add(datos);
        datos.setBounds(100, 480, 200, 20);

        c.add(idCita);
        idCita.setBounds(280, 480, 50, 20);

        c.add(agendar);
        agendar.setBounds(360, 480, 100, 20);
        agendar.addActionListener(this);
        
        c.add(volver);
        volver.setBounds(470, 480, 100, 20);
        volver.addActionListener(this);
        
    }

    public void mostrar() {

        setSize(620, 600);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == agendar) {

            try {
                AC.calcularMayor();
                AC.agendar(idCita.getText());
                this.dispose();
                aviso.mostrar();
                aviso.setText("Cita agendada");
                Opciones O = new Opciones();
                O.mostrar();
            } catch (CaException ex) {
                Logger.getLogger(TablaCitas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else if(e.getSource() == volver) {
            this.dispose();
            EleccionCita ec = new EleccionCita();
            ec.mostrar();
        }

    }

}
