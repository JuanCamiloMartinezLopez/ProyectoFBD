package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.AsignacionCita;
import util.CaException;

/**
 *
 * @author danbr
 */
public class BorrarCita extends JFrame implements ActionListener {

    JLabel texto = new JLabel("Ingrese Id de la cita que desea Cancelar: ");
    JButton cancelar = new JButton("Cancelar");
    JButton volver = new JButton("Volver");
    JTextField idCita = new JTextField();

    public AsignacionCita AC;

    public Avisos aviso;

    public BorrarCita() {

        AC = AsignacionCita.getInstance();
        aviso = new Avisos();
        setResizable(false);
        this.getContentPane().setBackground(Color.gray);
        setLayout(null);
        Container c = getContentPane();

        c.add(texto);
        texto.setBounds(20, 20, 250, 20);

        c.add(idCita);
        idCita.setBounds(250, 20, 50, 20);

        c.add(cancelar);
        cancelar.setBounds(320, 20, 90, 20);
        cancelar.addActionListener(this);

        c.add(volver);
        volver.setBounds(420, 20, 70, 20);
        volver.addActionListener(this);

    }

    public void mostrar() {

        setSize(500, 80);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cancelar) {

            try {
                if (!idCita.getText().isEmpty()) {
                    AC.eliminarCita(idCita.getText());
                    this.dispose(); 
                    Opciones O = new Opciones();
                    O.mostrar();
                    aviso.mostrar();
                    aviso.setText("Cita cancelada");
                } else {
                    aviso.mostrar();
                    aviso.setText("Ingrese el ID");
                }

            } catch (CaException ex) {
                Logger.getLogger(BorrarCita.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (e.getSource() == volver) {
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
        }

    }

}
