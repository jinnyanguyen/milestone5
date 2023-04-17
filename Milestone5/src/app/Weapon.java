package app;

//A child(sub-class) of SalableProduct that represents a weapon
public class Weapon extends SalableProduct 
{
	private int damage; // The amount of damage the weapon deals

	/**
     * Constructs a new Weapon object.
     * @param name the name of the weapon
     * @param description the description of the weapon
     * @param price the price of the weapon
     * @param quantity the quantity of the weapon
     * @param damage the damage value of the weapon
     */
	public Weapon(String name, String description, double price, int quantity, int damage) 
	{
		super(name, description, price, quantity);
		this.damage = damage;
	}

	 /**
     * Returns the damage value of the weapon.
     * @return the damage value of the weapon
     */
	public int getDamage() 
	{
		return damage;
	}

	 /**
     * Set the damage value of the weapon.
     * @param damage the new damage value
     */
	public void setDamage(int damage) 
	{
        this.damage = damage;
    }

	//Returns the type of the product as a string
	public String getType() 
	{
		return "Weapon";
	}

	/**
	 * Compares this weapon with another weapon based on their names.
	 * @param otherWeapon the other weapon to compare with
	 * @return a negative integer, zero, or a positive integer as this weapon is less than, equal to, or greater than the specified weapon
	 */
	@Override
	public int compareTo(SalableProduct otherProduct) 
	{
	  if (otherProduct instanceof Weapon) 
	  {
	    Weapon otherWeapon = (Weapon) otherProduct;
	    return this.getName().compareToIgnoreCase(otherWeapon.getName());
	  } else {
	    return super.compareTo(otherProduct);
	  }
	}

	
	
	/**
     * Returns a string representation of the weapon.
     * @return a string representation of the weapon
     */
	 @Override
	    public String toString() 
	 {
	        return String.format("%s - %s - $%.2f - %d", getName(), getDescription(), getPrice(), getQuantity(), damage);
	 }
	 
	 /**
	  * Returns the description of the weapon.
	  * @return the description of the weapon
	  */
	   public String getDescription() 
	   {
		   return super.getDescription() + " - Attack Power: " + damage;
	   }
}
