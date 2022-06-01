package Paneles;

import Clases.Cuenta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Registro {
    private JPanel contenPanelRegistro;
    private JTextField textName;
    private JTextField textField2;
    private JTextField textDni;
    private JButton volverButton;
    private JButton registerButton;
    private JLabel labelName;
    private JLabel labelLastname;
    private JTextField textLastname;
    private JLabel labelDni;
    private JTextField textEmail;
    private JPasswordField passwordField1;
    private JTextField textUsuario;
    private JLabel labelEmail;
    private JLabel labelUsuario;
    private JLabel labelPassword;

    public Registro() {

    }

    public void actionVolverButton(JFrame f,Login lg){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("Login");
                f.setContentPane(lg.getContenPanelLogin());
                f.setVisible(true);
            }
        });
    }

     public void actionRegisterButton(JFrame f){
         registerButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Cuenta c = new Cuenta(textUsuario.getText(),passwordField1.getText(),textEmail.getText(),textName.getText(),textLastname.getText(),textDni.getText());
                 System.out.println(c);
                 File file = new File("cuentas.txt");
                 try {
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                     objectOutputStream.writeObject(c);
                     objectOutputStream.close();
                 } catch (IOException ex) {
                     throw new RuntimeException(ex);
                 }finally {
                     System.out.println("guardado correctamente");
                 }
                 AnimationLoad val = new AnimationLoad();
             }
         });
     }



    public JPanel getContenPanelRegistro() {
        return contenPanelRegistro;
    }

    public void setContenPanelRegistro(JPanel contenPanelRegistro) {
        this.contenPanelRegistro = contenPanelRegistro;
    }

    public JTextField getTextField1() {
        return textName;
    }

    public void setTextField1(JTextField textField1) {
        this.textName = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textDni;
    }

    public void setTextField3(JTextField textField3) {
        this.textDni = textField3;
    }

    public JButton getVolverButton() {
        return volverButton;
    }

    public void setVolverButton(JButton volverButton) {
        this.volverButton = volverButton;
    }

    public JTextField getTextName() {
        return textName;
    }

    public JTextField getTextDni() {
        return textDni;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public JLabel getLabelLastname() {
        return labelLastname;
    }

    public JTextField getTextLastname() {
        return textLastname;
    }

    public JLabel getLabelDni() {
        return labelDni;
    }
}
