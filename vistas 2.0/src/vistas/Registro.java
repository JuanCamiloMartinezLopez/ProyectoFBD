
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
public class Registro extends JFrame implements ActionListener{

    JLabel inicio = new JLabel("Bienvenido a nuestra sección de registro");
    JLabel identificacion = new JLabel("Numero de identificación:");
    JLabel tipoDoc = new JLabel("Tipo de documento:");
    JLabel nombre = new JLabel("Nombre:");
    JLabel apellido = new JLabel("Apellido:");
    JLabel fechaN = new JLabel("Fecha de nacimiento:");
    JLabel d = new JLabel("Dia");
    JLabel m = new JLabel("Mes");
    JLabel a = new JLabel("Año");
    JLabel sexo = new JLabel("Sexo:");
    JLabel telefonoFijo = new JLabel("Telefono fijo:");
    JLabel telefonoMovil = new JLabel("Telefono Movil:");
    JLabel email = new JLabel("eMail:");
    JLabel password = new JLabel("Contraseña:");
    JLabel tipoU = new JLabel("Tipo de usuario:");
    JLabel cate = new JLabel("Categoria:");
    
    JTextField tId = new JTextField();
    JTextField tNombre = new JTextField();
    JTextField tApellido = new JTextField();
    JTextField tTelF = new JTextField();
    JTextField tTelM = new JTextField();
    JTextField tEmail = new JTextField();
    JTextField tPass = new JTextField();
    JTextField dia = new JTextField();
    JTextField mes = new JTextField();
    JTextField año = new JTextField();
    
    JComboBox documentos = new JComboBox();
    JComboBox sexos = new JComboBox();
    JComboBox usuarios = new JComboBox();
    JComboBox categoria = new JComboBox();
    
    JButton boton = new JButton("Terminar Registro");
    
    public Registro(){
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        c.add(inicio);
        inicio.setBounds(120, 20, 300, 20);
        
        c.add(identificacion);
        identificacion.setBounds(50, 70, 200, 20);
        c.add(tId);
        tId.setBounds(225, 70, 200, 20);
        
        c.add(tipoDoc);
        tipoDoc.setBounds(50, 120, 200, 20);
        c.add(documentos);
        documentos.setBounds(225, 120, 200, 20);
        documentos.addItem("Cedula De ciudadania");
        documentos.addItem("Tarjeta de identidad");
        
        c.add(nombre);
        nombre.setBounds(50, 170, 200, 20);
        c.add(tNombre);
        tNombre.setBounds(225, 170, 200, 20);
        
        c.add(apellido);
        apellido.setBounds(50, 220, 200, 20);
        c.add(tApellido);
        tApellido.setBounds(225, 220, 200, 20);
        
        c.add(fechaN);
        fechaN.setBounds(50, 270, 300, 20);
        c.add(d);
        d.setBounds(225, 250, 200, 20);
        c.add(dia);
        dia.setBounds(225, 270, 20, 20);
        c.add(m);
        m.setBounds(315, 250, 200, 20);
        c.add(mes);
        mes.setBounds(315, 270, 20, 20);
        c.add(a);
        a.setBounds(405, 250, 200, 20);
        c.add(año);
        año.setBounds(405, 270, 20, 20);
        
        
        c.add(sexo);
        sexo.setBounds(50, 320, 200, 20);
        c.add(sexos);
        sexos.setBounds(225, 320, 200, 20);
        sexos.addItem("M");
        sexos.addItem("F");
        
        c.add(telefonoFijo);
        telefonoFijo.setBounds(50, 370, 200, 20);
        c.add(tTelF);
        tTelF.setBounds(225, 370, 200, 20);
        
        c.add(telefonoMovil);
        telefonoMovil.setBounds(50, 420, 200, 20);
        c.add(tTelM);
        tTelM.setBounds(225, 420, 200, 20);
        
        c.add(email);
        email.setBounds(50, 470, 200, 20);
        c.add(tEmail);
        tEmail.setBounds(225, 470, 200, 20);
        
        c.add(password);
        password.setBounds(50, 520, 200, 20);
        c.add(tPass);
        tPass.setBounds(225, 520, 200, 20);
        
        c.add(tipoU);
        tipoU.setBounds(50, 570, 200, 20);
        c.add(usuarios);
        usuarios.setBounds(225, 570, 200, 20);
        usuarios.addItem("Cotizante");
        usuarios.addItem("Beneficiario");
        
        c.add(cate);
        cate.setBounds(50, 620, 200, 20);
        c.add(categoria);
        categoria.setBounds(225, 620, 200, 20);
        categoria.addItem("1");
        categoria.addItem("2");
        categoria.addItem("3");
        
        c.add(boton);
        boton.addActionListener(this);
        boton.setBounds(120, 650, 200, 20);
    }
    
    public void mostrar() {
        
        setSize(490, 700);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==boton && !"".equals(tId.getText())){
        
            this.dispose();
            
            Ingreso i = new Ingreso();
            i.mostrar();
            
        } else {
            
            Avisos advertencia = new Avisos("suplantado");
            advertencia.mostrar();
            
        }
        
    }
    
}