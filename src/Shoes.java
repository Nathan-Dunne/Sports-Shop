
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Make a Shoes class.
 */

import java.math.BigDecimal;

public class Shoes extends Item
{
	private double size;

	// Default and Argument Constructors
	public Shoes()
	{
		super();
		size = 0;
	}

	public Shoes(BigDecimal p, String n, double si)
	{
		super(p, n);
		size = si;
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

	// toString
	public String toString()
	{
		return super.toString() + "Size: " + size;
	}
}
