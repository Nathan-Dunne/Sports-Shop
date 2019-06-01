
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Make an item super class.
 */

import java.math.BigDecimal;

public class RugbyBall extends Item
{

	private double size;
	private String color;

	// Default and Argument Constructors
	public RugbyBall()
	{
		super();
		size = 0;
		color = "null";
	}

	public RugbyBall(BigDecimal p, String n, double si, String c)
	{
		super(p, n);
		size = si;
		color = c;
	}

	// Setters and Getters
	public void setSize(double s)
	{
		size = s;
	}

	public Double getSize()
	{
		return size;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	// toString
	public String toString()
	{
		return super.toString() + "Size: " + size + "\nColor: " + color;
	}
}
