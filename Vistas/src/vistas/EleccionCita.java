
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author danbr
 */
class EleccionCita extends JFrame implements ActionListener{

    JLabel texto = new JLabel("Seleccione sus preferencias para la cita");
    JLabel d = new JLabel("Dia:");
    JLabel m = new JLabel("Mes:");
    JLabel a = new JLabel("Año:");
    JLabel sede = new JLabel("Sede:");
    JLabel consulta = new JLabel("Tipo Consulta:");
    JLabel horario = new JLabel("Horario");
    
    JComboBox listaSedes = new JComboBox();
    JComboBox listaConsultas = new JComboBox();
    JComboBox listaHorario = new JComboBox();
    
    JTextField dia = new JTextField();
    JTextField mes = new JTextField();
    JTextField año = new JTextField();
    
    JButton confirmar = new JButton("Confirmar");
    
    public EleccionCita(){
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        c.add(d);
        d.setBounds(20, 20, 200, 20);
        c.add(dia);
        dia.setBounds(70, 20, 40, 20);
        c.add(m);
        m.setBounds(20, 50, 200, 20);
        c.add(mes);
        mes.setBounds(70, 50, 40, 20);
        c.add(a);
        a.setBounds(20, 80, 200, 20);
        c.add(año);
        año.setBounds(70, 80, 40, 20);
        
        c.add(sede);
        sede.setBounds(130, 20, 100, 20);
        c.add(listaSedes);
        listaSedes.setBounds(240, 20, 100, 20);
        listaSedes.addItem("Chapinero");
        listaSedes.addItem("Kennedy");
        listaSedes.addItem("Bosa");
        listaSedes.addItem("Suba");
        
        c.add(horario);
        horario.setBounds(130, 50, 100, 20);
        c.add(listaHorario);
        listaHorario.setBounds(240, 50, 100, 20);
        listaHorario.addItem("Mañana");
        listaHorario.addItem("Tarde");
        listaHorario.addItem("Noche");
        
        c.add(consulta);
        consulta.setBounds(130, 80, 100, 20);
        c.add(listaConsultas);
        listaConsultas.setBounds(240, 80, 100, 20);
        listaConsultas.addItem("General");
        listaConsultas.addItem("Especialista");
        listaConsultas.addItem("Primera vez");

        c.add(confirmar);
        confirmar.setBounds(130, 110, 100, 20);
        confirmar.addActionListener(this);
        
    }
    
    public void mostrar() {
        
        setSize(370, 200);
        setVisible(true);

    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==confirmar){
        
            this.dispose();
            TablaCitas tc = new TablaCitas();
            tc.mostrar();
            
        }
        
    }
    
}
