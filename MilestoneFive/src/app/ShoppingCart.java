package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCart<T extends SalableProduct> {
    private ArrayList<T> cart; // The list of products in the shopping cart

    /**
     * Constructs a new ShoppingCart object with an empty list of products.
     */
    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product the product to add
     */
    public void addProduct(T product) {
        cart.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product the product to remove
     */
    public void removeProduct(T product) {
        cart.remove(product);
    }

    /**
     * Returns the contents of the shopping cart.
     *
     * @return an ArrayList of SalableProduct objects representing the contents of the cart
     */
    public ArrayList<T> getContents() {
        return cart;
    }

    /**
     * Displays the current contents of the shopping cart.
     */
    public void displayContents() {
        if (cart.size() == 0) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart Contents:");
            for (SalableProduct product : cart) {
                System.out.println(product.getName() + " - " + product.getPrice());
            }
        }
    }

    /**
     * Empties the contents of the shopping cart.
     *
     * @return an empty ArrayList of SalableProduct objects representing the contents of the cart
     */
    public ArrayList<T> emptyCart() {
        cart.clear();
        System.out.println("Cart is empty");
        return cart;
    }

    /**
     * Sorts the contents of the shopping cart by name in ascending order.
     */
    public void sortByNameAscending() {
        Collections.sort(cart);
    }

    /**
     * Sorts the contents of the shopping cart by name in descending order.
     */
    public void sortByNameDescending() {
        Collections.sort(cart, Collections.reverseOrder());
    }

    /**
     * Sorts the contents of the shopping cart by price in ascending order.
     */
    public void sortByPriceAscending() {
        Collections.sort(cart, new PriceComparator());
    }

    /**
     * Sorts the contents of the shopping cart by price in descending order.
     */
    public void sortByPriceDescending() {
        Collections.sort(cart, Collections.reverseOrder(new PriceComparator()));
    }

    /**
     * A comparator class that compares SalableProduct objects based on price.
     */
    public class PriceComparator implements Comparator<T> {

        /**
         * Compares two SalableProduct objects based on price.
         *
         * @param p1 the first SalableProduct object
         * @param p2 the second SalableProduct object
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         */
        public int compare(T p1, T p2) {
            return Double.compare(p1.getPrice(), p2.getPrice());
        }
    }
}
