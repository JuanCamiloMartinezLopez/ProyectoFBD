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

    public Avisos() {

        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        img.setBounds(75, 0, 150, 50);
        img.setForeground(Color.BLACK);
        img.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(img);
        setSize(300, 70);
    }

    public void setText(String mensaje) {
        img.setText(mensaje);
    }

    public void mostrar() {
        setVisible(true);
    }
}
