import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField cardField;
    JPasswordField pinField;
    JButton clear,signIn,signUp;
    public Login(){
        setTitle("Automated Teller Machine");
        setSize(650,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Heading
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(80,20,300,70);
        add(text);


        // Card Label
        JLabel cardNumber = new JLabel("Card Number: ");
        cardNumber.setFont(new Font("Arial",Font.BOLD,18));
        cardNumber.setBounds(80,120,250,50);
        add(cardNumber);

        cardField = new JTextField();
        cardField.setBounds(240,120,300,40);
        cardField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardField);

        // Pin label
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Arial",Font.BOLD,18));
        pin.setBounds(80,190,250,50);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(240,190,300,40);
        pinField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinField);

        // Sign In
        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Arial",Font.BOLD,16));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.white);
        signIn.setBounds(240,280,140,40);
        add(signIn);
        signIn.addActionListener(this);

        // Clear
        clear = new JButton("Clear");
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBounds(400,280,140,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        add(clear);
        clear.addActionListener(this);

        //Sign Up
        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Arial",Font.BOLD,16));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.setBounds(240,350,300,40);
        add(signUp);
        signUp.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            cardField.setText("");
            pinField.setText("");
        } else if (e.getSource() == signUp){
            setVisible(false);
            new SignUpDetails().setVisible(true);
        } else if (e.getSource() == signIn){
            JDBConnector c = new JDBConnector();
            String cardNumber = cardField.getText();
            String pinNumber = pinField.getText();
            String query = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pinNumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
