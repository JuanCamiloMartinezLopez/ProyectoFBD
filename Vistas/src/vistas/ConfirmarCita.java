/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author (╯°□°)╯︵ ┻━┻
 */
public class ConfirmarCita extends JFrame implements ActionListener {

    JLabel txtDia = new JLabel("La cita esta asgindad para el día:");
    JLabel dia = new JLabel("dia tales ");

    JLabel txMedico = new JLabel("Con el médico:");
    JLabel medico = new JLabel("ESTO LO HIZO ZABALA");

    JLabel txtSede = new JLabel("En la sede");
    JLabel sede = new JLabel("sede tales");

    JLabel txtConsultiro = new JLabel("En el consultorio:");
    JLabel consultiro = new JLabel("el consultiro tales");

    JButton confirmar = new JButton("confirmar");

    public ConfirmarCita() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        c.add(txtDia);
        txtDia.setBounds(30, 30, 100, 20);
        
        c.add(dia);
        dia.setBounds(300, 30, 100, 20);
        
        c.add(txMedico);
        txMedico.setBounds(30, 60, 100, 20);
        
        c.add(medico);
        medico.setBounds(300, 60, 300, 20);
        
        c.add(txtSede);
        txtSede.setBounds(30, 90, 100, 20);
        
        c.add(sede);
        sede.setBounds(300, 90, 100, 20);
        
        c.add(txtConsultiro);
        txtConsultiro.setBounds(30, 120, 100, 20);
        
        c.add(consultiro);
        consultiro.setBounds(300, 120, 100, 20);
        
        c.add(confirmar);
        confirmar.setBounds(450, 450, 100, 20);
        confirmar.addActionListener(this);
        
    }

    public void mostrar() {
        setSize(600, 700);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==confirmar){
            
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
            
        }
    
    }

}
