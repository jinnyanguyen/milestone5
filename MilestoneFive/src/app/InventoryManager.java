package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The InventoryManager class represents a Java class for managing inventory of
 * salable products using the Jackson library for JSON processing.
 */
public class InventoryManager<T extends SalableProduct> {
    private List<T> inventory;

    /**
     * Constructs a new InventoryManager object with an empty inventory.
     */
    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    /**
     * Initializes the inventory by reading from a JSON file and populating the inventory with SalableProduct objects obtained from the file.
     */
    public void initInventory() {
        System.out.println("Initializing inventory...");

        try {
            String path = "src/app/inventoryone.json"; // path to the JSON file
            ObjectMapper mapper = new ObjectMapper(); // creating a new ObjectMapper object
            @SuppressWarnings("unchecked")
			T[] products = mapper.readValue(new File(path), (Class<T[]>) new SalableProduct[0].getClass()); // reading the JSON file and converting it to an array of SalableProduct objects using Jackson library
            inventory = new ArrayList<>(Arrays.asList(products)); // convert array to ArrayList using the constructor
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
    public void removeProduct(T product) {
        inventory.remove(product);
    }

    /**
     * Adds a specified product to the inventory.
     *
     * @param product the product to be added to the inventory
     */
    public void addProduct(T product) {
        inventory.add(product);
    }

    /**
     * Returns the current inventory of salable products.
     *
     * @return the inventory of salable products
     */
    public List<T> getInventory() {
        return inventory;
    }

    /**
     * Returns a product by its name, or null if the product is not found.
     *
     * @param name the name of the product to search for
     * @return the product with the specified name, or null if the product is not found
     */
    public T getProductByName(String name) {
        for (T product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Sorts the inventory by product name in ascending order.
     */
    public void sortByProductNameAscending() {
        Collections.sort(inventory);
    }

    /**
     * Sorts the inventory by product name in descending order.
     */
    public void sortByProductNameDescending() {
        Collections.sort(inventory, Collections.reverseOrder());
    }

    /**
     * Sorts the inventory by product price in ascending order.
     */
    public void sortByProductPriceAscending() {
        Comparator<T> byPrice = Comparator.comparing(SalableProduct::getPrice);
        Collections.sort(inventory, byPrice);
    }

    /**
     * Sorts the inventory by product price in descending order.
     */
    public void sortByProductPriceDescending() {
        Comparator<T> byPrice = Comparator.comparing(SalableProduct::getPrice);
        Collections.sort(inventory, byPrice.reversed());
    }
}
