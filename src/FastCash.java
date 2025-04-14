import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;
import java.util.*;

public class FastCash extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry,exit;
    String pinNumber;
    public FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(620,580);
        setLayout(null );
        getContentPane().setBackground(Color.BLACK);
//        setLocation(300,0);

        JLabel text = new JLabel("Please select Withdrawal Amount: ");
        text.setBounds(150,50,400,40);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        deposit = new JButton("Rs.100");
        deposit.setBounds(80, 150, 200, 40);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Rs.500");
        withdrawl.setBounds(80, 240, 200, 40);
        withdrawl.setFont(new Font("System", Font.BOLD, 16));
        withdrawl.addActionListener(this);
        add(withdrawl);

        fastcash = new JButton("Rs.1000");
        fastcash.setBounds(320, 150, 200, 40);
        fastcash.setFont(new Font("System", Font.BOLD, 16));
        fastcash.addActionListener(this);
        add(fastcash);

        ministatement = new JButton("Rs.2000");
        ministatement.setBounds(80, 330, 200, 40);
        ministatement.setFont(new Font("System", Font.BOLD, 16));
        ministatement.addActionListener(this);
        add(ministatement);

        pinchange = new JButton("Rs.5000");
        pinchange.setBounds(320, 240, 200, 40);
        pinchange.setFont(new Font("System", Font.BOLD, 16));
        pinchange.addActionListener(this);
        add(pinchange);

        balanceenquiry = new JButton("Rs.10000");
        balanceenquiry.setBounds(320, 330, 200, 40);
        balanceenquiry.setFont(new Font("System", Font.BOLD, 16));
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(370, 420, 100, 40);
        exit.setFont(new Font("System", Font.BOLD, 16));
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            JDBConnector c = new JDBConnector();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt((rs.getString("amount")));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully");

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}