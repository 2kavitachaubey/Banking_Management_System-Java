import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
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

        JTextField cardField = new JTextField();
        cardField.setBounds(240,120,300,40);
        cardField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardField);

        // Pin label
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Arial",Font.BOLD,18));
        pin.setBounds(80,190,250,50);
        add(pin);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(240,190,300,40);
        pinField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinField);

        // Sign In
        JButton signIn = new JButton("Sign In");
        signIn.setFont(new Font("Arial",Font.BOLD,16));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.white);
        signIn.setBounds(240,280,140,40);
        add(signIn);

        // Clear
        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBounds(400,280,140,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        add(clear);

        //Sign Up
        JButton signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Arial",Font.BOLD,16));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.setBounds(240,350,300,40);
        add(signUp);

        //Action performed
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clear){
                    cardField.setText("");
                    pinField.setText("");
                }
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
