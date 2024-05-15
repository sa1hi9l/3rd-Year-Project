package accounting.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder extends JFrame implements ActionListener {
     JTextField reminderInput;
     JTextField timeInput;
     Timer timer;

    Reminder() {
        setTitle("Set Reminder");
        setLayout(null);
        setBounds(40,40,400, 200);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,400,200);

        JLabel reminderLabel = new JLabel("Reminder :");
        setLayout(null);
        reminderLabel.setBounds(0,0,100,50);
        
        reminderInput = new JTextField();
        reminderInput.setBounds(100,12,250,30);
        
        JLabel timeLabel = new JLabel("Time (minutes):");
        timeLabel.setBounds(0,50,100,50);
        
        timeInput = new JTextField();
        timeInput.setBounds(100,60,200,30);

        JButton setReminderButton = new JButton("Set Reminder");
        setReminderButton.setBounds(120,110,150,30);
        
        setReminderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setReminder();
            }
        });

        panel.add(reminderLabel);
        panel.add(reminderInput);
        panel.add(timeLabel);
        panel.add(timeInput);
        panel.add(new JLabel());
        panel.add(setReminderButton);
        add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
    }

     void setReminder() {
        String reminderText = reminderInput.getText();
        int minutes = Integer.parseInt(timeInput.getText());

        if (reminderText.trim().isEmpty() || minutes <= 0) {
            JOptionPane.showMessageDialog(this, "Please enter a valid reminder and time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.schedule(new RemindTask(reminderText), minutes * 60 * 1000);

        JOptionPane.showMessageDialog(this, "Reminder set for " + minutes + " minutes.", "Reminder Set", JOptionPane.INFORMATION_MESSAGE);
    }

     class RemindTask extends TimerTask {
         String reminderText;

        public RemindTask(String reminderText) {
            this.reminderText = reminderText;
        }

        public void run() {
            showReminder(reminderText);
        }
    }

     void showReminder(String reminderText) {
        JOptionPane.showMessageDialog(this, reminderText, "Reminder", JOptionPane.INFORMATION_MESSAGE);
    }
     
      public void  actionPerformed(ActionEvent ae) {
        setVisible(true);
    }

    public static void main(String[] args) {
        //new Reminder().setVisible(true);;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Reminder().setVisible(true);
            }
        });
    }
}
