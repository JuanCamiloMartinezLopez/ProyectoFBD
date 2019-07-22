
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author danbr
 */
public class Avisos extends JFrame{
    
    private final JLabel img=new JLabel();
    
    public Avisos(String Imagen){
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Imagenes/"+Imagen+".png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(505,205, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        img.setBounds(0,0,505,205);
        img.setIcon(iconoEscalado);
    
        c.add(img);
        
    }
    
    public void mostrar() {
        
        setSize(505, 225);
        setVisible(true);

    }
}
