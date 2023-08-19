package employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener{

    JButton viewButton, addButton, updateButton, removeButton;

    Home(){
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/home.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(scaledImage);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 25));
        image.add(heading);

        addButton = new JButton("Add Employee");
        addButton.setBounds(650, 80, 150, 40);
        addButton.addActionListener(this);
        image.add(addButton);

        viewButton = new JButton("View Employees");
        viewButton.setBounds(820, 80, 150, 40);
        viewButton.addActionListener(this);
        image.add(viewButton);

        updateButton = new JButton("Update Employee");
        updateButton.setBounds(650, 140, 150, 40);
        updateButton.addActionListener(this);
        image.add(updateButton);

        removeButton = new JButton("Remove Employee");
        removeButton.setBounds(820, 140, 150, 40);
        removeButton.addActionListener(this);
        image.add(removeButton);


        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //Action Event will give information about which button was clicked
        if (ae.getSource() == addButton) {
            setVisible(false);
        } else if (ae.getSource() == viewButton) {
            setVisible(false);
        } else if (ae.getSource() == updateButton) {
            setVisible(false);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}