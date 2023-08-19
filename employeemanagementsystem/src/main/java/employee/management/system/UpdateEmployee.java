package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField educationTextField, nameTextField, fatherNameTextField, addressTextField, phoneTextField, aadharTextField, emailTextField, salaryTextField, designationTextField;
    JLabel employeeIdLabel;
    JButton updateButton, backButton;
    String empId;   

    UpdateEmployee(String employeeId){
        this.empId = employeeId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAILS");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 30);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(nameLabel);

        JLabel lblName = new JLabel(); //name cannot be changed
        lblName.setBounds(200, 150, 150, 30);
        add(lblName);

        JLabel fatherNameLabel = new JLabel("Father's Name");
        fatherNameLabel.setBounds(400, 150, 150, 30);
        fatherNameLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(fatherNameLabel);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(600, 150, 150, 30);
        add(fatherNameTextField);

        JLabel DOBLabel = new JLabel("Date of Birth");
        DOBLabel.setBounds(50, 200, 150, 30);
        DOBLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(DOBLabel);

        JLabel lblDOB = new JLabel(); //cannot be changed
        lblDOB.setBounds(200, 200, 150, 30);
        add(lblDOB);

        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(400, 200, 150, 30);
        salaryLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(salaryLabel);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(600, 200, 150, 30);
        add(salaryTextField);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 250, 150, 30);
        addressLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(addressLabel);

        addressTextField = new JTextField();
        addressTextField.setBounds(200, 250, 150, 30);
        add(addressTextField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(400, 250, 150, 30);
        phoneLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(phoneLabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(600, 250, 150, 30);
        add(phoneTextField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 300, 150, 30);
        emailLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(200, 300, 150, 30);
        add(emailTextField);

        JLabel educationLabel = new JLabel("Higest Education");
        educationLabel.setBounds(400, 300, 150, 30);
        educationLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(educationLabel);

        educationTextField = new JTextField();
        educationTextField.setBackground(Color.WHITE);
        educationTextField.setBounds(600, 300, 150, 30);
        add(educationTextField);

        JLabel designationLabel = new JLabel("Designation");
        designationLabel.setBounds(50, 350, 150, 30);
        designationLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(designationLabel);

        designationTextField = new JTextField();
        designationTextField.setBounds(200, 350, 150, 30);
        add(designationTextField);

        JLabel aadharLabel = new JLabel("Aadhar Number");
        aadharLabel.setBounds(400, 350, 150, 30);
        aadharLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(aadharLabel);

        JLabel lblAadhar = new JLabel();
        lblAadhar.setBounds(600, 350, 150, 30);
        add(lblAadhar);

        JLabel empIdLabel = new JLabel("Employee id");
        empIdLabel.setBounds(50, 400, 150, 30);
        empIdLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(empIdLabel);

        employeeIdLabel = new JLabel();
        employeeIdLabel.setBounds(200, 400, 150, 30);
        employeeIdLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(employeeIdLabel);

        try {
            JdbcConnection connection = new JdbcConnection();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = connection.statement.executeQuery(query);
            while(rs.next()) {
                lblName.setText(rs.getString("name"));
                fatherNameTextField.setText(rs.getString("fname"));
                lblDOB.setText(rs.getString("dob"));
                addressTextField.setText(rs.getString("address"));
                salaryTextField.setText(rs.getString("salary"));
                phoneTextField.setText(rs.getString("phone"));
                emailTextField.setText(rs.getString("email"));
                educationTextField.setText(rs.getString("education"));
                lblAadhar.setText(rs.getString("aadhar"));
                employeeIdLabel.setText(rs.getString("empId"));
                designationTextField.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateButton = new JButton("Update Details");
        updateButton.setBounds(250, 550, 150, 40);
        updateButton.addActionListener(this);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        add(updateButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(450, 550, 150, 40);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            String fathername = fatherNameTextField.getText();
            String salary = salaryTextField.getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String education = educationTextField.getText();
            String designation = designationTextField.getText();

            try {
                JdbcConnection connection = new JdbcConnection();
                String query = "update employee set fname = '"+fathername+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new UpdateEmployee("");
    }
}