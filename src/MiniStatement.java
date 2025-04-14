import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    String pinNumber;
    public MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        setLocation(20,20);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("SBI Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            JDBConnector c = new JDBConnector();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            JDBConnector c = new JDBConnector();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br></html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt((rs.getString("amount")));
                }
            }
            balance.setText("Your current account balance is Rs "+ bal);
        }catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);
        setSize(400,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
