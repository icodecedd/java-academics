/**
 * null (first argument): Centers the dialog box on the screen.
 * "Hello " + name (second argument): Displays the personalized message.
 * "Welcome to Java Universe!" (third argument): Sets the dialog box title.
 * JOptionPane.PLAIN_MESSAGE (fourth argument): Defines the dialog box type.
 */


package java_lesson1;

import javax.swing.JOptionPane;

public class Lesson1DialogBox {

	public static void main(String[] args) {
		
		//Displaying Text in a Dialog Box
		
//		JOptionPane.showMessageDialog(null, "Welcome to Java Universe!");
//		System.exit(0);
		
		//Entering data in a Dialog box

//		String name;
//		name = JOptionPane.showInputDialog("Enter Your Name:");
//		JOptionPane.showMessageDialog(
//				null, // first argument
//				"Hello " + name, //second argument
//				"Welcome to Java Universe!", //third argument
//				JOptionPane.INFORMATION_MESSAGE //fourth argument
//				);
//		
//		System.exit(0);
		
		//Adding 2 integers in a dialog box
		
		String firstnum,secondnum;
		int sagot;
		
		firstnum = JOptionPane.showInputDialog("Enter first number ");
	    secondnum = JOptionPane.showInputDialog("Enter second number ");
	   
	    sagot = Integer.parseInt(firstnum) + Integer.parseInt(secondnum);
	    JOptionPane.showMessageDialog(
	    		null,
	    		"The sum is " + sagot,
	    		"Result",
	    		JOptionPane.INFORMATION_MESSAGE
	    		);
	    
	    System.exit(0);


	}

}
