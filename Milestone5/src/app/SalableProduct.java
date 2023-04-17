package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a salable product.
 * implements the Comparable interface with a type argument of SalableProduct
 */
public class SalableProduct implements Comparable<SalableProduct>
{
    private String name;
    private String description;
    private double price;
    private int quantity;

    public SalableProduct() {}
    
    /**
     * Constructs a new SalableProduct object.
     * @param name the name of the product
     * @param description the description of the product
     * @param price the price of the product
     * @param quantity the quantity of the product
     */
    public SalableProduct(String name, String description, double price, int quantity) 
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the product.
     * @return the name of the product
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Returns the description of the product.
     * @return the description of the product
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * Returns the price of the product.
     * @return the price of the product
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Returns the quantity of the product.
     * @return the quantity of the product
     */
    public int getQuantity() 
    {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the product.
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f - %d in stock - %s", name, price, quantity, description);
    }

    /**
     * Compares this product with another product based on their names.
     * @param otherProduct the other product to compare with
     * @return a negative integer, zero, or a positive integer as this product is less than, equal to, or greater than the specified product
     */
    public int compareTo(SalableProduct otherProduct) 
    {
        return this.name.compareToIgnoreCase(otherProduct.getName());
    }

    /**
     * Checks if this product is equal to another object.
     * @param o the other object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SalableProduct)) return false;
        SalableProduct that = (SalableProduct) o;
        return Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

//    /**
//     * Computes the hash code of this product.
//     * @return the hash code of this product
//     */
//    @Override
//    public int hashCode() 
//    {
//        return Objects.hash(name, description, price, quantity);
//    }

    /**
     * Sorts the given list of salable products in ascending order based on their price.
     * @param products the list of products to sort
     */
    public static void sortByPriceDescending(List<SalableProduct> products) 
    {
        Comparator<SalableProduct> priceComparator = Comparator.comparing(SalableProduct::getPrice);
        Collections.sort(products, priceComparator.reversed());
    }
    
    public static void sortByNameAscending(List<SalableProduct> products) 
    {
        Comparator<SalableProduct> nameComparator = Comparator.comparing(SalableProduct::getName);
        Collections.sort(products, nameComparator);
    }

    public static void sortByNameDescending(List<SalableProduct> products)
    {
        Comparator<SalableProduct> nameComparator = Comparator.comparing(SalableProduct::getName);
        Collections.sort(products, nameComparator.reversed());
    }
}


