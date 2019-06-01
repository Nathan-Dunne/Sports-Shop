
/**
 * Author: Nathan Dunne
 * Date: 12/04/2016
 * Function: Creating the panel to hold my BMI components.
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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BMIPanel extends JPanel
{
	private double weight = 0.0;
	private double height = 0.0;
	private double bmi = 0.0;
	boolean invalidInput;

	BMIPanel()
	{
		// Giving the panel a border title
		setBorder(BorderFactory.createTitledBorder("BMI Calculator"));

		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();

		// Creating my labels and input fields, settings insets, weights and the
		// gridy and x positions.
		cons.insets = new Insets(5, 5, 5, 5);
		cons.weightx = 0.5;
		cons.weighty = 0.5;

		JLabel heightLabel = new JLabel("Please enter your height in meters.");

		cons.gridx = 0;
		cons.gridy = 0;
		add(heightLabel, cons);

		// User height input
		JTextField heightField = new JTextField(10);
		cons.gridx = 0;
		cons.gridy = 1;

		add(heightField, cons);

		JLabel weightLabel = new JLabel("Please enter your weight in kilograms.");

		cons.gridx = 0;
		cons.gridy = 2;
		add(weightLabel, cons);

		// User weight input
		JTextField weightField = new JTextField(10);
		cons.gridx = 0;
		cons.gridy = 3;

		add(weightField, cons);

		JButton jb = new JButton("Enter");

		cons.gridx = 0;
		cons.gridy = 4;
		add(jb, cons);

		JButton exitBMIFrame = new JButton("Exit");
		exitBMIFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));

		ActionListener closeBMIFrame = new CloseBMIPanel();
		exitBMIFrame.addActionListener(closeBMIFrame);
		cons.gridx = 0;
		cons.gridy = 6;
		add(exitBMIFrame, cons);

		JLabel bmiLabel = new JLabel();

		cons.gridx = 0;
		cons.gridy = 5;
		add(bmiLabel, cons);

		/*
		 * On button click this listener will parse the input from the input
		 * fields as doubles, catch an exception if the user does not enter
		 * numbers, calculate the bmi based on the formula and output the
		 * results
		 */
		jb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean invalidInput = false;

				try
				{
					height = Double.parseDouble(heightField.getText());
					weight = Double.parseDouble(weightField.getText());
				}
				catch (Exception exception)
				{
					bmiLabel.setText("Please enter only numbers, thank you!");
					invalidInput = true;
				}

				bmi = (weight / (height * height));

				String bmiString = String.valueOf(String.format("%.0f", bmi));

				if (!invalidInput)
				{
					bmiLabel.setText("Your BMI is " + bmiString);
				}
			}
		});

	}

	// Closes the frame on click.
	class CloseBMIPanel implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{

			BMIFrameCreator.BMIFrame.dispose();
		}
	}
}
