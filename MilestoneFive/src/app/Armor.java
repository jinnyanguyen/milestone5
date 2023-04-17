package app;

/**
 * A class representing an armor.
 * A child(sub-class) of SalableProduct that represents armor
 */
public class Armor extends SalableProduct implements Comparable<SalableProduct> {
    private int defense; 

    /**
     * Constructs a new Armor object.
     * @param name the name of the armor
     * @param description the description of the armor
     * @param price the price of the armor
     * @param quantity the quantity of the armor
     * @param defense the defense value of the armor
     */
    public Armor(String name, String description, double price, int quantity, int defense) {
        super(name, description, price, quantity);
        this.defense = defense;
    }

    /**
     * Returns the defense value of the armor.
     * @return the defense value of the armor
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense value of the armor.
     * @param defense the new defense value
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Returns the type of the armor.
     * @return the type of the armor
     */
    public String getType() {
        return "Armor";
    }

    /**
     * Compares this armor with another salable product based on their names.
     *
     * @param otherProduct the other salable product to compare with
     * @return a negative integer, zero, or a positive integer as this armor is less than, equal to, or greater than the specified salable product
     */
    @Override
    public int compareTo(SalableProduct otherProduct) {
        if (otherProduct instanceof Armor) {
            Armor otherArmor = (Armor) otherProduct;
            return this.getName().compareToIgnoreCase(otherArmor.getName());
        } else {
            return super.compareTo(otherProduct);
        }
    }

    /**
     * Returns a string representation of the armor.
     * @return a string representation of the armor
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f - %d in stock - Defense: %d", getName(), getPrice(), getQuantity(), defense);
    }

    /**
     * Returns the description of the armor.
     * @return the description of the armor
     */
    public String getDescription() {
        return super.getDescription() + " - Defense Power: " + defense;
    }
}
