package accounting.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ViewPassenger extends JFrame implements ActionListener{
    
    JTable j1;
    JButton show;
    
    ViewPassenger() {
        
        setBounds(350,140,900,655);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         
       /* JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(10,10,425,460);
        add(p1); */
       
        j1=new JTable();
        j1.setLayout(null);
        //j1.setBackground(new Color(133,193,233));
        j1.setBounds(40,40,805,400);
        JScrollPane scroll=new JScrollPane();
        j1.add(scroll);
        add(j1);
        
        show=new JButton("Show");
        show.setBounds(320,420,200,50);
        show.addActionListener(this);
        add(show);
        /*
        JLabel lbName=new JLabel("Name");
        lbName.setBounds(30,50,150,25);
        p1.add(lbName);
        
        JLabel disName=new JLabel();
        disName.setBounds(80,50,150,25);
        p1.add(disName);
        
        JLabel lbid=new JLabel("ID");
        lbid.setBounds(30,90,150,25);
        p1.add(lbid);
        
        JLabel disId=new JLabel();
        disId.setBounds(80,90,150,25);
        p1.add(disId);
        
        JLabel lbEmail=new JLabel("email");
        lbEmail.setBounds(30,130,150,25);
        p1.add(lbEmail);
        
        JLabel disEmail=new JLabel();
        disEmail.setBounds(80,130,150,25);
        p1.add(disEmail);
        
        JLabel lbPhNo=new JLabel("Phone Number");
        lbPhNo.setBounds(30,170,150,25);
        p1.add(lbPhNo);
        
        JLabel disPhNo=new JLabel();
        disPhNo.setBounds(80,170,150,25);
        p1.add(disPhNo);
        */
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2= i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,550,1100);
        add(image);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5= i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image2= new JLabel(i6);
        image2.setBounds(555,0,550,1100);
        add(image2);
  
        setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== show) {
        try {                      
            Conn c=new Conn();
            String query="select * from customer";
                
                ResultSet rs=c.s.executeQuery(query);
                ResultSetMetaData rsmd=rs.getMetaData();
                int cols=rsmd.getColumnCount();
                DefaultTableModel model=(DefaultTableModel)j1.getModel();
                
                String [] colName=new String [cols];
                
                for(int i=0; i<cols;i++) {
                    colName[i]=rsmd.getColumnName(i+1);
                    model.setColumnIdentifiers(colName);                    
                }
                while(rs.next()) {
                    String name,desti,travel_date,id,email,phno;
                    name=rs.getString(1);
                    desti=rs.getString(2);
                    travel_date=rs.getString(3);
                    id=rs.getString(4);
                    email=rs.getString(5);
                    phno=rs.getString(6);
                    String[] row ={name,desti,travel_date,id,email,phno};
                    model.addRow(row);                                      
                }      
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args) {
        new ViewPassenger();
    }
}

