
/**
 * Author: Nathan Dunne
 * Date: 24/04/2016
 * Function: Contains the swing components for the options panel in the bottom right of the screen.
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class OptionsPanel extends JPanel
{
	private BMIPanel BMIPanel;
	private CheckoutPanel checkoutPanel;

	OptionsPanel()
	{
		Color myColor = Color.decode("#B1BCDA");

		setBackground(myColor);
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(15, 15, 15, 15);
		
		JButton checkout = new JButton("Checkout");
		
		// Changes the cursor to be a hand instead of a pointer
		checkout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		checkoutPanel = new CheckoutPanel();
		
		ActionListener checkoutFrame = new CheckoutFrameCreator(checkoutPanel);
		checkout.addActionListener(checkoutFrame);
		
		cons.gridx = 0;
		cons.gridy = 0;
		add(checkout, cons);
		
		JButton BMICalc = new JButton("BMI Calculator");
		BMICalc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		BMIPanel = new BMIPanel();

		ActionListener BMIFrame = new BMIFrameCreator(BMIPanel);
		BMICalc.addActionListener(BMIFrame);
		
		cons.gridx = 0;
		cons.gridy = 1;
		add(BMICalc, cons);
		
		JButton exit = new JButton("Exit");
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ActionListener listener = new CloseShop();
		exit.addActionListener(listener);
		
		cons.gridx = 0;
		cons.gridy = 2;
		add(exit, cons);
		
	}
	
	// Listener to close the program on button click.
	class CloseShop implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
	        System.exit(0);
		}
	}


}
