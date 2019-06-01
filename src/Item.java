
/**
 * Author: Nathan Dunne
 * Date: 15/04/2016
 * Function: Make an item super class.
 */

import java.math.BigDecimal;

public class Item
{
	// Using BigDecimal for the price
	private BigDecimal price;
	private String name;

	// Default and Argument Constructors
	public Item()
	{
		price = new BigDecimal("0");
		name = "null";
	}

	public Item(BigDecimal p, String n)
	{
		price = p;
		name = n;
	}

	// Setters and Getters
	public void setPrice(BigDecimal p)
	{
		price = p;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setName(String n)
	{
		name = n;
	}

	public String getName()
	{
		return name;
	}

	// toString
	public String toString()
	{
		return "\nPrice: " + price + "\nName: " + name + "\n";
	}
}
