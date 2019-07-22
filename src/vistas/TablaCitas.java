

package vistas;

import java.awt.BorderLayout;
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
 * @author danbr
 */
class TablaCitas extends JFrame implements ActionListener{
    
    JTable tabla;
    JButton agendar = new JButton("Agendar citas seleccionadas y volver");
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
            "Consultorio",
            "Seleccionar"};
        Object[][] data = {
            {"1","Kathy", "8 am",
                 "204", false},
            {"2","John", "7 am",
                "311", false},
            {"3","Sue", "10 am",
                "209", false},
            {"4","Jane", "8 am",
                "405", false},
            {"5","Joe", "11 am",
                "610", false}
        };

        tabla = new JTable(data, columnNames);
        JScrollPane jScrollPane = new JScrollPane(tabla);
        tabla.getColumnModel().getColumn( 4 ).setCellEditor( new Celda_CheckBox() );
        tabla.getColumnModel().getColumn( 4 ).setCellRenderer(new Render_CheckBox()); 
        
        jp.add(jScrollPane, BorderLayout.CENTER);
        c.add(jp);
        jp.setBackground(Color.gray);
        jp.setBounds(10, 50, 600, 400);

        c.add(agendar);
        agendar.setBounds(180, 480, 250, 30);
        agendar.addActionListener(this);
    }
    
    public void mostrar() {
        
        setSize(620, 600);
        setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==agendar){
            
            for(int i=0 ; i<tabla.getColumnCount() ; i++){
            
                if("true".equals(tabla.getModel().getValueAt(i, 4).toString())){
                
                    System.out.println(i + ". " + tabla.getModel().getValueAt(i, 1));
                }
            }
            
            this.dispose();
            Opciones O = new Opciones();         
            O.mostrar();
            
        }
                
    }
    
}
