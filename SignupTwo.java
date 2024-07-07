package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3;
    JCheckBox c1,c2,c3,c4,c5;
    JButton submit,cancel;
    String formno;
    
    SignupTwo( String formno){
        
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 2:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);

        JLabel card = new JLabel ("Card Number");
        card.setFont(new Font("raleway", Font.BOLD, 22));
        card.setBounds (100, 300, 200, 30);
        add(card);
        
        JLabel number  = new JLabel ("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("raleway", Font.BOLD, 22));
        number.setBounds (330, 300, 300, 30);
        add(number);
        
        JLabel pin  = new JLabel ("PIN");
        pin.setFont(new Font("raleway", Font.BOLD, 22));
        pin.setBounds (100, 370, 300, 30);
        add(pin);
        
        JLabel pnumber  = new JLabel ("XXXX");
        pnumber.setFont(new Font("raleway", Font.BOLD, 22));
        pnumber.setBounds (330, 370, 300, 30);
        add(pnumber);
        
        JLabel services  = new JLabel ("Services required");
        services.setFont(new Font("raleway", Font.BOLD, 22));
        services.setBounds (100, 450, 200, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("I Hereby declare that the above entered details are true to the best of my knowledge");
        c5.setFont(new Font("Raleway",Font.BOLD, 12));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,680,600,30);
        add(c5);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD, 12));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD, 12));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if(c2.isSelected()){
                facility = facility + "Internet banking";
            }else if(c3.isSelected()){
                facility = facility + "Mobile banking";
            }else if(c4.isSelected()){
                facility = facility + "Email & SMS Alerts";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupto values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')"; 
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')"; 

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card number: " + cardnumber + "\nPin: " + pinnumber);
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
}
