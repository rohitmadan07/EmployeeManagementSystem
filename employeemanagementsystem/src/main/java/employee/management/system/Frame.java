package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame implements ActionListener{

    //ActionListener -> interface which has an unimplemented abstract method then have to
    //override that method

    Frame(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); //removes default layout

        //Create JLabel to add to the frame
        JLabel title = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setBounds(80, 30, 1200, 60);
        title.setFont(new Font("Times New Roman", Font.BOLD,60));
        title.setForeground(Color.BLUE);
        add(title);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/front.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(scaledImage);
        JLabel image = new JLabel(i2);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton button = new JButton("CLICK HERE TO CONTINUE");
        button.setBounds(400, 400, 300, 70);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);

        // current instance of the class will handle the button's click event.
        button.addActionListener(this); 
        image.add(button); //add relative to image

        setSize(1170,650); //new Frame
        setLocation(200, 50); //(left,top)
        setVisible(true); //by default -> false
        
        //To create effect of title on starting of project
        while(true) {
            title.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            title.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false); //close this frame
        new LoginFrame();
    }
    
    public static void main(String[] args) {
        new Frame(); //new object of the class created
        //class object calls constructor (which is there by default)
    }
    //When a class is run, it's main method executes in which we are creating an object of our class
}
