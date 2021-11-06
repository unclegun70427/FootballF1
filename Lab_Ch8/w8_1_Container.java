import java.awt.*;
import javax.swing.*;

class w8_1_Container
{
    public static void main(String[] args) 
    {
	JFrame frame = new JFrame("This is a Frame");

	// ----- (1) Minimum properties that must be set
	frame.setBounds(200, 200, 600, 300);
	frame.setVisible(true);


	// ----- (2) Other properties
	//           - which one doesn't work ?
	//           - notice the difference between EXIT_ON_CLOSE and DISPOSE_ON_CLOSE
	/*
        frame.setMaximizedBounds( new Rectangle(800, 500) );
	frame.setResizable(true);
	frame.setBackground( new Color(100, 150, 250) );
	//frame.setBackground( Color.BLUE );
	frame.setCursor( new Cursor(Cursor.WAIT_CURSOR) );
	frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add( new JTextField("type anything", 20) );
        frame.validate();
	*/


	// ----- (3) Dialog
	//           - notice the difference between dialog with and without owner
	//           - notice the difference between modal and non-modal dialogs
	/*
	JDialog dialog = new JDialog();
	dialog.setTitle("This is a Dialog");
	dialog.setModal(false);
	dialog.setBounds(400, 400, 300, 150 );
	dialog.setVisible(true);
	dialog.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
	*/


	// ----- (4) Quick dialog
	/*
	int op = JOptionPane.showConfirmDialog( frame, 
		 "Press the button", "This is a Confirm Dialog", 
	         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );

	JOptionPane.showMessageDialog( frame, 
		 ("Option  =  " + op), "This is a Message Dialog", 
		 JOptionPane.INFORMATION_MESSAGE );
	*/
    }
}
