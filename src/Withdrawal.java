import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {
    JButton withdrawal,back;
    JTextField amount;
    String pinNumber;
    public Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(540,480);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
//        setLocation(300,0);

        JLabel text = new JLabel("Enter the amount you want to withdrawal: ");
        text.setBounds(50,80,400,40);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        amount = new JTextField();
        amount.setBounds(50,150,400,40);
        amount.setFont(new Font("System", Font.BOLD, 16));
        add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(250, 260, 200, 40);
        withdrawal.setFont(new Font("System", Font.BOLD, 16));
        withdrawal.addActionListener(this);
        add(withdrawal);

        back = new JButton("Back");
        back.setBounds(250, 320, 200, 40);
        back.setFont(new Font("System", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawal){
            String amountNumber = amount.getText();
            Date date = new Date();
            if(amountNumber.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdrawal");
            }
            else{
                try {
                    JDBConnector c = new JDBConnector();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawal', '" + amountNumber + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Rs "+ amountNumber+" Withdrawal Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }
}

