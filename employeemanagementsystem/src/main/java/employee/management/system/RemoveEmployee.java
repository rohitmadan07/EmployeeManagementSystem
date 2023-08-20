package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice choiceEmployeeId;
    JButton deleteButton, backButton;
    
    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        choiceEmployeeId = new Choice();
        choiceEmployeeId.setBounds(200, 50, 150, 30);
        add(choiceEmployeeId);
        
        try {
            JdbcConnection connection = new JdbcConnection();
            String query = "select * from employee";
            ResultSet rs = connection.statement.executeQuery(query);
            while(rs.next()) {
                choiceEmployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 100, 100, 30);
        add(nameLabel);
        
        JLabel lblName = new JLabel();
        lblName.setBounds(200, 100, 100, 30);
        add(lblName);
        
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(50, 150, 100, 30);
        add(phoneLabel);
        
        JLabel lblPhone = new JLabel();
        lblPhone.setBounds(200, 150, 100, 30);
        add(lblPhone);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 200, 100, 30);
        add(emailLabel);
        
        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(200, 200, 100, 30);
        add(lblEmail);
        
        try {
            JdbcConnection connection = new JdbcConnection();
            String query = "select * from employee where empId = '"+choiceEmployeeId.getSelectedItem()+"'";
            ResultSet rs = connection.statement.executeQuery(query);
            while(rs.next()) {
                lblName.setText(rs.getString("name"));
                lblPhone.setText(rs.getString("phone"));
                lblEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        choiceEmployeeId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    JdbcConnection connection = new JdbcConnection();
                    String query = "select * from employee where empId = '"+choiceEmployeeId.getSelectedItem()+"'";
                    ResultSet rs = connection.statement.executeQuery(query);
                    while(rs.next()) {
                        lblName.setText(rs.getString("name"));
                        lblPhone.setText(rs.getString("phone"));
                        lblEmail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(80, 300, 100,30);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);
        add(deleteButton);
        
        backButton = new JButton("Go Back");
        backButton.setBounds(220, 300, 100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/delete.png"));
        Image scaledImage = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(scaledImage);
        JLabel image = new JLabel(i2);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteButton) {
            try {
                JdbcConnection connection = new JdbcConnection();
                String query = "delete from employee where empId = '"+choiceEmployeeId.getSelectedItem()+"'";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}