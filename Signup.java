package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfAnswer,tfUsername,tfName,tfPass;
    Choice security;
    
    Signup() {
        setBounds(350,200,1000,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        add(p1);
        
        JLabel lbUsername=new JLabel("Username");
        lbUsername.setBounds(50,20,125,25);
        lbUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbUsername);
        
        tfUsername=new JTextField();
        tfUsername.setBounds(190,20,180,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername); 
        
        JLabel lbName=new JLabel("Name");
        lbName.setFont(new Font("Tahoma",Font.BOLD,14));
        lbName.setBounds(50,60,125,25);
        p1.add(lbName);
        
        tfName=new JTextField();
        tfName.setBounds(190,60,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel lbPass=new JLabel("Password");
        lbPass.setFont(new Font("Tahoma",Font.BOLD,14));
        lbPass.setBounds(50,100,125,25);
        p1.add(lbPass);
        
        tfPass=new JTextField();
        tfPass.setBounds(190,100,180,25);
        tfPass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPass);
        
        JLabel lbSecurity=new JLabel("Security");
        lbSecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lbSecurity.setBounds(50,140,125,25);
        p1.add(lbSecurity);
        
        security=new Choice();
        security.add("First Car");
        security.add("Lucky Number");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lbAnswer=new JLabel("Answer");
        lbAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lbAnswer.setBounds(50,180,125,25);
        p1.add(lbAnswer);
        
        tfAnswer=new JTextField();
        tfAnswer.setBounds(190,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);
        
        create=new JButton("Create");
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back=new JButton("Back");
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2= i1.getImage().getScaledInstance(390,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(580,50,390,250);
        add(image);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==create) {
            String  username=tfUsername.getText();
            String name=tfName.getText();
            String password=tfPass.getText();
            String question=security.getSelectedItem();
            String answer=tfAnswer.getText();
            
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            
            try {
                Conn c=new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully!");
                
                setVisible(false);
                new Login();
            }catch  (Exception e) {
            }
        }
        else if(ae.getSource()==back) {
            setVisible(false);
            new Login();
        }
        
    }
    
    public static void main(String[] args) {
        new Signup();
    }
    
}
