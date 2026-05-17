package airlinemanagemantsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {
    public Home() {
        this.setLayout((LayoutManager)null);
        var i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagemantsystem/icons/a2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        this.add(image);
        
        
        JLabel heading = new JLabel("AIR INDIA Welcome You!!..");
        heading.setBounds(500, 40, 3000, 50);
        heading.setForeground(Color.black);
        heading.setFont(new Font("Arial Black", Font.ITALIC, 50));
        image.add(heading);
        
        
        
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
       flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
      customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
     bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
       journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        JMenuItem BoardingPass = new JMenuItem("Boarding Pass");
        BoardingPass.addActionListener(this);
        ticket.add(BoardingPass);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
    } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
       } else if (text.equals("Cancel Ticket")) {
           new Cancel();
     }else if (text.equals("Boarding Pass")) {
         new BoardingPass();

     


    }
    }

    
    public static void main(String[] args) {
      new Home();
        
        
    }
}
