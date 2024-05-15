package accounting.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run() {
        try {
            for(int i=1;i<=101;i++) {
                int max=bar.getMaximum();
                int value=bar.getValue();
                
                if(value < max) {
                    bar.setValue(bar.getValue()+1);
                    
                } else {
                    setVisible(false);
                }
                Thread.sleep(30);
            }
            new Dashboard();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    Loading(String username) {
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel Management System");
        text.setBounds(85,25,600,50);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);
        
        bar=new JProgressBar();
        bar.setBounds(170,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("Loading, Please wait...");
        loading.setBounds(230,120,600,50);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);
        
        JLabel lbusername=new JLabel("Welcome "+username);
        lbusername.setBounds(20,310,400,40);
        lbusername.setForeground(Color.BLUE);
        lbusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lbusername);
        
        t.start();
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
