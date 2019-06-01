
/**
 * Author: Nathan Dunne
 * Date: 18/04/2016
 * Function: Provide the framework for keeping track of and storing stock.
 */

import java.util.ArrayList;

public class Stock
{
	private ArrayList<Item> stockList = new ArrayList<Item>();

	// Default and Argument Constructors
	public Stock()
	{
		stockList = new ArrayList<Item>();
	}

	public Stock(ArrayList<Item> c)
	{
		stockList = c;
	}

	// Setters and Getters
	public ArrayList<Item> getStockList()
	{
		return stockList;
	}

	public void setCartList(ArrayList<Item> c)
	{
		stockList = c;
	}

	// These simply add or remove the passed in item to the stock arraylist
	public void addItemToStock(Item item)
	{
		stockList.add(item);
	}

	public void rvmItemFrmStock(Item item)
	{
		stockList.remove(item);
	}

	/*
	 * Using an enchanced for loop I pass in the item object and then check how
	 * many there are by comparing the sub class String name of the item,
	 * incrementing a counter as it loops.
	 */

	public int countStock(Item item)
	{
		int count = 0;

		for (Item i : stockList)
		{
			if (i.getName().equals(item.getName()))
			{
				count++;
			}
		}

		return count;
	}

	public String toString()
	{
		return "Stock" + stockList;
	}
}
