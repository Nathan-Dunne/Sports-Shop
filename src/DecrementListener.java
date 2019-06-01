
/**
 * Author: Nathan Dunne
 * Date: 22/04/2016
 * Function: An action listener to decrement an item from the cart
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class DecrementListener implements ActionListener
{
	private Item item;
	private Stock stock;
	private Cart cart;
	private JLabel stockText;

	// Passing in all the required components
	public DecrementListener(Item item, JLabel stockText, Stock stock, Cart cart)
	{
		this.item = item;
		this.stockText = stockText;
		this.stock = stock;
		this.cart = cart;
	}

	// On click it will first check if the stock can be decremented and then
	// decrements the stock if true while updating the corresponding text
	public void actionPerformed(ActionEvent e)
	{
		if (stock.countStock(item) < 5)
		{
			stockText.setText(" In Stock: " + (stock.countStock(item) + 1));
			cart.rvmItemFrmCart(item);
			stock.addItemToStock(item);
		}
	}
}