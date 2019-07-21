
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author danbr
 */
public class BorrarCita extends JFrame implements ActionListener{

    JLabel texto = new JLabel("Ingrese Id de la cita que desea Cancelar: ");
    JButton cancelar = new JButton("Cancelar y volver");
    JTextField idCita = new JTextField();
    
    public BorrarCita(){
        
        setResizable(false);
        this.getContentPane().setBackground(Color.gray);
        setLayout(null);
        Container c = getContentPane();
        
        c.add(texto);
        texto.setBounds(20, 20, 250, 20);
        
        c.add(idCita);
        idCita.setBounds(250, 20, 50, 20);
        
        c.add(cancelar);
        cancelar.setBounds(340, 20, 150, 20);
        cancelar.addActionListener(this);
        
    }
    
    public void mostrar() {
        
        setSize(500, 80);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==cancelar){
        
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
            
        }
        
    }
    
}
