
/**
 * Author: Nathan Dunne
 * Date: 22/04/2016
 * Function: An action listener to increment an item to the cart
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class IncrementListener implements ActionListener
{
	private Item item;
	private Stock stock;
	private Cart cart;
	private JLabel stockText;

	public IncrementListener(Item item, JLabel stockText, Stock stock, Cart cart)
	{
		this.item = item;
		this.stockText = stockText;
		this.stock = stock;
		this.cart = cart;
	}

	// Much like the decrement listener this performs the opposite action, checking instead if there is actually any items in the stock.
	public void actionPerformed(ActionEvent e)
	{
		if (stock.countStock(item) > 0)
		{
			stockText.setText(" In Stock: " + (stock.countStock(item) - 1));
			cart.addItemToCart(item);
			stock.rvmItemFrmStock(item);
		}
	}
}