package accounting.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/Splash.jpg"));
        Image i2= i1.getImage().getScaledInstance(800,450,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        setVisible(true);
        thread= new Thread(this);
        thread.start();
    }
    public void run(){
        try {
            Thread.sleep(2500);
            setVisible(false);
            
            Login l = new Login();
            l.setVisible(true);
        }catch(Exception e) {
            
        }
    }
    
    public static void main(String[] args){
        Splash frame= new Splash();
        int x=1;
        for(int i=0; i<=500; x+=7, i+=6)
        {
            frame.setLocation(750-(x+i)/2, 400-(i/2));
            frame.setSize(x+i, i);
            try {
                Thread.sleep(5);
                
            }catch (Exception e){}
        }
    }
}
