
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import negocio.AsignacionCita;

public class Opciones extends JFrame implements ActionListener{

    String nombre;
    String apellido;
    
    JLabel jlNombre = new JLabel("Nombre:");
    
    
    JButton consultar = new JButton("Consultar citas agendadas");
    JButton agendar = new JButton("Agendar una cita");
    JButton cancelar = new JButton("Cancelar una cita");
    JButton cerrar = new JButton("Cerrar sesión");
    
    public AsignacionCita AC;
    
    public Opciones(){
        AC=AsignacionCita.getInstance();
        
        jlNombre = new JLabel("Nombre: "+AC.getCDAO().getUsuario().getNombre());
        
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        c.add(jlNombre);
        jlNombre.setBounds(30, 10, 200, 20);
        
        c.add(consultar);
        consultar.setBounds(30, 80, 230, 20);
        consultar.addActionListener(this);
        
        c.add(agendar);
        agendar.setBounds(30, 120, 230, 20);
        agendar.addActionListener(this);
        
        c.add(cancelar);
        cancelar.setBounds(30, 160, 230, 20);
        cancelar.addActionListener(this);
        
        c.add(cerrar);
        cerrar.setBounds(170,0,130,20);
        cerrar.addActionListener(this);
    }
    
    public void mostrar() {
        
        setSize(300, 230);
        setVisible(true);

    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==consultar){
            
            this.dispose();
            ConfirmarCita cc = new ConfirmarCita();
            cc.mostrar();
            
        } else if(e.getSource()==agendar){
            
            this.dispose();
            EleccionCita ec = new EleccionCita();
            ec.mostrar();
            
        } else if(e.getSource()==cancelar){
            
            this.dispose();
            BorrarCita bc = new BorrarCita();
            bc.mostrar();
            
        } else if(e.getSource()==cerrar){
        
            this.dispose();
            Ingreso i =new Ingreso();
            i.mostrar();
            
        }
        
        
        
    }
        
}
