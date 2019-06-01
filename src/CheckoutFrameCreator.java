/**
 * Author: Nathan Dunne
 * Date: 18/04/2016
 * Function: Creates the panel for the checkout or shows an error message to the user.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckoutFrameCreator implements ActionListener
{
	private CheckoutPanel checkoutPanel;
	protected static JFrame checkoutFrame;

	CheckoutFrameCreator(CheckoutPanel checkoutPanel)
	{
		this.checkoutPanel = checkoutPanel;
	}

	public void actionPerformed(ActionEvent arg0)
	{
		// This really should be if(cartlist.size == 0)
		BigDecimal zero = new BigDecimal("0");
		
		int  res = Cart.getTotal().compareTo(zero);
	
		// Showing a message dialog if the users cart is empty
		if (res == 0)
		{
			JOptionPane.showMessageDialog(null, "You can't checkout with no items!");

		}
		else // If the cart is not empty a new frame is created that shows the checkout area.
		{
			checkoutFrame = new JFrame();
			checkoutFrame.setSize(500, 350);
			checkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			checkoutFrame.setLocationRelativeTo(null);
			checkoutFrame.setVisible(true);

			// I put this statement here so it would generate the total at the
			// time this frame was instantiated.

			checkoutPanel.getTotalLabel().setText("The subtotal of your cart is " + Cart.getTotal().toString() + " Euro");

			checkoutFrame.add(checkoutPanel);

		}

	}

}