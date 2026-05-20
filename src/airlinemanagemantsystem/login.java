
package airlinemanagemantsystem;


import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {
    JButton submit;
    JButton reset;
    JButton close;
    JTextField tfusername;
    JPasswordField tfpassword;

    public login() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout((LayoutManager)null);
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        this.add(lblusername);
        this.tfusername = new JTextField();
        this.tfusername.setBounds(130, 20, 200, 20);
        this.add(this.tfusername);
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        this.add(lblpassword);
        this.tfpassword = new JPasswordField();
        this.tfpassword.setBounds(130, 60, 200, 20);
        this.add(this.tfpassword);
        this.reset = new JButton("Reset");
        this.reset.setBounds(40, 120, 120, 20);
        this.reset.addActionListener(this);
        this.add(this.reset);
        this.submit = new JButton("Submit");
        this.submit.setBounds(190, 120, 120, 20);
        this.submit.addActionListener(this);
        this.add(this.submit);
        this.close = new JButton("Close");
        this.close.setBounds(120, 160, 120, 20);
        this.close.addActionListener(this);
        this.add(this.close);
        this.setSize(400, 250);
        this.setLocation(600, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.submit) {
            String username = this.tfusername.getText();
            String password = this.tfpassword.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    System.out.println("valid");
                    new Home();
                    
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid Username or Password");
                    this.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == this.close) {
            this.setVisible(false);
        } else if (ae.getSource() == this.reset) {
            this.tfusername.setText("");
            this.tfpassword.setText("");
        }

    }

    public static void main(String[] args) {
        login login = new login();
    }
}
