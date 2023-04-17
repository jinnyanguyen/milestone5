/*
 * The app package contains the StoreFrontApp class that runs the store front application.
 * Initialization of Store inventory from an external JSON file using the File Service.
 * Proper exception handling for all File I/O and JSON serialization.
 */

package app;

import java.util.Scanner;

/**
 * The main class that runs the store front application.
 * 
 * This is my own work - Anh Nguyen Milestone 3 CST239
 */
public class StoreFrontApp 
{
    private InventoryManager inventoryManager; // The inventory manager
    private ShoppingCart shoppingCart; // The shopping cart
    private Scanner scanner; // The scanner object for user input

    /**
     * Constructor for the StoreFrontApp class.
     * Initializes the inventory manager, the shopping cart and the scanner object.
     */
    public StoreFrontApp() 
    {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    /**
     * Initializes the application and starts the main loop.
     * Calls the initInventory() method of the inventory manager.
     * Displays a welcome message to the user.
     * Displays a menu of actions for the user to choose.
     * Executes the selected action based on user input.
     */
    public void run() 
    {
        inventoryManager.initInventory();
        displayWelcomeMessage();

        boolean exit = false;
        while (!exit) 
        {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) 
            {
            case "1":
                displayInventory();
              break;
            case "2":
                processPurchase();
              break;
            case "3":
                processCancellation();
              break;
            case "4":
                shoppingCart.displayContents();
                break;
            case"5":
                shoppingCart.emptyCart();
                break;
            case "6":
              exit = true;
              break;
            default:
                displayError("Invalid input. Please try again.");
                }
            }
        }
    
    /**
     * Displays a welcome message to the user.
     */
    public void displayWelcomeMessage() 
    {
        System.out.println("Welcome to the Store Front!");
    }

    /**
     * Displays a menu of actions for the user to choose.
     */
    public void displayMenu() 
    {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. View inventory");
        System.out.println("2. Purchase a product");
        System.out.println("3. Cancel a purchase");
        System.out.println("4. Shopping Cart");
        System.out.println("5. Empty Cart");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Executes the selected action based on user input.
     * 
     * @param action the action to be executed
     */
    public void executeAction(String action) 
    {
        // TODO: implement
    }

    /**
     * Displays the inventory to the user.
     */
    public void displayInventory()
    {
        System.out.println("\nInventory:");
        for (SalableProduct product : inventoryManager.getInventory()) 
        {
            System.out.println(product.getName() + ":" + product.getDescription()+ " - " + product.getPrice()+ " quantity:"+ product.getQuantity());
        }
    }

    /**
     * Handles the purchase of a product by the user.
     */
    public void processPurchase() 
    {
        System.out.println("\nInventory:");
        for (SalableProduct product : inventoryManager.getInventory()) 
        {
          System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("\nWhich product would you like to purchase?");
        String productName = scanner.nextLine();
        SalableProduct product = inventoryManager.getProductByName(productName);
        if    (product != null) 
        {
            if (product.getQuantity() > 0) 
            {
                double price = product.getPrice();
                System.out.println("\nThe price for " + productName + " is " + price + ".");
                System.out.println("Do you want to proceed with the purchase? (y/n)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) 
                {
                    product.setQuantity(product.getQuantity() - 1);
                    shoppingCart.addProduct(product);
                    displayFeedback("Purchase successful. Thank you for shopping with us!");
                } 
                    else 
                    {
                        displayFeedback("Purchase canceled.");
                    }
                } else {
                    displayError("Sorry, " + productName + " is out of stock.");
                }
                } else {
                    displayError("Invalid product name. Please try again.");
                }
    }

    /**
     * Handles the cancellation of a purchase by the user.
     */
    public void processCancellation() 
    {
        System.out.println("\nWhich product would you like to cancel the purchase for?");
        String productName = scanner.nextLine();
        SalableProduct product = inventoryManager.getProductByName(productName);
        if (product != null) 
        {
            int quantityInCart = getQuantityInCart(product);
            if (quantityInCart > 0) 
            {
                double price = product.getPrice();
                System.out.println("\nYou have " + quantityInCart + " of " + productName + " in your cart.");
                System.out.println("The total price for " + quantityInCart + " " + productName + " is " + (price * quantityInCart) + ".");
                System.out.println("Do you want to proceed with the cancellation? (y/n)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y"))
                {
                    product.setQuantity(product.getQuantity() + quantityInCart);
                    shoppingCart.removeProduct(product);
                    double price1 = product.getPrice() * quantityInCart;
                    System.out.println("You have " + quantityInCart + " " + productName + " in your shopping cart, " +
                      "which will be returned for a total refund of $" + price1 + ".");
                } else {
                    displayFeedback("Cancellation canceled.");
                }
                } else {
                displayError("You do not have any " + productName + " in your cart.");
                }
                } else {
                    displayError("Invalid product name. Please try again.");
                }
    }

    /**
     * Returns the quantity of a product in the shopping cart.
     * 
     * @param product the product to be checked
     * @return the quantity of the product in the shopping cart
     */
    public int getQuantityInCart(SalableProduct product) 
    {
        int quantity = 0;
        for (SalableProduct item : shoppingCart.getContents()) 
        {
            if (item.equals(product)) 
            {
                quantity++;
            }
        }
        return quantity;
    }

    /**
     * Displays feedback to the user.
     * 
     * @param message the feedback message to be displayed
     */
    public void displayFeedback(String message) 
    {
        System.out.println("\n" + message);
    }

    /**
     * Displays an error message to the user.
     * 
     * @param message the error message to be displayed
     */
    public void displayError(String message) 
    {
        System.err.println("\nError: " + message);
    }

    /**
     * The main method that creates a new StoreFrontApp object and calls its run() method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        StoreFrontApp app = new StoreFrontApp();
        app.run();
    }
}

       