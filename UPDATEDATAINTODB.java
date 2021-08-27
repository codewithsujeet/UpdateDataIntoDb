package travel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;

    JButton b1, b2;

    UpdateCustomer(String username) {
        setTitle("Update Customer Details");
        setBounds(515, 200, 750, 500);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(35, 20, 150, 20);
        l1.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 20, 200, 25);
        add(t1);

        JLabel l2 = new JLabel("Name of Proof");
        l2.setBounds(35, 60, 150, 20);
        l2.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l2);

        t8 = new JTextField();
        t8.setBounds(200, 60, 200, 25);
        add(t8);

        JLabel l3 = new JLabel("Proof No");
        l3.setBounds(35, 100, 150, 20);
        l3.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(200, 100, 200, 25);
        add(t2);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(35, 140, 150, 20);
        l4.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(200, 140, 200, 25);
        add(t3);

        JLabel l9 = new JLabel("Gender");
        l9.setBounds(35, 180, 120, 20);
        l9.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l9);

        t9 = new JTextField();
        t9.setBounds(200, 180, 200, 25);
        add(t9);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(35, 220, 120, 20);
        l5.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l5);

        t4 = new JTextField();
        t4.setBounds(200, 220, 200, 25);
        add(t4);
        JLabel l6 = new JLabel("Address");
        l6.setBounds(35, 260, 120, 20);
        l6.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(200, 260, 200, 25);
        add(t5);

        JLabel l7 = new JLabel("Phone No");
        l7.setBounds(35, 300, 120, 20);
        l7.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l7);

        t6 = new JTextField();
        t6.setBounds(200, 300, 200, 25);
        add(t6);

        JLabel l8 = new JLabel("Email ID");
        l8.setBounds(35, 340, 120, 20);
        l8.setFont(new Font("Verdana", Font.PLAIN, 15));
        add(l8);

        t7 = new JTextField();
        t7.setBounds(200, 340, 200, 25);
        add(t7);
        

        b1 = new JButton("Update");
        b1.setBounds(100, 410, 100, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("RALEWAY", Font.BOLD, 15));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250, 410, 100, 25);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("RALEWAY", Font.BOLD, 15));
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(385, 60, 400, 300);
        add(l10);
       

        try {
            Conn con = new Conn();

//            String sql = "select * from customer where username='" +username+"'";

            ResultSet rs = con.s.executeQuery("select * from customer where username='"+username+"'");

            while (rs.next()) {
                t1.setText(rs.getString("username"));

                t2.setText(rs.getString("no"));
                t3.setText(rs.getString("name"));

                t4.setText(rs.getString("country"));
                t5.setText(rs.getString("address"));
                t6.setText(rs.getString("phone"));
                t7.setText(rs.getString("email"));
                t8.setText(rs.getString("id"));
                t9.setText(rs.getString("gender"));
               
                

            }
            t1.setEditable(false);
            t3.setEditable(false);
            

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String username = t1.getText();

            String no = t2.getText();
            String name = t3.getText();

            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();
            String id = t8.getText();
            String gender = t9.getText();
           

            try {
                Conn c = new Conn();

//                String sql = "update customer set username='" + username + "'id='" + id + "' no='" + no + "'name='" + name + "'gender='" + gender + "'country='" + country + "'address='" + address + "'phone='" + phone + "'email='" + email + "' ";

                c.s.executeUpdate("update customer set username='" + username + "',id='" + id + "', no='" + no + "', name='" + name + "',gender='" + gender + "',country='" + country + "',address='" + address + "',phone='" + phone + "',email='" + email + "' where name='"+name+"' ");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully !!");

//                this.setVisible(false);
//                new Dashboard("").setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
//            new Dashboard("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("").setVisible(true);
    }

}
