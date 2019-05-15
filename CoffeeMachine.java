import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import java.text.*;

//Jorell Socorro

public class CoffeeMachine extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  JLabel l1, l2, l3, l4, l5, l6, l7, l8;
  JButton b1, b2;
  JTextField t1, t2, t3;
  JCheckBox cream, raw, espresso; 
  private JMenuBar menuBar;
  private JRadioButton small;
  private JRadioButton medium;
  private JRadioButton large;
  private ButtonGroup group;

  CoffeeMachine()
  {

	  
	//MENU BAR
	menuBar = new JMenuBar();
	
	JMenu mnFile = new JMenu("File");
	menuBar.add(mnFile);
	JMenuItem mntmExit = new JMenuItem("Exit");
	mnFile.add(mntmExit);
	
	JMenu mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);
	JMenuItem mntmAbout = new JMenuItem("About");
	mnHelp.add(mntmAbout);
	setJMenuBar(menuBar);//CREATES THE MENUBAR
	
	mntmExit.addActionListener(e -> System.exit(0));
	  
	mntmAbout.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0)
		 {
		   JOptionPane.showMessageDialog(null, "Your Message", 
		   "About", JOptionPane.PLAIN_MESSAGE);
		 }
	});
	//MENUBAR
	
	
    l1 = new JLabel(" Customer Name");
    l2 = new JLabel(" amount to pay");
    l3 = new JLabel("  "); 
    l4 = new JLabel("  ");
    l5 = new JLabel("  ");
    l6 = new JLabel("  ");
    l7 = new JLabel("  ");
    l8 = new JLabel("  ");//not assigned

    b1 = new JButton("COMPUTE");
    b2 = new JButton("EXIT");
  
    t1 = new JTextField(10);
    t2 = new JTextField(10);
    //create the buttons
     
    small = new JRadioButton("small", true);
    medium = new JRadioButton("medium",false);
    large = new JRadioButton("large", false);
    group = new ButtonGroup();
    group.add(small);
    group.add(medium);
    group.add(large);

    cream = new JCheckBox("cream", false);
    raw = new JCheckBox("raw sugar", false);
    espresso = new JCheckBox("espresso shot", false);
    //read the list left to right (2 by 9)
    add(l1); 
    add(t1); //user input
    add(small); //radio
    add(cream); //checkbox
    add(medium);//radio
    add(raw);//checkbox
    add(large); //radio
    add(espresso);//checkbox
    add(l3);
    add(l7);
    add(l2);//amount to pay
    add(t2);//box
    add(l5);//whitespace
    add(l6);//whitespace
    add(b1);
    add(b2);
    b1.addActionListener(this);
    b2.addActionListener(e -> System.exit(0));
    setSize(500,300);
    setLayout(new GridLayout(8,2));
    setTitle("Coffee Machine");
  }
  
 
  
  public void actionPerformed(ActionEvent ae)
  {
	String pattern = "####.##";
	DecimalFormat decimalFormat = new DecimalFormat(pattern);//adjusted the decimal price
    double price = 0;
    String name = "", order = "", introduction = " Enjoy your coffee beverage!",
    		creamC = "", rawC = "", exC = "", smallC = "", medC="", largeC = "", totalOrder=""; 
    //Everytime the user adds a certain thing it will add to the price
    if (cream.isSelected() == true) 
    {
      creamC = "with cream ";
      price = price + 0.75;
    } 
    if (raw.isSelected() == true) 
    {
      rawC = "with raw sugar ";
      price = price + 0.75;
    } 
    if (espresso.isSelected() == true) 
    {
      exC = "an expresso shot ";
      price = price + 0.75;
    } 
    if (small.isSelected() == true) 
    {
    	System.out.println("small");
      	smallC = "Small Coffee \n";
      	price = price + 1.25;
    }
    if (medium.isSelected() == true) 
    {
    	System.out.println("small");
      	medC = "Medium Coffee \n";
      	price = price + 1.75;
    }
    if (large.isSelected() == true) 
    {
    	System.out.println("large");
      	largeC = "Large Coffee \n";
      	price = price + 2.30;
    }
    
	if(ae.getSource() == b1) //if compute was pressed
	    {			    	  		
			name = t1.getText();//this is my name
			try {//to see if its straight up numbers
				int test = Integer.parseInt(name);//to see if its straight up numbers
				JOptionPane.showMessageDialog(null, "Try again no integers", "error", JOptionPane.PLAIN_MESSAGE);
			} catch (Exception e){ 			
    			order = "your order : " + smallC + largeC + creamC + rawC + exC;//this should be the choices selected
				totalOrder = "Total purchase : $ " + decimalFormat.format(price);
				t2.setText("thank you: " + name );
	    		JOptionPane.showMessageDialog(null, "Summary: \n" + "Hello "+ name + "!!" + introduction + "\n" + order + "\n" + totalOrder, 
	    				  "Order Summary", JOptionPane.PLAIN_MESSAGE); 
			 	}			
		}   			        		      	   		   		
}	    

  public static void main(String args[])
  {
    CoffeeMachine a = new CoffeeMachine();
    a.setVisible(true);
    a.setLocation(200,200);
  }
}
