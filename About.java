package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    About() {
        setBounds(600,200,500,550);
        setLayout(null);
        setBackground(Color.WHITE);
        
        JLabel l1=new JLabel("ABOUT");
        l1.setBounds(150,10,100,40);
        l1.setBackground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        String s="This Application will help you manage accouting and tracking bills with ease, so you can focus on the development of your business";
        
        TextArea area= new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        JButton back=new JButton("Back");
        back.setBounds(200,420,80,40);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void  actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }
    
}
