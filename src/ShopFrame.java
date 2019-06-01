
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Instantiate the ShopFrame object
 */

import java.awt.*;
import javax.swing.*;

public class ShopFrame extends JFrame
{
	//Creating the frame width and height, set as final as they won't change.
	private static final int FRAME_WIDTH = 1250;
	private static final int FRAME_HEIGHT = 700;

	//Creating my instance objects that are used within the class
	private Cart cart;
	private StockPanel stockPanel;
	private CartPanel cartPanel;
	private InstructionsPanel instructionsPanel;
	private OptionsPanel optionsPanel;

	public ShopFrame(String title)
	{
		super(title); 	// Passing in title as an argument, this title will be the title of the frame.

		setSize(FRAME_WIDTH, FRAME_HEIGHT); // Setting my size as the instance variables
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Setting my size as the instance variables
		setLocationRelativeTo(null); //Setting location relative to null will place it at the middle of the screen on startup
		setResizable(false); // I do not want my frame to be resizable.
		getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE)); // Creating the white border around the frame.

		ImageIcon img = new ImageIcon("resources/icon.png"); // Setting the top left hand icon to a custom icon.
		setIconImage(img.getImage());

		Color frameColor = Color.decode("#B1BCDA"); // Using a color decoder to interpret a hex color value
		getContentPane().setBackground(frameColor);

		createComponents();

		setVisible(true); // Need to set this true or it will be invisible.
	}

	public void createComponents()
	{
		setLayout(new GridBagLayout()); // Setting my layout manager to be GridbadLayout.
		
		// Creating the objects I will be using within the frame
		
		cartPanel = new CartPanel();
		cart = new Cart(cartPanel); // Passing cartPanel into cart.
		stockPanel = new StockPanel(cart); // Passing cart into stockPanel.
		instructionsPanel = new InstructionsPanel();
		optionsPanel = new OptionsPanel();

		
		// Adding each panel to the frame using GridBagConstraints, giving them weights, positions and anchors.
		
		GridBagConstraints panelCons = new GridBagConstraints();
		panelCons.weightx = 0.5;
		panelCons.weighty = 0.5;

		panelCons.anchor = GridBagConstraints.NORTHWEST;
		panelCons.gridx = 0;
		panelCons.gridy = 0;
		add(stockPanel, panelCons);

		panelCons.anchor = GridBagConstraints.NORTHEAST;
		panelCons.gridx = 0;
		panelCons.gridy = 0;
		add(cartPanel, panelCons);

		panelCons.anchor = GridBagConstraints.CENTER;
		panelCons.gridx = 0;
		panelCons.gridy = 0;
		add(instructionsPanel, panelCons);

		panelCons.anchor = GridBagConstraints.SOUTHEAST;
		panelCons.gridx = 0;
		panelCons.gridy = 0;
		add(optionsPanel, panelCons);

	}
}
