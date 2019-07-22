
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Opciones extends JFrame implements ActionListener{

    int multa=0;
    
    JButton info = new JButton("Ver informacion del usuario");
    JButton consultar = new JButton("Consultar citas agendadas");
    JButton agendar = new JButton("Agendar una cita");
    JButton cancelar = new JButton("Cancelar una cita");
    JButton cerrar = new JButton("Cerrar sesión");
    
    public Opciones(){
    
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
        cerrar.setBounds(80,180,130,20);
        cerrar.addActionListener(this);
    }
    
    public void mostrar() {
        
        setSize(300, 250);
        setVisible(true);

    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==consultar){
            
            this.dispose();
            ConfirmarCita cc = new ConfirmarCita();
            cc.mostrar();
            
        } else if(e.getSource()==agendar && multa==0){
            
            this.dispose();
            EleccionCita ec = new EleccionCita();
            ec.mostrar();
            
        } else if(e.getSource()==agendar && multa!=0){
            
            Avisos aviso = new Avisos("denegado");
            aviso.mostrar();
            
        } else if(e.getSource()==cancelar){
            
            this.dispose();
            BorrarCita bc = new BorrarCita();
            bc.mostrar();
            
        } else if(e.getSource()==cerrar){
        
            this.dispose();
            Ingreso i = new Ingreso();
            i.mostrar();
            
        } else if(e.getSource()==info){
            
            this.dispose();
            Datos o = new Datos(); 
            o.mostrar();
        }
        
        
        
    }
        
}
