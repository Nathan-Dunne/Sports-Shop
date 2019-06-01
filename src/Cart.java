import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Cart
{
	protected static BigDecimal total;
	protected static int voucherNum;

	private ArrayList<Item> cartList = new ArrayList<Item>();
	private boolean shoesAdded;
	private boolean gumshieldAdded;
	private boolean rugbyballAdded;
	private boolean tracksuitAdded;
	private boolean bikePumpAdded;
	private int positionCounter;

	private CartPanel cartPanel;

	// Default and Argument Constructors
	public Cart(CartPanel cartPanel)
	{
		/*
		 * I've used aggregation here to pass in the CartPanel object to my
		 * Cart. This allows me to access the instance variables inside of it
		 * and modify them in methods below.
		 */

		this.cartPanel = cartPanel;

		cartList = new ArrayList<Item>();
		total = new BigDecimal("0");
	}

	public Cart(ArrayList<Item> c, BigDecimal t)
	{
		cartList = c;
		total = t;
	}

	// Setters and Getters
	public ArrayList<Item> getCartList()
	{
		return cartList;
	}

	public void setCartList(ArrayList<Item> c)
	{
		cartList = c;
	}

	public static BigDecimal getTotal()
	{
		/*
		 * I had a rounding error here that I used a band-aid fix of rounding it
		 * to 0 when I had the total as a double. Post-demo I refactored my
		 * program so that total was a BigDecimal, allowing me to dispense with
		 * the rounding error hassle. After some research it was surprisingly
		 * easy to work with the basic methods.
		 * 
		 * As an aside, this video: https://www.youtube.com/watch?v=PZRI1IfStY0
		 * helped me a great deal with better understanding floating point
		 * numbers.
		 */

		return total;
	}

	public void setTotal(BigDecimal t)
	{
		total = t;
	}

	public static int getVoucherNum()
	{
		return voucherNum;
	}

	public void setVoucherNum(int vN)
	{
		voucherNum = vN;
	}

	/*
	 * For my add to item cart method I attempted to execute a lot of arguments
	 * at once. Firstly it sets the gridx position of the cartpanel to 0. It
	 * then adds the item to the cart arraylist. It then updates the total by
	 * adding the item price and updates the total text on the cartpanel.
	 * 
	 * Finally it checks against each item name and then checks if that item has
	 * been added to the panel. If not, it adds it to the panel using a counter
	 * to determine its position. The boolean check is then made true.
	 * 
	 * For each instance of adding an item it updates the corresponding
	 * information on the panel.
	 */
	public void addItemToCart(Item item)
	{
		cartPanel.getCons().gridx = 0;
		cartList.add(item);
		total = total.add(item.getPrice());

		cartPanel.getTotalText().setText(Cart.getTotal().toString() + " Euro");

		if (item.getName() == "Nike Air Shoes")
		{

			if (!shoesAdded)
			{
				cartPanel.getCons().gridy = positionCounter;
				cartPanel.add(cartPanel.getShoesText(), cartPanel.getCons());
				positionCounter++;

				shoesAdded = true;
			}

			cartPanel.getShoesText().setText(item.getName() + " x " + (countCart(item)));
		}
		else if (item.getName() == "Shock Doctor Gumshield")
		{
			if (!gumshieldAdded)
			{
				cartPanel.getCons().gridy = positionCounter;
				cartPanel.add(cartPanel.getGumshieldText(), cartPanel.getCons());
				positionCounter++;

				gumshieldAdded = true;
			}

			cartPanel.getGumshieldText().setText(item.getName() + " x " + (countCart(item)));

		}
		else if (item.getName() == "Six Nations Rugby Ball")
		{
			if (!rugbyballAdded)
			{
				cartPanel.getCons().gridy = positionCounter;
				cartPanel.add(cartPanel.getRugbyballText(), cartPanel.getCons());
				positionCounter++;

				rugbyballAdded = true;
			}
			cartPanel.getRugbyballText().setText(item.getName() + " x " + (countCart(item)));

		}
		else if (item.getName() == "Reebok Tracksuit")
		{
			if (!tracksuitAdded)
			{
				cartPanel.getCons().gridy = positionCounter;
				cartPanel.add(cartPanel.getTracksuitText(), cartPanel.getCons());
				positionCounter++;

				tracksuitAdded = true;
			}

			cartPanel.getTracksuitText().setText(item.getName() + " x " + (countCart(item)));
		}
		else if (item.getName() == "CyclePro Bike Pump")
		{
			if (!bikePumpAdded)
			{
				cartPanel.getCons().gridy = positionCounter;
				cartPanel.add(cartPanel.getBikePumpText(), cartPanel.getCons());
				positionCounter++;

				bikePumpAdded = true;
			}

			cartPanel.getBikePumpText().setText(item.getName() + " x " + (countCart(item)));

		}

	}

	/*
	 * For the remove item method it basically does the opposite of the add to
	 * item method outside of updating the corresponding text fields.
	 */
	public void rvmItemFrmCart(Item item)
	{
		total = total.subtract(item.getPrice());

		cartList.remove(item);

		cartPanel.getTotalText().setText(Cart.getTotal().toString() + " Euro");

		if (item.getName() == "Nike Air Shoes")
		{
			cartPanel.getShoesText().setText(item.getName() + " x " + (countCart(item)));

			if (countCart(item) == 0)
			{
				cartPanel.remove(cartPanel.getShoesText());
				shoesAdded = false;
			}
		}
		else if (item.getName() == "Shock Doctor Gumshield")
		{
			cartPanel.getGumshieldText().setText(item.getName() + " x " + (countCart(item)));
			if (countCart(item) == 0)
			{
				cartPanel.remove(cartPanel.getGumshieldText());
				gumshieldAdded = false;
			}
		}
		else if (item.getName() == "Six Nations Rugby Ball")
		{
			cartPanel.getRugbyballText().setText(item.getName() + " x " + (countCart(item)));

			if (countCart(item) == 0)
			{
				cartPanel.remove(cartPanel.getRugbyballText());
				rugbyballAdded = false;
			}
		}
		else if (item.getName() == "Reebok Tracksuit")
		{
			cartPanel.getTracksuitText().setText(item.getName() + " x " + (countCart(item)));
			if (countCart(item) == 0)
			{
				cartPanel.remove(cartPanel.getTracksuitText());
				tracksuitAdded = false;
			}
		}
		else if (item.getName() == "CyclePro Bike Pump")
		{
			cartPanel.getBikePumpText().setText(item.getName() + " x " + (countCart(item)));
			if (countCart(item) == 0)
			{
				cartPanel.remove(cartPanel.getBikePumpText());
				bikePumpAdded = false;
			}
		}

	}

	/*
	 * Much like the stock counter this also passes in an item and checks
	 * against the sub class name while incrementing a counter.
	 */
	public int countCart(Item item)
	{
		int count = 0;
		for (Item i : cartList)
		{
			if (i.getName().equals(item.getName()))
			{
				count++;
			}
		}
		return count;
	}

	/*
	 * This simply generates a random number between 1 and 9999 for use as a
	 * voucher number 
	 */
	public static int genVoucher()
	{
		Random ran = new Random();
		voucherNum = ran.nextInt(9999) + 1;

		return voucherNum;
	}

	/*
	 * This method manipulates the BigDecimal to apply a discount to the total
	 * when called.
	 */
	public static void applyDiscount()
	{
		BigDecimal discount = new BigDecimal("0.1");

		total = total.subtract(total.multiply(discount));
	}

	// toString
	public String toString()
	{
		return "Cart" + cartList;
	}
}
