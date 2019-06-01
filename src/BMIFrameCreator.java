import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BMIFrameCreator implements ActionListener
{
	private BMIPanel BMIPanel;
	protected static JFrame BMIFrame;

	BMIFrameCreator(BMIPanel BMIPanel)
	{
		this.BMIPanel = BMIPanel;
	}

	/*
	 * On button click a new frame is made that will hold the bmi panel
	 */
	public void actionPerformed(ActionEvent arg0)
	{
		BMIFrame = new JFrame();
		BMIFrame.setSize(300, 350);
		BMIFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BMIFrame.setLocationRelativeTo(null);
		BMIFrame.setVisible(true);

		BMIFrame.add(BMIPanel);
	}

}