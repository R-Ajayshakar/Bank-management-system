package bankmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, pinchange, balanceenquiry, exit;
    String pinnumber;

    Transactions(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 300, 700, 35);
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 450, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355, 450, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        pinchange = new JButton("Pin change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 555, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("");
    }
}
