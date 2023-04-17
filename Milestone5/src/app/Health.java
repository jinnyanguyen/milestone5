package app;

/**
 * A sub-class of SalableProduct that represents health items.
 */
public class Health extends SalableProduct implements Comparable<SalableProduct> {
    private int healing;

    /**
     * Constructs a new Health object with the given name, description, price, quantity, and healing power.
     *
     * @param name          the name of the health item
     * @param description   a brief description of the health item
     * @param price         the price of the health item
     * @param quantity      the initial quantity of the health item in inventory
     * @param healingPower  the amount of healing power the health item provides
     */
    public Health(String name, String description, double price, int quantity, int healingPower) {
        super(name, description, price, quantity);
        this.healing = healingPower;
    }

    /**
     * Returns the amount of healing power the health item provides.
     *
     * @return the amount of healing power
     */
    public int getHealingPower() {
        return healing;
    }

    /**
     * Returns type of health.
     *
     * @return the type of health
     */
    public String getType() {
        return "Health";
    }

    /**
     * Returns a string representation of the health item, including its name, description, price, quantity, and healing power.
     *
     * @return a formatted string containing the health item's details
     */
    @Override
    public String toString() {
        return String.format("%s - %s - $%.2f - %d - %d healing", getName(), getDescription(), getPrice(), getQuantity(), healing);
    }

    /**
     * Returns the description of the health item.
     *
     * @return the description of the health item
     */
    public String getDescription() {
        return super.getDescription() + " - Healing Power: " + healing;
    }

    /**
     * Compares this health item with another salable product based on their prices.
     *
     * @param otherProduct the other salable product to compare with
     * @return a negative integer, zero, or a positive integer as this health item is less than, equal to, or greater than the specified salable product
     */
    @Override
    public int compareTo(SalableProduct otherProduct) {
        if (otherProduct instanceof Health) {
            Health otherHealth = (Health) otherProduct;
            return Double.compare(this.getPrice(), otherHealth.getPrice());
        } else {
            return super.compareTo(otherProduct);
        }
    }
}
