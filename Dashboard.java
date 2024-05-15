package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    JButton addPassenger,viewPassengers,employees;
    JButton reminders,monthlyBills;
    JButton calculator,about; 
    
    Dashboard() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPassenger=new JButton("Add Passenger");
        addPassenger.setBounds(0,0,300,50);
        addPassenger.setBackground(new Color(0,0,102));
        addPassenger.setForeground(Color.WHITE);
        addPassenger.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPassenger.addActionListener(this);
        p2.add(addPassenger);
        
        viewPassengers=new JButton("View Passengers");
        viewPassengers.setBounds(0,60,300,50);
        viewPassengers.setBackground(new Color(0,0,102));
        viewPassengers.setForeground(Color.WHITE);
        viewPassengers.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPassengers.addActionListener(this);
        //busReports.setMargin(new Insets(0,0,0,130));
        p2.add(viewPassengers);
        /*
        JButton busReports=new JButton("Bus Reports");
        busReports.setBounds(0,120,300,50);
        busReports.setBackground(new Color(0,0,102));
        busReports.setForeground(Color.WHITE);
        busReports.setFont(new Font("Tahoma",Font.PLAIN,20));
        p2.add(busReports);
        
        JButton branchSales=new JButton("Branch Sales");
        branchSales.setBounds(0,180,300,50);
        branchSales.setBackground(new Color(0,0,102));
        branchSales.setForeground(Color.WHITE);
        branchSales.setFont(new Font("Tahoma",Font.PLAIN,20));
        p2.add(branchSales);
        */              
        employees=new JButton("Employees");
        employees.setBounds(0,120,300,50);
        employees.setBackground(new Color(0,0,102));
        employees.setForeground(Color.WHITE);
        employees.setFont(new Font("Tahoma",Font.PLAIN,20));
        employees.addActionListener(this);
        p2.add(employees);
        
        monthlyBills=new JButton("Monthly Bills");
        monthlyBills.setBounds(0,180,300,50);
        monthlyBills.setBackground(new Color(0,0,102));
        monthlyBills.setForeground(Color.WHITE);
        monthlyBills.setFont(new Font("Tahoma",Font.PLAIN,20));  
        monthlyBills.addActionListener(this);
        p2.add(monthlyBills);
        
        reminders=new JButton("Reminder");
        reminders.setBounds(0,240,300,50);
        reminders.setBackground(new Color(0,0,102));
        reminders.setForeground(Color.WHITE);
        reminders.setFont(new Font("Tahoma",Font.PLAIN,20));
        reminders.addActionListener(this);
        p2.add(reminders);
        
        calculator=new JButton("Calculator");
        calculator.setBounds(0,300,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        about=new JButton("About");
        about.setBounds(0,360,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.addActionListener(this);
        p2.add(about);  
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel icon2=new JLabel(i6);
        icon2.setBounds(160,0,1650,1000);
        add(icon2);
        
        JLabel text=new JLabel("Travels Management System");
        text.setBounds(400,70,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        icon2.add(text);
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==addPassenger) {
            new AddPassenger();
        }
        else if(ae.getSource()==viewPassengers) {
            new ViewPassenger();
        }
        else if(ae.getSource()==employees) {
            new Employee();
        }
        else if(ae.getSource()==monthlyBills) {
            new MonthlyBills();
        }
          else if(ae.getSource()==reminders) {
            new Reminder();
        }        
        else if(ae.getSource()==calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");              
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==about) {
            new About();
        }      
    }
    
    public static void main(String[] args) {        
        new Dashboard();
    }
    
}
