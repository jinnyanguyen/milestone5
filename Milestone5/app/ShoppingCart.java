package app;

import java.util.ArrayList;

/**
 * A class that represents a shopping cart.
 */
public class ShoppingCart 
{
	private ArrayList<SalableProduct> cart; // The list of products in the shopping cart
	
	 /**
     * Constructs a new ShoppingCart object with an empty list of products.
     */
	public ShoppingCart() 
	{
		cart = new ArrayList<SalableProduct>();
	}
	
	/**
     * Adds a product to the shopping cart.
     * @param product the product to add
     */
	public void addProduct(SalableProduct product) 
	{
		cart.add(product);
	}

	/**
     * Removes a product from the shopping cart.
     * @param product the product to remove
     */
	public void removeProduct(SalableProduct product)
	{
		cart.remove(product);
	}

	/**
     * Returns the contents of the shopping cart.
     * @return an ArrayList of SalableProduct objects representing the contents of the cart
     */
	public ArrayList<SalableProduct> getContents()
	{
		return cart;
	}


    /**
     * Displays the current contents of the shopping cart.
     */
	public void displayContents() 
	{
		if (cart.size() == 0) 
		{
			System.out.println("The shopping cart is empty.");
		} 
		else 
		{
			System.out.println("Shopping Cart Contents:");
			for (SalableProduct product : cart ) 
			{
				System.out.println(product.getName() + " - " + product.getPrice());
			}
		}
	}
	
	
	/**
    * Empties the contents of the shopping cart.
    * @return an empty ArrayList of SalableProduct objects representing the contents of the cart
    */
	public ArrayList<SalableProduct> emptyCart() 
	{
		cart.clear();
		System.out.println("Cart is empty");
		return cart;
		
	}
}

