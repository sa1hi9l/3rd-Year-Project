package accounting.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfUsername,tfPass;
    JButton forgotPass,signup,login;
    
    Login() {
        setSize(900,450);
        setLocation(450,210);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setBounds(0,0,400,550);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2= i1.getImage().getScaledInstance(390,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(50,100,300,250);
        p1.add(image);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30,450,300);
        add(p2);
        
        JLabel  lbUsername=new JLabel("Username");
        lbUsername.setBounds(60,20,100,25);
        lbUsername.setFont(new Font("CALIBRI", Font.PLAIN, 20));
        p2.add(lbUsername);
        
        tfUsername= new JTextField();
        tfUsername.setBounds(60,50,300,30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);
        
        JLabel  lbPass=new JLabel("Password");
        lbPass.setBounds(60,100,150,25);
        lbPass.setFont(new Font("CALIBRI", Font.PLAIN, 20));
        p2.add(lbPass);
        
        tfPass= new JTextField();
        tfPass.setBounds(60,130,300,30);
        tfPass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPass);
        
        login=new JButton("Login");
        login.setBounds(60,180,100,30);
        login.addActionListener(this);
        p2.add(login);
        
        signup=new JButton("Sign up");
        signup.setBounds(260,180,100,30);
        signup.addActionListener(this);
        p2.add(signup);
        
        forgotPass=new JButton("Forgot Password");
        forgotPass.setBounds(130,220,150,30);
        forgotPass.addActionListener(this);
        p2.add(forgotPass);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== login) {
            
            try{
                String username=tfUsername.getText();
                String password=tfPass.getText();
                
                String query="Select * from account where username='"+username+"' AND password='"+password+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password!");
                }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==signup) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgotPass();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
    
}
    