import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    public Login(){
        setTitle("Automated Teller Machine");
        setSize(500,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Heading
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Arial",Font.BOLD,30));
        text.setBounds(20,20,300,70);
        add(text);


        // Card Label
        JLabel cardNumber = new JLabel("Card Number: ");
        cardNumber.setFont(new Font("Arial",Font.BOLD,18));
        cardNumber.setBounds(20,100,250,50);
        add(cardNumber);

        JTextField cardField = new JTextField();
        cardField.setBounds(200,100,200,40);
        add(cardField);

        // Pin label
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Arial",Font.BOLD,18));
        pin.setBounds(20,170,250,50);
        add(pin);

        JTextField pinField = new JTextField();
        pinField.setBounds(200,170,200,40);
        add(pinField);

        // Sign In
        JButton signIn = new JButton("Sign In");
        signIn.setFont(new Font("Arial",Font.BOLD,16));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.white);
        signIn.setBounds(70,250,140,40);
        add(signIn);

        // Clear
        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Arial",Font.BOLD,16));
        clear.setBounds(270,250,140,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        add(clear);

        //Sign Up
        JButton signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Arial",Font.BOLD,16));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.setBounds(170,330,140,40);
        add(signUp);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
}
