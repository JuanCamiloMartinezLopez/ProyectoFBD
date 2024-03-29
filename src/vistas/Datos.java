
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.AsignacionCita;
import negocio.Paciente;
import negocio.Usuario;

/**
 *
 * @author danbr
 */
public class Datos extends JFrame implements ActionListener{
    
    AsignacionCita AC=AsignacionCita.getInstance();
    
    Usuario user;
    Paciente afiliado;

    JLabel inicio = new JLabel("Informacion del usuario");
    JLabel identificacion = new JLabel("Numero de identificación:");
    JLabel tipoDoc = new JLabel("Tipo de documento:");
    JLabel nombre = new JLabel("Nombre:");
    JLabel apellido = new JLabel("Apellidos:");
    JLabel fechaN = new JLabel("Fecha de nacimiento:");
    JLabel telefonoFijo = new JLabel("Telefono fijo:");
    JLabel telefonoMovil = new JLabel("Telefono Movil:");
    JLabel email = new JLabel("eMail:");
    JLabel tipoU = new JLabel("Tipo de usuario:");
    JLabel cate = new JLabel("Categoria:");
    JLabel estado = new JLabel("Estado:");
    JLabel multa = new JLabel("Multa:");
    
    JTextField tId = new JTextField();
    JTextField tDoc = new JTextField();
    JTextField tNombre = new JTextField();
    JTextField tApellido = new JTextField();
    JTextField tUsuario = new JTextField();
    JTextField tCategoria = new JTextField();
    JTextField tTelF = new JTextField();
    JTextField tTelM = new JTextField();
    JTextField tEmail = new JTextField();
    JTextField tFn = new JTextField();
    JTextField tMulta = new JTextField();
    JTextField tEstado = new JTextField();
       
    JButton cerrar = new JButton("Regresar");
    
    public Datos(){
        
        user = AC.getCDAO().getUsuario();
        afiliado=AC.getCDAO().getPaciente();
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        c.setBackground(Color.gray);
        
        c.add(inicio);
        inicio.setBounds(180, 20, 300, 20);
        
        c.add(identificacion);
        identificacion.setBounds(50, 50, 200, 20);
        c.add(tId);
        tId.setText(user.getIdentificacion());
        tId.setBounds(225, 50, 200, 20);
        
        c.add(tipoDoc);
        tipoDoc.setBounds(50, 90, 200, 20);
        c.add(tDoc);
        tDoc.setText(user.getTipo_id());
        tDoc.setBounds(225, 90, 200, 20);
        
        c.add(nombre);
        nombre.setBounds(50, 130, 200, 20);
        c.add(tNombre);
        tNombre.setText(user.getNombre());
        tNombre.setBounds(225, 130, 200, 20);
        
        /*c.add(apellido);
        apellido.setBounds(50, 170, 200, 20);
        c.add(tApellido);
        tApellido.setBounds(225, 170, 200, 20);*/
        
        c.add(fechaN);
        fechaN.setBounds(50, 170, 200, 20);
        c.add(tFn);
        tFn.setText(user.getFecha());
        tFn.setBounds(225, 170, 200, 20);
        
        c.add(telefonoFijo);
        telefonoFijo.setBounds(50, 210, 200, 20);
        c.add(tTelF);
        tTelF.setText(user.getTelefono_fijo());
        tTelF.setBounds(225, 210, 200, 20);
        
        c.add(telefonoMovil);
        telefonoMovil.setBounds(50, 250, 200, 20);
        c.add(tTelM);
        tTelM.setText(user.getTelefono_cel());
        tTelM.setBounds(225, 250, 200, 20);
        
        c.add(email);
        email.setBounds(50, 290, 200, 20);
        c.add(tEmail);
        tEmail.setText(user.getEmail());
        tEmail.setBounds(225, 290, 200, 20);
        
        c.add(tipoU);
        tipoU.setBounds(50, 330, 200, 20);
        c.add(tUsuario);
        if(afiliado.getParentesco()=="null"){
            tUsuario.setText("Cotizante");
        }else{
            tUsuario.setText("Beneficiario");
        }
        tUsuario.setBounds(225, 330, 200, 20);
        
        c.add(cate);
        cate.setBounds(50, 370, 200, 20);
        c.add(tCategoria);
        tCategoria.setText(afiliado.getCategoria());
        tCategoria.setBounds(225, 370, 200, 20);
        
        c.add(estado);
        estado.setBounds(50, 410, 200, 20);
        c.add(tEstado);
        tEstado.setText(afiliado.getEstado());
        tEstado.setBounds(225, 410, 200, 20);
        
        c.add(multa);
        multa.setBounds(50, 450, 200, 20);
        c.add(tMulta);
        tMulta.setText(afiliado.getEstado_multa());
        tMulta.setBounds(225, 450, 200, 20);
        
        c.add(cerrar);
        cerrar.addActionListener(this);
        cerrar.setBounds(120, 510, 200, 20);
        
        
    }
    
    public void mostrar() {
        
        setSize(490, 600);
        setVisible(true);

    }    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==cerrar){
        
            this.dispose();
            Opciones O = new Opciones();
            O.mostrar();
            
        }
        
    }
    
}
