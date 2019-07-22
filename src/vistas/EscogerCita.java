/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author (╯°□°)╯︵ ┻━┻
 */
public class EscogerCita extends JFrame implements ActionListener {

    JLabel datos = new JLabel("datos del usu");
    JButton agendar = new JButton("agendar");
    JPanel jp = new JPanel();

    public EscogerCita() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();
        ///////////////////////////////
        jp.setPreferredSize(new Dimension(600, 600));
        String[] columnNames = {"Nombre médico",
            "Día",
            "Disponibilidad",
            "Tipo de consulta",
            "Sede"};
        Object[][] data = {
            {"Kathy", "Smith",
                new Boolean(false), "sdfsdfsdf", "sdfsdfsdfsdf"},
            {"John", "Doe",
                new Boolean(false), "sdfsdfsdf", "sdfsfsdf"},
            {"Sue", "Black",
                new Boolean(false), "asdasda", "sdfsdfsdfsd"},
            {"Jane", "White",
                new Boolean(false), "asdasdasd", "sdfsfsdfsdf"},
            {"Joe", "Brown",
                new Boolean(false), "asdasdasda", "sdfsdfsdfsdf"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane jScrollPane = new JScrollPane(table);
        jp.add(jScrollPane, BorderLayout.CENTER);
        c.add(jp);
        jp.setBackground(Color.white);
        jp.setBounds(10, 50, 470, 400);
//////////////////////////////////////////////////////
        c.add(agendar);
        agendar.setBounds(400, 550, 100, 30);

        c.add(datos);
        datos.setBounds(10, 550, 200, 60);
    }

    public void mostrar() {
        setSize(600, 700);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
