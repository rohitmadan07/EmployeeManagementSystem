package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener {

    JTable table; //can make table using JTable
    Choice employeeId;
    JButton searchButton, printButton, updateButton, backButton;
    
    ViewEmployees() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchButtonLabel = new JLabel("Search By Employee Id");
        searchButtonLabel.setBounds(20, 20, 150, 20);
        add(searchButtonLabel);
        
        employeeId = new Choice();
        employeeId.setBounds(180, 20, 150, 20);
        add(employeeId);
        
        try {
            JdbcConnection connection = new JdbcConnection();
            ResultSet rs = connection.statement.executeQuery("select * from employee");
            while(rs.next()) {
                employeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            JdbcConnection connection = new JdbcConnection();
            ResultSet rs = connection.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(20, 70, 80, 20);
        searchButton.addActionListener(this);
        add(searchButton);
        
        printButton = new JButton("Print");
        printButton.setBounds(120, 70, 80, 20);
        printButton.addActionListener(this);
        add(printButton);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(220, 70, 80, 20);
        updateButton.addActionListener(this);
        add(updateButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(320, 70, 80, 20);
        backButton.addActionListener(this);
        add(backButton);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchButton) {
            String query = "select * from employee where empId = '"+employeeId.getSelectedItem()+"'";
            try {
                JdbcConnection connection = new JdbcConnection();
                ResultSet rs = connection.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == printButton) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateButton) {
            setVisible(false);
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployees();
    }
}
