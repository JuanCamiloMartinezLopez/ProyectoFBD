
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

/**
 *
 * @author (╯°□°)╯︵ ┻━┻
 */
public class ConfirmarCita extends JFrame implements ActionListener {

    JTable tabla;
    JButton regresar = new JButton("Regresar");
    JPanel jp = new JPanel();

    public ConfirmarCita() {
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        jp.setPreferredSize(new Dimension(700, 700));
        String[] columnNames = {"Id cita","Médico","Fecha",
            "Hora","Tipo consulta","Sede",
            "Consultorio"};
        Object[][] data = {
            {"1","Kathy", "24/07/2019" ,"8 am",
                "Primera Vez", "Suba" , "204"},
            {"5","Joe", "31/08/2019","11 am",
                "General", "Suba" , "311"},
            {"3","Sue", "12/01/2020", "10 am",
                "Especialista", "Bosa", "209"}
        };

        tabla = new JTable(data, columnNames);
        
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
       
        if(e.getSource()==regresar){
            
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
            
        }
    
    }

}
