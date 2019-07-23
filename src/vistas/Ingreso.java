/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import negocio.AsignacionCita;
import negocio.Usuario;
import util.CaException;

/**
 *
 * @author (╯°□°)╯︵ ┻━┻
 */
public class Ingreso extends JFrame implements ActionListener {

    JLabel inicio = new JLabel("Bienvenido al sistema de gestión de citas médicas");
    JLabel identificacion = new JLabel("Identificación:");
    JLabel password = new JLabel("Contraseña:");
    JLabel pregunta = new JLabel("¿No tiene cuenta?");
    JTextField inIdentificacion = new JTextField("");
    JTextField inPassword = new JTextField("");
    JButton validar = new JButton("Ingresar");
    JButton registro = new JButton("Registrese");
    EscogerCita ventana2 = new EscogerCita();

    public AsignacionCita AC;

    public Avisos aviso;

    Ingreso() {

        AC = AsignacionCita.getInstance();
        aviso = new Avisos();
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Container c = getContentPane();

        c.setBackground(Color.gray);

        c.add(inicio);
        inicio.setBounds(100, 10, 500, 20);

        c.add(identificacion);
        identificacion.setBounds(200, 70, 100, 20);

        c.add(inIdentificacion);
        inIdentificacion.setBounds(187, 100, 100, 20);

        c.add(password);
        password.setBounds(205, 130, 100, 20);

        c.add(inPassword);
        inPassword.setBounds(187, 160, 100, 20);

        c.add(validar);
        validar.setBounds(187, 200, 100, 20);

        c.add(pregunta);
        pregunta.setBounds(187, 240, 150, 20);

        c.add(registro);
        registro.setBounds(187, 270, 100, 20);

        validar.addActionListener(this);
        registro.addActionListener(this);

    }

    public void mostrar() {
        setSize(490, 350);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == validar) {
            try {

                if (!inIdentificacion.getText().isEmpty() && !inPassword.getText().isEmpty()) {

                    if (AC.validarUsuario(inIdentificacion.getText(), inPassword.getText())) {

                        if (AC.validarPaciente()) {
                            this.dispose();
                            Opciones O = new Opciones();
                            O.mostrar();
                        } else {
                            aviso.mostrar();
                            aviso.setText("Paciente no existe");

                        }

                    } else {
                        aviso.mostrar();
                        aviso.setText("Usuario no existe");
                    }
                } else {
                    if (inIdentificacion.getText().isEmpty() && inPassword.getText().isEmpty()) {
                        aviso.setVisible(true);
                        aviso.setText("Ingrese sus datos");
                    } else {
                        if (inIdentificacion.getText().isEmpty()) {
                            aviso.mostrar();
                            aviso.setText("id vacio");
                        }
                        if (inPassword.getText().isEmpty()) {
                            aviso.mostrar();
                            aviso.setText("Password vacio");

                        }

                    }
                }

            } catch (CaException ex) {
                Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == registro) {

            this.dispose();

            Registro r = new Registro();
            r.mostrar();

        }

    }
}
