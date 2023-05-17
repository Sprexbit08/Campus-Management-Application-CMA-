package Zeal;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class SEA extends JFrame {

    SEA()
    {




        setSize(1000, 1000);
        setLocation(200, 75);
        setBackground(Color.PINK);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("wallpaper/TimeTable_A.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SEA();

    }
}
