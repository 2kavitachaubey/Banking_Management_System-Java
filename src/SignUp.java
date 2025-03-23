import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame{
    public SignUp(){
        setTitle("New Account Application - Page 2");
        setSize(500,700);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel signInDetail = new JLabel("ADD YOUR DETAILS");
        signInDetail.setBounds(140,20,250,70);
        signInDetail.setFont(new Font("Raleway",Font.BOLD,20));
        add(signInDetail);

        JLabel religion = new JLabel("Religion");
        religion.setBounds(20,80,100,40);
        religion.setFont(new Font("Raleway",Font.BOLD,14));
        add(religion);

        JLabel category = new JLabel("Category");
        category.setBounds(20,110,100,40);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        add(category);

        JLabel income = new JLabel("Income");
        income.setBounds(20,140,100,40);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        add(income);

        JLabel education = new JLabel("<html>Education<br>Qualificaton</html>");
        education.setBounds(20,160,100,80);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        add(education);
    }
    public static void main(String[] args) {
        new SignUp();
    }
}
