

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author danbr
 */
class TablaCitas extends JFrame implements ActionListener{
    
    JLabel datos = new JLabel("Ingrese Id de la cita deseada: ");
    JButton agendar = new JButton("Agendar y volver");
    JTextField idCita = new JTextField();
    JPanel jp = new JPanel();
    
    public TablaCitas(){
        
        setResizable(false);
        this.getContentPane().setBackground(Color.gray);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        jp.setPreferredSize(new Dimension(700, 700));
        String[] columnNames = {"Id cita","Médico",
            "Hora",
            "Disponibilidad",
            "Consultorio"};
        Object[][] data = {
            {"1","Kathy", "8 am",
                new Boolean(false), "204"},
            {"2","John", "7 am",
                new Boolean(true), "311"},
            {"3","Sue", "10 am",
                new Boolean(true), "209"},
            {"4","Jane", "8 am",
                new Boolean(false), "405"},
            {"5","Joe", "11am",
                new Boolean(true), "610"}
        };

        JTable table = new JTable(data, columnNames);
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
        agendar.setBounds(360, 480, 150, 20);
        agendar.addActionListener(this);
    }
    
    public void mostrar() {
        
        setSize(620, 600);
        setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==agendar){
            
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
            
        }
                
    }
    
}
