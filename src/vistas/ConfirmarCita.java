package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import negocio.AsignacionCita;
import negocio.Cita;
import negocio.Citas;

/**
 *
 * @author (╯°□°)╯︵ ┻━┻
 */
public class ConfirmarCita extends JFrame implements ActionListener {

    JTable tabla;
    JButton regresar = new JButton("Regresar");
    JPanel jp = new JPanel();

    public AsignacionCita AC;
    public Cita[] citas;
    public Avisos aviso;

    public ConfirmarCita() {

        AC = AsignacionCita.getInstance();
        aviso = new Avisos();

        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();

        c.setBackground(Color.gray);

        jp.setPreferredSize(new Dimension(700, 700));
        String[] columnNames = {"Id cita", "Fecha",
            "Hora", "Tipo consulta", "Sede",
            "Consultorio"};
        if (AC.getCDAO().isTieneCitas()) {
            citas = AC.getCDAO().getCitas().getCitas();
            System.out.println("citas:");
            System.out.println(citas.length);
            Object[][] data = new Object[citas.length][6];
            for (int i = 0; i < citas.length; i++) {
                data[i][0] = citas[i].getIdCita();
                data[i][1] = citas[i].getMedico();
                data[i][2] = citas[i].getFecha();
                data[i][3] = citas[i].getHora();
                data[i][4] = citas[i].getTipo_consulta();
                data[i][5] = citas[i].getSede();
                data[i][6] = citas[i].getConsultrio();
            }

            tabla = new JTable(data, columnNames);
        } else {
            aviso.mostrar();
            aviso.setText("No hay citas");
        }

        JScrollPane jScrollPane = new JScrollPane(tabla);
        jScrollPane.setBounds(0, 0, 600, 200);
        c.add(jScrollPane);

        c.add(regresar);
        regresar.setBounds(170, 220, 250, 30);
        regresar.addActionListener(this);

    }

    public void mostrar() {
        setSize(600, 300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == regresar) {

            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();

        }

    }

}
