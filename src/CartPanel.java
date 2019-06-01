
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Create the framework for the cartpanel
 */

import java.awt.*;
import javax.swing.*;


public class CartPanel extends JPanel
{
	private JLabel totalText;
	private JLabel shoesText;
	private JLabel gumshieldText;
	private JLabel rugbyballText;
	private JLabel tracksuitText;
	private JLabel bikePumpText;
	protected static int positionCount;
	private GridBagConstraints cons;

	public CartPanel()
	{
	
		setBorder(BorderFactory.createTitledBorder("Cart Area"));

		Color myColor = Color.decode("#B1BCDA");
		setBackground(myColor);

		cons = new GridBagConstraints();
		cons.insets = new Insets(5, 5, 5, 5);

		setLayout(new GridBagLayout());

		JLabel totalLabel = new JLabel("Total: ");
		
		totalText = new JLabel("0.00 Euro");

		shoesText = new JLabel();
		gumshieldText = new JLabel();
		rugbyballText = new JLabel();
		tracksuitText = new JLabel();
		bikePumpText = new JLabel();

		cons.gridx = 0;
		cons.gridy = 0;
		add(shoesText, cons);

		cons.gridx = 0;
		cons.gridy = 1;
		add(gumshieldText, cons);

		cons.gridx = 0;
		cons.gridy = 2;
		add(rugbyballText, cons);

		cons.gridx = 0;
		cons.gridy = 3;
		add(tracksuitText, cons);

		cons.gridx = 0;
		cons.gridy = 4;
		add(bikePumpText, cons);

		cons.gridx = 1;
		cons.gridy = 0;
		add(totalLabel, cons);

		cons.gridx = 2;
		cons.gridy = 0;
		add(totalText, cons);

	}

	public GridBagConstraints getCons()
	{
		return cons;
	}

	public JLabel getTotalText()
	{
		return totalText;
	}

	public void setTotalText(JLabel totalText)
	{
		this.totalText = totalText;
	}

	public JLabel getShoesText()
	{
		return shoesText;
	}

	public void setShoesText(JLabel jLabel)
	{
		this.shoesText = jLabel;
	}

	public JLabel getGumshieldText()
	{
		return gumshieldText;
	}

	public void setGumshieldText(JLabel jLabel)
	{
		this.gumshieldText = jLabel;
	}

	public JLabel getRugbyballText()
	{
		return rugbyballText;
	}

	public void setRugbyballText(JLabel jLabel)
	{
		this.rugbyballText = jLabel;
	}

	public JLabel getTracksuitText()
	{
		return tracksuitText;
	}

	public void setTracksuitText(JLabel jLabel)
	{
		this.tracksuitText = jLabel;
	}

	public JLabel getBikePumpText()
	{
		return bikePumpText;
	}

	public void setBikePumpText(JLabel jLabel)
	{
		this.bikePumpText = jLabel;
	}

}
