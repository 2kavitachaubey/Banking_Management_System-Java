import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
    JComboBox<String> religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    JTextField panField, aadharField;
    JRadioButton seniorYes,seniorNo,accountYes,accountNo;
    String formno;



    public SignUp(String formno){
        this.formno = formno;
        setTitle("New Account Application - Page 2");
        setLocation(300,0);
        setSize(500,650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel signInDetail = new JLabel("ADD YOUR DETAILS" + formno);
        signInDetail.setBounds(140,20,250,70);
        signInDetail.setFont(new Font("Raleway",Font.BOLD,20));
        add(signInDetail);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(40,100,100,40);
        religion.setFont(new Font("Raleway",Font.BOLD,14));
        add(religion);

        JLabel category = new JLabel("Category:");
        category.setBounds(40,140,100,40);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        add(category);

        JLabel income = new JLabel("Income:");
        income.setBounds(40,180,100,40);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        add(income);

        JLabel education = new JLabel("<html>Education<br>Qualificaton:</html>");
        education.setBounds(40,220,100,80);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        add(education);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(40,290,100,40);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        add(occupation);

        JLabel panNumber = new JLabel("Pan Number:");
        panNumber.setBounds(40,330,100,40);
        panNumber.setFont(new Font("Raleway",Font.BOLD,14));
        add(panNumber);

        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setBounds(40,370,120,40);
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadharNumber);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setBounds(40,410,120,40);
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,14));
        add(seniorCitizen);

        JLabel existAcc = new JLabel("Existing Account:");
        existAcc.setBounds(40,450,140,40);
        existAcc.setFont(new Font("Raleway",Font.BOLD,14));
        add(existAcc);


        // side field
        String[] religions = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionBox = new JComboBox<>(religions);
        religionBox.setBounds(200, 110, 220, 25);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        String[] categories = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox<>(categories);
        categoryBox.setBounds(200, 150, 220, 25);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        String[] incomes = {"< 1 Lakh", "1 - 5 Lakh", "5 - 10 Lakh", "Above 10 Lakh"};
        incomeBox = new JComboBox<>(incomes);
        incomeBox.setBounds(200, 190, 220, 25);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        String[] educations = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationBox = new JComboBox<>(educations);
        educationBox.setBounds(200, 250, 220, 25);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        String[] occupations = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationBox = new JComboBox<>(occupations);
        occupationBox.setBounds(200, 300, 220, 25);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        panField = new JTextField();
        panField.setBounds(200, 340, 220, 25);
        panField.setBackground(Color.WHITE);
        add(panField);

        aadharField = new JTextField();
        aadharField.setBounds(200, 380, 220, 25);
        aadharField.setBackground(Color.WHITE);
        add(aadharField);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(200, 420, 50, 25);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(280, 420, 50, 25);
        add(seniorNo);
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorYes);
        seniorCitizenGroup.add(seniorNo);

        accountYes = new JRadioButton("Yes");
        accountYes.setBounds(200, 460, 50, 25);
        add(accountYes);
        accountNo = new JRadioButton("No");
        accountNo.setBounds(280, 460, 50, 25);
        add(accountNo);
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(accountYes);
        existingAccountGroup.add(accountNo);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(340, 520, 80, 30);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String userReligion = (String) religionBox.getSelectedItem();
        String userCategory = (String) categoryBox.getSelectedItem();
        String userIncome = (String) incomeBox.getSelectedItem();
        String userEducation = (String) educationBox.getSelectedItem();
        String userOccupation = (String) occupationBox.getSelectedItem();

        String userPan = panField.getText();
        String userAadhar = aadharField.getText();

        String userSeniorCitizen = null;
        if (seniorYes.isSelected()) {
            userSeniorCitizen = "Yes";
        } else if (seniorNo.isSelected()) {
            userSeniorCitizen = "No";
        }

        String userExistingAccount = null;
        if (accountYes.isSelected()) {
            userExistingAccount = "Yes";
        } else if (accountNo.isSelected()) {
            userExistingAccount = "No";
        }

        try{
            if(userAadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number Required!");
            }
            else{
                JDBConnector c = new JDBConnector();
                String query = "insert into signuptwo values('"+formno+"','" + userReligion + "','" + userCategory + "','" + userIncome + "','" + userEducation + "','" + userOccupation + "','" + userPan + "','" + userAadhar + "','" + userSeniorCitizen + "','" + userExistingAccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }

        }catch (Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String[] args) {
        new SignUp("");
    }
}
