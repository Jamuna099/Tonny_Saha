import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

public class Registration extends JFrame implements ActionListener
  { 

    JLabel lbHeader, lbUserName, lbFullName, lbGendar, lbPassword, lbConfirmPassword, lbEmail, lbPhoneNo;

    JTextField tfUserName, tfFullName, tfGendar, tfEmail, tfPhoneNo;

    JButton btSubmit, btClear;

    JPasswordField pfPassword, pfConfirmPassword;

 

    Registration()
     {

        setVisible(true);

        setSize(550, 550);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Registration Form in Java");

 

        lbHeader = new JLabel("Please Sign Up Here!!!!");

        lbHeader.setForeground(Color.gray);

        lbHeader.setFont(new Font("Serif", Font.BOLD, 20));

 

        lbUserName = new JLabel("User Name");
        
        lbFullName = new JLabel("Full Name");
        
        lbGendar = new JLabel("Gendar");
        
        lbPassword = new JLabel("Passowrd");
        
        lbConfirmPassword = new JLabel("Confirm Password");

        lbEmail = new JLabel("Email-ID");

        lbPhoneNo = new JLabel("Phone No"); 

        tfUserName = new JTextField();

        tfFullName = new JTextField();
        
        tfGendar = new JTextField();

        pfPassword = new JPasswordField();

        pfConfirmPassword = new JPasswordField();

        tfEmail = new JTextField();

        tfPhoneNo = new JTextField();

 

        btSubmit = new JButton("Submit");

        btClear = new JButton("Clear");

 

        btSubmit.addActionListener(this);

        btClear.addActionListener(this);

 

        lbHeader.setBounds(150, 20, 400, 30);

        lbUserName.setBounds(80, 70, 200, 30);
        
        lbFullName.setBounds(80, 110, 200, 30);
        
        lbGendar.setBounds(80, 150, 200, 30);

        lbPassword.setBounds(80, 190, 200, 30);

        lbConfirmPassword.setBounds(80, 230, 200, 30);

        lbEmail.setBounds(80, 270, 200, 30);

        lbPhoneNo.setBounds(80, 310, 200, 30);

        tfUserName.setBounds(300, 70, 200, 30);

        tfFullName.setBounds(300, 110, 200, 30);
        
        tfGendar.setBounds(300, 150, 200, 30);

        pfPassword.setBounds(300, 190, 200, 30);

        pfConfirmPassword.setBounds(300, 230, 200, 30);

        tfEmail.setBounds(300, 270, 200, 30);

        tfPhoneNo.setBounds(300, 310, 200, 30);

        btSubmit.setBounds(50, 350, 100, 30);

        btClear.setBounds(170, 350, 100, 30);

 

        add(lbHeader);

        add(lbUserName);

        add(tfUserName);
        
        add(lbFullName);
        
        add(tfFullName);
        
        add(lbGendar);
        
        add(tfGendar);

        add(lbPassword);

        add(pfPassword);

        add(lbConfirmPassword);

        add(pfConfirmPassword);
        
        add(lbEmail);

        add(tfEmail);

        add(lbPhoneNo);

        add(tfPhoneNo);

        add(btSubmit);

        add(btClear);

    }

 

    public void actionPerformed(ActionEvent e)
     {

        if (e.getSource() == btSubmit)
         {

            int x = 0;

            String s1 = tfUserName.getText();

            String s2 = tfFullName.getText();
            
            String s5 = tfGendar.getText();

 

            char[] s3 = pfPassword.getPassword();

            char[] s4 = pfConfirmPassword.getPassword(); 

            String s8 = new String(s3);

            String s9 = new String(s4);

 

            String s6 = tfEmail.getText();

            String s7 = tfPhoneNo.getText();

            if (s8.equals(s9))
           {

                try
               {

                    Class.forName("ojdbc14.jdbc.driver.OracleDriver");

                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");

                    PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?)");

                    ps.setString(1, s1);

                    ps.setString(2, s2);

                    ps.setString(3, s5);

                    ps.setString(4, s8);

                    ps.setString(5, s6);

                    ps.setString(6, s7);

                    ResultSet rs = ps.executeQuery();

                    x++;

                    if (x > 0)
                    {

                        JOptionPane.showMessageDialog(btSubmit, "Data Saved Successfully");

                    }

                }
          catch (Exception ex)
                {

                    System.out.println(ex);

                }

            }
          else
           {

                JOptionPane.showMessageDialog(btSubmit, "Password Does Not Match");

            } 

        }
          else
       {

            tfUserName.setText("");

            tfFullName.setText("");

            tfGendar.setText("");
            
            pfPassword.setText("");

            pfConfirmPassword.setText("");
            
            tfEmail.setText("");

            tfPhoneNo.setText("");

        }

    } 

    public static void main(String args[])
   {

        new Registration();

    }
}

