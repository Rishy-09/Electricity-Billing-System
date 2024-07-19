package electricity.billing.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class CustomerDetails extends JFrame implements ActionListener {
    JTable table;
    JButton  print;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200, 650);
        setLocation(200, 150);

        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            System.out.println(e);
        }
//        adding scroll bar in table
        JScrollPane sp = new JScrollPane(table);
        add(sp);

        print = new JButton("Print");
        print.addActionListener(this);
//        by default this will pick border layout as we haven't null the value here
        add(print, "South");


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            try{
                table.print();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }
}
