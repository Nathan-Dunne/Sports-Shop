
/**
 * Author: Nathan Dunne
 * Date: 22/04/2016
 * Function: Contains the swing components for the instructions panel in the middle of the screen.
 */

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InstructionsPanel extends JPanel
{
	InstructionsPanel()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5,5, 5, 5);
		cons.weightx = 2;
		cons.weighty = 2;

		Color myColor = Color.decode("#B1BCDA");
		setBackground(myColor);

		ImageIcon semicolonIcon = new ImageIcon("semicolon.png");
		JLabel semicolonLabel = new JLabel(semicolonIcon);

		cons.gridx = 0;
		cons.gridy = 0;
		add(semicolonLabel, cons);

		JLabel fillerLabel = new JLabel("");
		cons.anchor = GridBagConstraints.NORTH;
		cons.weighty = 1;
		cons.gridx = 0;
		cons.gridy = 0;
		add(fillerLabel, cons);

		cons.weighty = 0.5;

		JLabel label5 = new JLabel("Hello World! Welcome to Semicolon Sports.");
		cons.gridx = 0;
		cons.gridy = 1;
		add(label5, cons);

		JLabel label6 = new JLabel("Please click on the plus button below an item to add that item to your cart and the minus button to remove it.");

		cons.insets = new Insets(20,5, 5, 5);
		cons.gridx = 0;
		cons.gridy = 2;
		add(label6, cons);

		JLabel fillerLabel2 = new JLabel("Your cart and subtotal is displayed in the top right hand corner.");

		cons.insets = new Insets(5,5, 5, 5);
		cons.gridx = 0;
		cons.gridy = 3;
		add(fillerLabel2, cons);

		JLabel fillerLabel3 = new JLabel("In the bottom right hand corner you can check out your items, calculate your BMI and exit.");

		cons.gridx = 0;
		cons.gridy = 4;
		add(fillerLabel3, cons);







	}
}
