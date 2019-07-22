package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author danbr
 */
public class Avisos extends JFrame {

    private final JLabel img = new JLabel();

    public Avisos(String mensaje) {
        
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();

        img.setBounds(75, 0, 150, 50);
        img.setForeground(Color.BLACK);
        img.setText(mensaje);
        img.setHorizontalAlignment(SwingConstants.CENTER);

        c.add(img);

    }

    public void mostrar() {

        setSize(300, 70);
        setVisible(true);

    }
}
