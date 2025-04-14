import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    public BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Balance Enquiry");
        setSize(540, 480);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setLocation(300,0);


        back = new JButton("Back");
        back.setBounds(330, 310, 120, 40);
        add(back);
        back.addActionListener(this);

        JDBConnector c = new JDBConnector();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt((rs.getString("amount")));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Currect Accoutn Balance is Rs " + balance);
        text.setBounds(70, 150, 400, 40);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        add(text);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);

    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
