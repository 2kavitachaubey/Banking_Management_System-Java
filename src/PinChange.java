import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JTextField pin,rePin;
    String pinNumber;
    public PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(540, 480);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        //setLocation(300,0);

        JLabel text = new JLabel("CHANGE YOUR PIN:");
        text.setBounds(150, 30, 300, 40);
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(50, 120, 200, 30);
        pinText.setFont(new Font("System", Font.BOLD, 18));
        pinText.setForeground(Color.WHITE);
        add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(250, 120, 200, 30);
        add(pin);

        JLabel reEnterPin = new JLabel("Re-Enter New PIN:");
        reEnterPin.setBounds(50, 180, 200, 30);
        reEnterPin.setFont(new Font("System", Font.BOLD, 18));
        reEnterPin.setForeground(Color.WHITE);
        add(reEnterPin);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 20));
        rePin.setBounds(250, 180, 200, 30);
        add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(330, 260, 120, 40);
        change.addActionListener(this);
        add(change);

        back = new JButton("BACK");
        back.setBounds(330, 310, 120, 40);
        change.addActionListener(this);
        add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                String npin = pin.getText();
                String rpin = rePin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please E nter New PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please RE-Enter PIN");
                    return;
                }
                JDBConnector c = new JDBConnector();
                String query = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query1 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
