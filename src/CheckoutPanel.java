
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Adds the labels, textfields, buttons to the panel as well as creating the event on certain button clicks.
 */

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CheckoutPanel extends JPanel
{
	boolean invalidInput;
	private JLabel totalLabel;

	CheckoutPanel()
	{

		setBorder(BorderFactory.createTitledBorder("Checkout"));

		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		cons.insets = new Insets(5, 5, 5, 5);
		cons.weightx = 0.5;
		cons.weighty = 0.5;

		totalLabel = new JLabel();

		cons.gridx = 0;
		cons.gridy = 0;
		add(totalLabel, cons);

		JLabel voucherInformLabel = new JLabel("Please enter your voucher number for 10% off below.");

		cons.gridx = 0;
		cons.gridy = 2;
		add(voucherInformLabel, cons);

		// User voucher input
		JTextField voucherField = new JTextField(10);
		cons.gridx = 0;
		cons.gridy = 4;
		add(voucherField, cons);

		JLabel voucherLabel = new JLabel("Your voucher number for this session is: " + Cart.genVoucher());
		cons.gridx = 0;
		cons.gridy = 5;
		add(voucherLabel, cons);

		JButton enter = new JButton("Enter");

		cons.gridx = 0;
		cons.gridy = 6;
		add(enter, cons);

		JButton completeCheckout = new JButton("Checkout");
		completeCheckout.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ActionListener completeCheckoutFrame = new FinaliseCheckoutPanel();
		completeCheckout.addActionListener(completeCheckoutFrame);

		JButton exitCheckoutPanel = new JButton("Exit");
		exitCheckoutPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ActionListener closeCheckoutFrame = new CloseCheckoutPanel();
		exitCheckoutPanel.addActionListener(closeCheckoutFrame);
		cons.gridx = 0;
		cons.gridy = 8;
		add(exitCheckoutPanel, cons);

		/*
		 * On button click after the user has entered the voucher info it will
		 * check if it is the same as stored It will then apply the discount,
		 * update the total, remove the buttons that lead elsewhere.
		 */
		enter.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if (Integer.parseInt(voucherField.getText()) == Cart.getVoucherNum())
					{
						voucherInformLabel.setText("Voucher Number confirmed, thank you.");
						Cart.applyDiscount();
						String output = String.valueOf(String.format("%.2f", Cart.getTotal()));
						totalLabel.setText("The total of your items is: " + output + " Euro");

						remove(enter);
						remove(exitCheckoutPanel);
						remove(voucherField);
						remove(totalLabel);
						voucherLabel.setText("Your new total is " + output + " Euro");
						add(completeCheckout, cons);

						revalidate();
						repaint();
					}
					else
					{
						voucherInformLabel.setText("Voucher Number is invalid.");
					}
				}
				catch (Exception exception) // Catches an exception if the user
											// enters characters.
				{
					voucherInformLabel.setText("Please enter only numbers, thank you!");

				}
			}
		});

	}

	class CloseCheckoutPanel implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			CheckoutFrameCreator.checkoutFrame.dispose();
		}
	}

	// Shows the final message dialog on successful checkout.
	class FinaliseCheckoutPanel implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String output = String.valueOf(String.format("%.2f", Cart.getTotal()));

			// I wanted to make the first and third text parts of this message
			// dialog centered but couldn't get it to work.
			JOptionPane.showMessageDialog(null, "     Thanks for shopping at Semicolon Sports. \n \n" + output
					+ "  Euro has been deducted from your account." + "\n \n              The system will now close.");

			System.exit(0);
		}
	}

	public JLabel getTotalLabel()
	{
		return totalLabel;
	}

	public void setTotalLabel(JLabel totalLabel)
	{
		this.totalLabel = totalLabel;
	}
}