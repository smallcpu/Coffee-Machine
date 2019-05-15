import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//Jorell Socorro
public class SimpleGUI extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  JLabel l1, l2, l3, l4, l5;//jorell
  JButton b1, b2; ///jorell
  JTextField t1, t2, t3, t4;
  JCheckBox check1;//jorell
  JRadioButton r1;
   
  SimpleGUI() //constructor method
  {
	  //initializes
    l1 = new JLabel(" Current Salary");
    l2 = new JLabel(" Percent Rate (write the whole number)");
    l3 = new JLabel(" New Salary");
    l4 = new JLabel("   ");//jorell
    l5 = new JLabel(" Difference");
    b1 = new JButton("Compute");
    b2 = new JButton("EXIT");//jorell
    t1 = new JTextField(10); //creates the textbox for inputs
    t2 = new JTextField(10);
    t3 = new JTextField(10);
    t4 = new JTextField(10);
    check1 = new JCheckBox("Bonus Pay");//jorell
    r1 = new JRadioButton("test");
    
    //creates the gui image
    add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l3);
    add(t3);
    add(check1);//jorell
    add(l4);//jorell
    add(l5);
    add(t4);
    add(b1);
    add(b2);//jorell
    add(r1);
    
    //Actions for the buttons or checks
    b1.addActionListener(this);
    b2.addActionListener(e -> System.exit(0));//jorell
    check1.setSelected(false);//jorell
  
    setSize(500,300);
    				//       r c
    setLayout(new GridLayout(7,2));//jorell
    setTitle("Simple Java GUI");
  }

  public void actionPerformed(ActionEvent ae) //does all the calculation after pressing a button
  {
    float currentSalary, percentRate, newSalary = 0;
    float percentPrice, salaryPercent, salaryDiff = 0;
    if(ae.getSource() == b1)//compute button
    {
    	if(check1.isSelected()) {//jorell
		currentSalary = Float.parseFloat(t1.getText());
		percentRate = Float.parseFloat(t2.getText());
	  
		percentPrice = percentRate/100;//converts the percent value
		salaryPercent = percentPrice * currentSalary;//gets the percent value from current salary
		newSalary = currentSalary + salaryPercent;//adds to new salary
	
    	newSalary = newSalary + 500;//the difference
    	salaryDiff = newSalary - currentSalary;//difference from new salary with current
    	}
	    else { //jorell
	    	// perform different task
	    	currentSalary = Float.parseFloat(t1.getText());
			percentRate = Float.parseFloat(t2.getText());
		  
			percentPrice = percentRate/100;//converts the percent value
			salaryPercent = percentPrice * currentSalary;//gets the percent value from current salary
			newSalary = currentSalary + salaryPercent;//adds to new salary
			salaryDiff = newSalary - currentSalary;//difference from new salary with current
			
	    }
      t3.setText(String.valueOf(newSalary));//outputs new Salary in box
      t4.setText(String.valueOf(salaryDiff));
    } 
    
  }
  
  public static void main(String args[])
  {
    SimpleGUI a = new SimpleGUI();
    a.setVisible(true);
    a.setLocation(200, 200);
  }
}

