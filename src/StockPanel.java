
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Creating the stockpanel that will hold most of the programs visible information, 
 * it displays attributes of the items, increment and decrement buttons as well as instantiates the stock object
 */

import java.awt.*;
import java.math.BigDecimal;

import javax.swing.*;

public class StockPanel extends JPanel
{
	private Stock stock;
	private Gumshield gumshield;
	private Shoes shoes;
	private Tracksuit tracksuit;
	private BikePump bikePump;
	private RugbyBall rugbyBall;
	private IncrementListener incrementListener;
	private DecrementListener decrementListener;

	public StockPanel(Cart cart)
	{
		/*
		 * I've used composition here to create the Stock object and fill the
		 * stock inside of this StockPanel. This allows me to access it in the
		 * methods below without voiding a principle of least knowledge, like I
		 * did previously.
		 */

		this.stock = new Stock();

		shoes = new Shoes(new BigDecimal("59.99"), "Nike Air Shoes", 9);
		gumshield = new Gumshield(new BigDecimal("4.99"), "Shock Doctor Gumshield", 4, "Blue");
		tracksuit = new Tracksuit(new BigDecimal("8.99"), "Reebok Tracksuit", 8, "Orange");
		bikePump = new BikePump(new BigDecimal("7.99"), "CyclePro Bike Pump", 8, "Green");
		rugbyBall = new RugbyBall(new BigDecimal("9.99"), "Six Nations Rugby Ball", 8, "Brown");

		for (int i = 0; i < 5; i++)
		{
			stock.addItemToStock(shoes);
			stock.addItemToStock(gumshield);
			stock.addItemToStock(tracksuit);
			stock.addItemToStock(bikePump);
			stock.addItemToStock(rugbyBall);
		}

		setBorder(BorderFactory.createTitledBorder("Available items"));
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

		Color myColor = Color.decode("#B1BCDA");
		setBackground(myColor);

		cons.insets = new Insets(2, 2, 2, 2);

		// Adding the images to the buttons
		ImageIcon plusIcon = new ImageIcon("plus.png");
		ImageIcon minusIcon = new ImageIcon("minus.png");

		/*
		 * From here I am adding the item's respective icons, labels, name,
		 * price and amount of stock to the panel.
		 */

		// First Item - shoes - Shoes
		ImageIcon shoesIcon = new ImageIcon("shoes.png");
		JLabel shoesLabel = new JLabel(shoesIcon);
		JLabel shoesName = new JLabel(shoes.getName());
		JLabel shoesPrice = new JLabel(String.valueOf(shoes.getPrice()) + " Euro");
		JLabel shoesStock = new JLabel("In Stock: " + (stock.countStock(shoes)));

		JButton decrementShoes = new JButton(minusIcon);
		decrementShoes.setFocusPainted(false);
		decrementShoes.setCursor(cursor);
		decrementListener = new DecrementListener(shoes, shoesStock, stock, cart);
		decrementShoes.addActionListener(decrementListener);

		JButton incrementShoes = new JButton(plusIcon);
		incrementShoes.setFocusPainted(false);
		incrementListener = new IncrementListener(shoes, shoesStock, stock, cart);
		incrementShoes.addActionListener(incrementListener);

		cons.gridx = 0;
		cons.gridy = 0;
		add(shoesLabel, cons);

		cons.gridx = 1;
		cons.gridy = 0;
		add(shoesPrice, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		add(shoesName, cons);

		cons.gridx = 1;
		cons.gridy = 2;
		add(shoesStock, cons);

		cons.gridx = 0;
		cons.gridy = 3;
		add(decrementShoes, cons);

		cons.gridx = 1;
		cons.gridy = 3;
		add(incrementShoes, cons);

		// Second Item - tracksuit - Tracksuit
		ImageIcon tracksuitIcon = new ImageIcon("tracksuit.png");
		JLabel tracksuitLabel = new JLabel(tracksuitIcon);
		JLabel tracksuitName = new JLabel(tracksuit.getName());
		JLabel tracksuitPrice = new JLabel(String.valueOf(tracksuit.getPrice()) + " Euro");
		JLabel tracksuitStock = new JLabel("In Stock: " + (stock.countStock(tracksuit)));

		JButton decrementTracksuit = new JButton(minusIcon);
		decrementTracksuit.setCursor(cursor);
		decrementTracksuit.setFocusPainted(false);
		decrementListener = new DecrementListener(tracksuit, tracksuitStock, stock, cart);
		decrementTracksuit.addActionListener(decrementListener);

		JButton incrementTracksuit = new JButton(plusIcon);
		incrementTracksuit.setCursor(cursor);
		incrementTracksuit.setFocusPainted(false);
		incrementListener = new IncrementListener(tracksuit, tracksuitStock, stock, cart);
		incrementTracksuit.addActionListener(incrementListener);
		cons.insets = new Insets(20, 2, 2, 2);

		cons.gridx = 0;
		cons.gridy = 4;
		add(tracksuitLabel, cons);

		cons.gridx = 1;
		cons.gridy = 4;
		add(tracksuitPrice, cons);

		cons.insets = new Insets(2, 2, 2, 2);
		cons.gridx = 0;
		cons.gridy = 5;
		add(tracksuitName, cons);

		cons.gridx = 1;
		cons.gridy = 5;
		add(tracksuitStock, cons);

		cons.gridx = 0;
		cons.gridy = 6;
		add(decrementTracksuit, cons);

		cons.gridx = 1;
		cons.gridy = 6;
		add(incrementTracksuit, cons);

		// Third Item - bikePump - BikePump
		ImageIcon bikePumpIcon = new ImageIcon("bikepump.png");
		JLabel bikePumpLabel = new JLabel(bikePumpIcon);
		JLabel bikePumpName = new JLabel(bikePump.getName());
		JLabel bikePumpPrice = new JLabel(String.valueOf(bikePump.getPrice()) + " Euro");
		JLabel bikePumpStock = new JLabel("In Stock: " + (stock.countStock(bikePump)));

		JButton decrementBikePump = new JButton(minusIcon);
		decrementBikePump.setFocusPainted(false);
		decrementBikePump.setCursor(cursor);
		decrementListener = new DecrementListener(bikePump, bikePumpStock, stock, cart);
		decrementBikePump.addActionListener(decrementListener);

		JButton incrementBikePump = new JButton(plusIcon);
		incrementBikePump.setFocusPainted(false);
		incrementListener = new IncrementListener(bikePump, bikePumpStock, stock, cart);
		incrementBikePump.addActionListener(incrementListener);
		cons.insets = new Insets(20, 2, 2, 2);
		cons.gridx = 0;
		cons.gridy = 7;
		add(bikePumpLabel, cons);

		cons.gridx = 1;
		cons.gridy = 7;
		add(bikePumpPrice, cons);

		cons.insets = new Insets(2, 2, 2, 2);
		cons.gridx = 0;
		cons.gridy = 8;
		add(bikePumpName, cons);

		cons.gridx = 1;
		cons.gridy = 8;
		add(bikePumpStock, cons);

		cons.gridx = 0;
		cons.gridy = 9;
		add(decrementBikePump, cons);

		cons.gridx = 1;
		cons.gridy = 9;
		add(incrementBikePump, cons);

		// Forth Item - rugbyBall - RugbyBall
		ImageIcon rugbyBallIcon = new ImageIcon("rugbyball.png");
		JLabel rugbyBallLabel = new JLabel(rugbyBallIcon);
		JLabel rugbyBallName = new JLabel(rugbyBall.getName());
		JLabel rugbyBallPrice = new JLabel(String.valueOf(rugbyBall.getPrice()) + " Euro");
		JLabel rugbyBallStock = new JLabel("In Stock: " + (stock.countStock(rugbyBall)));

		JButton decrementRugbyBall = new JButton(minusIcon);

		decrementRugbyBall.setFocusPainted(false);
		decrementRugbyBall.setCursor(cursor);

		decrementListener = new DecrementListener(rugbyBall, rugbyBallStock, stock, cart);
		decrementRugbyBall.addActionListener(decrementListener);

		JButton incrementRugbyBall = new JButton(plusIcon);
		incrementRugbyBall.setFocusPainted(false);
		incrementListener = new IncrementListener(rugbyBall, rugbyBallStock, stock, cart);
		incrementRugbyBall.addActionListener(incrementListener);

		cons.insets = new Insets(20, 2, 2, 2);
		cons.gridx = 0;
		cons.gridy = 10;
		add(rugbyBallLabel, cons);

		cons.gridx = 1;
		cons.gridy = 10;
		add(rugbyBallPrice, cons);

		cons.insets = new Insets(2, 2, 2, 2);
		cons.gridx = 0;
		cons.gridy = 11;
		add(rugbyBallName, cons);

		cons.gridx = 1;
		cons.gridy = 11;
		add(rugbyBallStock, cons);

		cons.gridx = 0;
		cons.gridy = 12;
		add(decrementRugbyBall, cons);

		cons.gridx = 1;
		cons.gridy = 12;
		add(incrementRugbyBall, cons);

		// Fifth item
		ImageIcon gumshieldIcon = new ImageIcon("gumshield.png");

		JLabel gumshieldLabel = new JLabel(gumshieldIcon);
		JLabel gumshieldName = new JLabel(gumshield.getName());
		JLabel gumshieldPrice = new JLabel(String.valueOf(gumshield.getPrice()) + " Euro");
		JLabel gumshieldStock = new JLabel("In Stock: " + (stock.countStock(gumshield)));

		JButton decrementGumshield = new JButton(minusIcon);
		decrementGumshield.setFocusPainted(false);
		decrementGumshield.setCursor(cursor);
		decrementListener = new DecrementListener(gumshield, gumshieldStock, stock, cart);
		decrementGumshield.addActionListener(decrementListener);

		JButton incrementGumshield = new JButton(plusIcon);
		incrementGumshield.setFocusPainted(false);
		incrementListener = new IncrementListener(gumshield, gumshieldStock, stock, cart);
		incrementGumshield.addActionListener(incrementListener);

		cons.gridx = 0;
		cons.gridy = 13;
		add(gumshieldLabel, cons);

		cons.gridx = 1;
		cons.gridy = 13;
		add(gumshieldPrice, cons);

		cons.gridx = 0;
		cons.gridy = 14;
		add(gumshieldName, cons);

		cons.gridx = 1;
		cons.gridy = 14;
		add(gumshieldStock, cons);

		cons.insets = new Insets(2, 10, 20, 2);
		cons.gridx = 0;
		cons.gridy = 15;
		add(decrementGumshield, cons);

		cons.gridx = 1;
		cons.gridy = 15;
		add(incrementGumshield, cons);
	}

}
