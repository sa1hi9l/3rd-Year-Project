package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddPassenger extends JFrame implements ActionListener {
    
    JComboBox ids;
    JTextField tfName,tfId,tfEmail,tfPh,tfDate,tfDesti;
    JButton add,back;
    
    AddPassenger() {
        setBounds(360,160,750,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lbName=new JLabel("Name");
        lbName.setBounds(30,50,150,25);
        add(lbName);
        
        tfName=new JTextField();
        tfName.setBounds(160,50,150,25);
        //tfName.setBorder(BorderFactory.createEmptyBorder());
        add(tfName);
        
        JLabel date_=new JLabel("Date");
        date_.setBounds(30,90,150,25);
        add(date_);
        
        tfDate=new JTextField();
        tfDate.setBounds(160,90,150,25);
        //tfName.setBorder(BorderFactory.createEmptyBorder());
        add(tfDate);
               
        JLabel destin=new JLabel("Destination");
        destin.setBounds(30,130,150,25);
        add(destin);
        
        tfDesti=new JTextField();
        tfDesti.setBounds(160,130,150,25);
        //tfName.setBorder(BorderFactory.createEmptyBorder());
        add(tfDesti);
                
        JLabel id=new JLabel("ID");
        id.setBounds(30,170,150,25);
        add(id); 
        
        ids=new JComboBox(new String[] {"Passport","Aadhaar Card","PAN Card"});
        ids.setBounds(160,170,150,25);
        ids.setBackground(Color.WHITE);
        add(ids);
        
        JLabel idNum=new JLabel("ID Number");
        idNum.setBounds(30,210,150,25);
        add(idNum);
        
        tfId=new JTextField();
        tfId.setBounds(160,210,150,25);   
        add(tfId);
        
        JLabel lbEmail=new JLabel("E-mail");
        lbEmail.setBounds(30,250,150,25);
        add(lbEmail);
        
        tfEmail=new JTextField();
        tfEmail.setBounds(160,250,150,25);   
        add(tfEmail);
        
        JLabel lbPh=new JLabel("Phone Number");
        lbPh.setBounds(30,290,150,25);
        add(lbPh);
        
        tfPh=new JTextField();
        tfPh.setBounds(160,290,150,25);   
        add(tfPh);
        
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(40,340,100,25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,340,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300,10,450,420);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==add) {
            String destination=tfDesti.getText();
            String travel_on=tfDate.getText();
            String name=tfName.getText();
            String id=tfId.getText();
            String email=tfEmail.getText();
            String phno=tfPh.getText();
            
            try {
                Conn c=new Conn();
                String query="insert into customer values('"+name+"','"+destination+"','"+travel_on+"','"+id+"','"+email+"','"+phno+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully!");
                setVisible(false);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddPassenger();
    }
    
}
