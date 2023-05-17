package Zeal;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PercentageFaculty extends JFrame implements ActionListener {

    Choice crollno, ctime;

    JButton submit, cancel;

    JTextField tdays, tdayscount;
    int val;

    public int count;
    public String str;

    PercentageFaculty() {

        setSize(500, 400);
        setLocation(550, 100);
        setLayout(null);

      //  getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(new Color(216,0,115));

        JLabel heading = new JLabel("Percentage (Attendance)");
        heading.setBounds(100, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);



        JLabel lblrollno = new JLabel("Search by Employee ID Number");
        lblrollno.setBounds(60, 100, 400, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                crollno.add(rs.getString("empID"));



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel Days = new JLabel("Enter Total Number Of Teaching Days :-");
        Days.setBounds(60, 170, 400, 20);
        Days.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(Days);

        JLabel attendance = new JLabel("Percentage Attendance :-");
        attendance.setBounds(60, 210, 400, 20);
        attendance.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(attendance);

        tdays= new JTextField();
        tdays.setBounds(390, 170, 50, 20);
        add(tdays);

        tdayscount =new JTextField();
        tdayscount.setBounds(270,210,60,20);
        add(tdayscount);





        submit = new JButton("Submit");
        submit.setBounds(60, 280, 100, 25);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 280, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String Eid = crollno.getSelectedItem();
            double value = Integer.parseInt(tdays.getText());
            double per;

            try {
                Connection conn1 = DriverManager.getConnection("jdbc:mysql:///zealymanagementsystem","root","akshay45");
                Statement stmt = conn1.createStatement();
                String query1 = "SELECT empID, COUNT(*) as count FROM teacherleave WHERE empID= '"+Eid+"' GROUP BY empID HAVING count >= 0";

                ResultSet rs1 = stmt.executeQuery(query1);

                if (rs1.next()) {
                    double count = rs1.getInt("count");
                    System.out.println(count);
                    System.out.println(value);
                    per=((value-count)/value)*100;
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    tdayscount.setText(decimalFormat.format(per)+"%");
                    System.out.println(per);
                    setVisible(true);










                }
                else
                {
                    double count = 0;
                    System.out.println(count);
                    System.out.println(value);
                    per=((value-count)/value)*100;
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    tdayscount.setText(decimalFormat.format(per)+"%");
                    System.out.println(per);
                    setVisible(true);

                }



            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {

        new PercentageFaculty();
    }
}
