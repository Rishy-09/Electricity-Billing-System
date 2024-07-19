package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField password;
    Choice logginin;
    JButton login, cancel, signup;
    Login(){

//        this must be the first line in constructor /super() if want to use
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);

        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);

        password = new JPasswordField();
        password.setBounds(400, 60, 150, 20);
        add(password);

        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(300, 100, 100, 20);
        add(loggininas);

        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(this);
        add(login);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel  = new JButton("Cancel", new ImageIcon(i5));
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i7 = i6.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup  = new JButton("Signup", new ImageIcon(i7));
        signup.setBounds(380, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);

        ImageIcon i8 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i9 = i8.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(i9);
        JLabel image = new JLabel(i10);
        image.setBounds(0, 0, 250, 250);
        add(image);


        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();

            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Project(user, meter);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
//                    in case of invalid login set the text fields to null
                    username.setText("");
                    password.setText("");
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }

}
