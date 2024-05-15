package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPass extends JFrame implements ActionListener{
    
    JTextField tfUsername,tfName,tfQuestion,tfAnswer,tfPassword;
    JButton search,retrieve,back;
    
    ForgotPass() {
        setBounds(350,200,850,380);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image); 
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel lbUsername=new JLabel("Username");
        lbUsername.setBounds(40,20,100,25);
        lbUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbUsername);
        
        tfUsername=new JTextField();
        tfUsername.setBounds(200,20,150,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);
        
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(360,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lbName=new JLabel("Name");
        lbName.setBounds(40,60,100,25);
        lbName.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbName);
        
        tfName=new JTextField();
        tfName.setBounds(200,60,150,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);
        
        JLabel lbQuestion=new JLabel("Security Question");
        lbQuestion.setBounds(40,100,150,25);
        lbQuestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbQuestion);
        
        tfQuestion=new JTextField();
        tfQuestion.setBounds(200,100,150,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion); 
        
        JLabel lbAnswer=new JLabel("Security Answer");
        lbAnswer.setBounds(40,140,150,25);
        lbAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbAnswer);
        
        tfAnswer=new JTextField();
        tfAnswer.setBounds(200,140,150,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer); 
        
        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(360,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lbPassword=new JLabel("Password");
        lbPassword.setBounds(40,180,100,25);
        lbPassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lbPassword);
        
        tfPassword=new JTextField();
        tfPassword.setBounds(200,180,150,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);
        
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(40,220,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
            
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search) {
            try{
                String query= "select * from account where username='"+tfUsername.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfQuestion.setText(rs.getString("security"));
                }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource()==retrieve) {
            try{
                String query= "select * from account where answer='"+tfAnswer.getText()+"'AND username='"+tfUsername.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()) {
                    tfPassword.setText(rs.getString("password"));
                }
                
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ForgotPass() ;
    }
    
}
