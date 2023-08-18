package employee.management.system;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    LoginFrame(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(150,20,150,30); //should start from 40 + 100 (length of label)
        add(usernameTextField);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(150,70,150,30); //should start from 40 + 100 (length of label)
        add(passwordTextField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(150, 140, 150, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/second.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(scaledImage);
        JLabel image = new JLabel(i2);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginFrame();
    }
}
