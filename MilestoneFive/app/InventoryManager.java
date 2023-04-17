package app;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The InventoryManager class represents a Java class for managing inventory of salable products
 * using the Jackson library for JSON processing.
 */
public class InventoryManager 
{
    private List<SalableProduct> inventory;

    /**
     * Constructs a new InventoryManager object with an empty inventory.
     */
    public InventoryManager() 
    {
        inventory = new ArrayList<SalableProduct>();
    }
    
    /**
     * Initializes the inventory by reading from a JSON file and populating the inventory with
     * SalableProduct objects obtained from the file.
     */
    public void initInventory() 
    {
        System.out.println("Initializing inventory...");

        try {
            String path = "src/app/inventory.json"; // path to the JSON file
            ObjectMapper mapper = new ObjectMapper(); // creating a new ObjectMapper object
            inventory = Arrays.asList(mapper.readValue(new File(path), SalableProduct[].class)); // reading the JSON file and converting it to an array of SalableProduct objects using Jackson library
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage()); // printing error message in case of any exception
        }

        System.out.println("Inventory initialized.\n"); // printing a message after successful initialization
    }

    /**
     * Removes a specified product from the inventory.
     *
     * @param product the product to be removed from the inventory
     */
    public void removeProduct(SalableProduct product)
    {
        inventory.remove(product);
    }

    /**
     * Adds a specified product to the inventory.
     *
     * @param product the product to be added to the inventory
     */
    public void addProduct(SalableProduct product) 
    {
        inventory.add(product);
    }

    /**
     * Returns the current inventory of salable products.
     *
     * @return the inventory of salable products
     */
    public List<SalableProduct> getInventory() 
    {
        return inventory;
    }
    
  //Returns a product by its name, or null if the product is not found
  	public SalableProduct getProductByName(String name) 
  	{
  		for (SalableProduct product : inventory) 
  		{
  			if (product.getName().equalsIgnoreCase(name)) 
  			{
  				return product;
  			}
  		}	
  		return null;
  	}
}

/**
 * This class can be used to manage the inventory of a store or any other business that sells products. 
 * It provides methods to add or remove products from the inventory and also to get the current inventory. 
 * The initInventory() method can be used to initialize the inventory from a JSON file.
 */ 
