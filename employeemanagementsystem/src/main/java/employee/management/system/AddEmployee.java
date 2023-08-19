package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

    Random rand = new Random();
    int randomId = rand.nextInt(9999999); //7 digit ID

    JTextField nameTextField, fatherNameTextField, addressTextField, phoneTextField, aadharTextField, emailTextField, salaryTextField, designationTextField;
    JLabel employeeId;
    JButton addButton, backButton;
    JDateChooser DOBChooser;
    JComboBox educationComboBox;

    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 150, 150, 30);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(200, 150, 150, 30);
        add(nameTextField);

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

        DOBChooser = new JDateChooser();
        DOBChooser.setBounds(200, 200, 150, 30);
        add(DOBChooser);

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

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        educationComboBox = new JComboBox(courses);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setBounds(600, 300, 150, 30);
        add(educationComboBox);

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

        aadharTextField = new JTextField();
        aadharTextField.setBounds(600, 350, 150, 30);
        add(aadharTextField);

        JLabel employeeIdLabel = new JLabel("Employee id");
        employeeIdLabel.setBounds(50, 400, 150, 30);
        employeeIdLabel.setFont(new Font("serif", Font.PLAIN, 20));
        add(employeeIdLabel);

        employeeId = new JLabel("" + randomId);
        employeeId.setBounds(200, 400, 150, 30);
        employeeId.setFont(new Font("serif", Font.PLAIN, 20));
        add(employeeId);

        addButton = new JButton("Add Details");
        addButton.setBounds(250, 550, 150, 40);
        addButton.addActionListener(this);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        add(addButton);

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
        if (ae.getSource() == addButton) {
            String name = nameTextField.getText();
            String fathername = fatherNameTextField.getText();
            String dob = ((JTextField) DOBChooser.getDateEditor().getUiComponent()).getText();
            String salary = salaryTextField.getText();
            String address = addressTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String education = (String) educationComboBox.getSelectedItem();
            String designation = designationTextField.getText();
            String aadhar = aadharTextField.getText();
            String empId = employeeId.getText();

            try {
                JdbcConnection connection = new JdbcConnection();
                String query = "insert into employee values('"+name+"', '"+fathername+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
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
        new AddEmployee();
    }
}