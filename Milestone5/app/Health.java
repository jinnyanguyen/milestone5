package app;

/**
 * A sub-class of SalableProduct that represents health items.
 */
public class Health extends SalableProduct 
{
    private int healing;
    /**
     * Constructs a new Health object with the given name, description, price, quantity, and healing power.
     * @param name the name of the health item
     * @param description a brief description of the health item
     * @param price the price of the health item
     * @param quantity the initial quantity of the health item in inventory
     * @param healingPower the amount of healing power the health item provides
     */
    public Health(String name, String description, double price, int quantity, int healingPower) 
    {
        super(name, description, price, quantity);
        this.healing = healingPower;
    }

    /**
     * Returns the amount of healing power the health item provides.
     * @return the amount of healing power
     */
    public int getHealingPower()
    {
        return healing;
    }
    
    /**
     * Returns type of health.
     * @return the type of health
     */
    public String getType() 
    {
        return "Health";
    }

    /**
     * Returns a string representation of the health item, including its name, description, price, quantity, and healing power.
     * @return a formatted string containing the health item's details
     */
    @Override
    public String toString() 
    {
        return String.format("%s - %s - $%.2f - %d - %d healing", getName(), getDescription(), getPrice(), getQuantity(), healing);
    }
    /**
     * Returns the description of the armor.
     * @return the description of the armor
     */
    public String getDescription() 
    {
        return super.getDescription() + " - Defense Power: " + healing;
    }
}

