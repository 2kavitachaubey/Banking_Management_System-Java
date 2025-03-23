import javax.swing.*;
import java.awt.*;

public class SignUpDetails extends JFrame{
    public SignUpDetails(){
        setTitle("New Account Application -  Page 1");
        setSize(550,650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel applicationForm = new JLabel("ADD YOUR DETAILS");
        applicationForm.setBounds(160,20,250,70);
        applicationForm.setFont(new Font("Raleway",Font.BOLD,20));
        add(applicationForm);

        JLabel name = new JLabel("Name:");
        name.setBounds(65,100,120,80);
        name.setFont(new Font("Raleway",Font.BOLD,14));
        add(name);

        JLabel fatherName = new JLabel("Father's Name: ");
        fatherName.setBounds(65,140,120,80);
        fatherName.setFont(new Font("Raleway",Font.BOLD,14));
        add(fatherName);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(65,180,120,80);
        dob.setFont(new Font("Raleway",Font.BOLD,14));
        add(dob);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(65,220,120,80);
        gender.setFont(new Font("Raleway",Font.BOLD,14));
        add(gender);

        JLabel email = new JLabel("Email Address:");
        email.setBounds(65,260,120,80);
        email.setFont(new Font("Raleway",Font.BOLD,14));
        add(email);

        JLabel address = new JLabel("Address:");
        address.setBounds(65,300,120,80);
        address.setFont(new Font("Raleway",Font.BOLD,14));
        add(address);

        JLabel city = new JLabel("City");
        city.setBounds(65,340,120,80);
        city.setFont(new Font("Raleway",Font.BOLD,14));
        add(city);

        JLabel state = new JLabel("State:");
        state.setBounds(65,380,120,80);
        state.setFont(new Font("Raleway",Font.BOLD,14));
        add(state);

        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setBounds(65,420,120,80);
        pinCode.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinCode);


        // Text Fields
        JTextField nameField = new JTextField();
        nameField.setBounds(190, 130, 250, 25);
        add(nameField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(190, 170, 250, 25);
        add(fatherNameField);

        JTextField dobField = new JTextField("YYYY-MM-DD");
        dobField.setBounds(190, 210, 250, 25);
        add(dobField);

        JRadioButton genderMale = new JRadioButton("Male");
        genderMale.setBounds(190, 250, 100, 25);
        add(genderMale);
        JRadioButton genderFemale = new JRadioButton("Female");
        genderFemale.setBounds(290, 250, 250, 25);
        add(genderFemale);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);

        JTextField emailField = new JTextField();
        emailField.setBounds(190, 290, 250, 25);
        add(emailField);

        JTextField addressField = new JTextField();
        addressField.setBounds(190, 330, 250, 25);
        add(addressField);

        JTextField cityField = new JTextField();
        cityField.setBounds(190, 370, 250, 25);
        add(cityField);

        JTextField stateField = new JTextField();
        stateField.setBounds(190, 410, 250, 25);
        add(stateField);

        JTextField pinCodeField = new JTextField();
        pinCodeField.setBounds(190, 450, 250, 25);
        add(pinCodeField);

        //Button
        JButton nextbutton = new JButton("Next");
        nextbutton.setBounds(310,490,130,40);
        nextbutton.setFont(new Font("Raleway", Font.BOLD,16));
        nextbutton.setBackground(Color.BLACK);
        nextbutton.setForeground(Color.white);
        add(nextbutton);

        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpDetails();
    }
}
