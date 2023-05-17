package Zeal;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{


    JButton Email;

    About() {


        Email = new JButton("Contact:zcoer@zealeducation.com");
        Email.setBounds(40, 340, 350, 40);
        Email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Email.addActionListener(this);
        Email.setBorder(BorderFactory.createEmptyBorder());
        Email.setFocusPainted(false);
        Email.setBackground(Color.WHITE);
        Email.setForeground(Color.BLUE);
        Email.getUI();
        add(Email);

        setSize(700, 500);
        setLocation(400, 150);


        getContentPane().setBackground(Color.WHITE); //change
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("wallpaper/zealpic06-2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(265, 20, 550, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>Campus<br/>Management Application</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        heading.setForeground(Color.RED);
        
        JLabel name = new JLabel("Developed By: PBL Group No.-34 ");
        name.setBounds(70, 270, 550, 40);
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name);

        JLabel pbl = new JLabel("Project Based Learning");
        pbl.setBounds(70, 215, 550, 35);
        pbl.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add(pbl);
        
        //JLabel rollno = new JLabel("Roll number: S213020");
      //  rollno.setBounds(70, 280, 550, 40);
       // rollno.setFont(new Font("Tahoma", Font.PLAIN, 30));
      //  add(rollno);
        
       // JLabel contact = new JLabel("Contact:zealcollege@123gmail.com");
      //  contact.setBounds(70, 340, 550, 40);
      //  contact.setFont(new Font("Times New Roman", Font.BOLD, 20));
      //  add(contact);
      //  contact.setForeground(Color.BLUE);

        JLabel phone = new JLabel("Contact no :020-67206000 ");
        phone.setBounds(70, 380, 550, 40);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(phone);
        
        setLayout(null);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Email)
        {
            try {
                ProcessBuilder pb =
                        new ProcessBuilder(
                                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
                                "https://mail.google.com/mail/u/0/#inbox?compose=new");

                pb.start();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }


    
    public static void main(String[] args) {
        new About();
    }
}
