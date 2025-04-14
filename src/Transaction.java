import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry,exit;
    String pinNumber;
    public Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(620,580);
        setLayout(null );
        getContentPane().setBackground(Color.BLACK);
//        setLocation(300,0);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(150,50,400,40);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(80, 150, 200, 40);
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(80, 240, 200, 40);
        withdrawl.setFont(new Font("System", Font.BOLD, 16));
        withdrawl.addActionListener(this);
        add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(320, 150, 200, 40);
        fastcash.setFont(new Font("System", Font.BOLD, 16));
        fastcash.addActionListener(this);
        add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(80, 330, 200, 40);
        ministatement.setFont(new Font("System", Font.BOLD, 16));
        ministatement.addActionListener(this);
        add(ministatement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(320, 240, 200, 40);
        pinchange.setFont(new Font("System", Font.BOLD, 16));
        pinchange.addActionListener(this);
        add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(320, 330, 200, 40);
        balanceenquiry.setFont(new Font("System", Font.BOLD, 16));
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(370, 420, 100, 40);
        exit.setFont(new Font("System", Font.BOLD, 16));
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
