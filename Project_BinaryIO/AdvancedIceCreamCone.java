package Project_BinaryIO;

/**
 * Purpose: This class is responsible for dealing with the different states
 *  		of the memento object.
 *Inputs: The number of scoops, flavor, type of cone and toppings.
 *Outputs: N/A
 */
/* This class is used to model the properties and behaviors of an ice cream cone.
   There are currently restriction on the construction of the cone: only one
   flavor of ice cream is allowed and up to five toppings. You can only add scoops, you
   cannot remove them. */

import java.util.*;
import java.io.Serializable;
//originator?
public class AdvancedIceCreamCone {
	private int numberOfScoops;
	private String flavor;
	private String typeOfCone;
	private ArrayList<String> toppings = new ArrayList<String>();



	//the default constructor creates a one scoop,
	// vanilla ice cream cone using the regular type of cone and no toppings
	public AdvancedIceCreamCone() {
		numberOfScoops=1;
		flavor="vanilla";
		typeOfCone="regular";
	}
	/**
	 * This constructor lets you create an ice cream code to your liking. It takes in three parameters:
	 the number of scoops, the flavor of the ice cream and the type of cone
	 * @param ns number of scoops of ice cream
	 * @param flv ice cream flavor
	 * @param cone type of cone ice cream is in
	 */
	public AdvancedIceCreamCone(int ns,String flv,String cone) {
		numberOfScoops=ns;
		flavor=flv;
		typeOfCone=cone;
	}

	/**
	 * This method returns the number of scoops in the cone
	 * @return numberOfScoops in the cone
	 */
	public int getNumberOfScoops () {
		return numberOfScoops;
	}

	/**
	 * This method returns the ice cream flavor
	 * @return flavor the flavor of the ice cream
	 */
	public String getFlavor() {
		return flavor;
	}
	/**
	 * This method returns the type of cone the cone is
	 * @return typeOfCone the cone type
	 */
	public String getTypeOfCone() {
		return typeOfCone;
	}
	//this method allows you to add one scoop of ice cream at a time
	public void addScoop() {
		numberOfScoops=numberOfScoops+1;
	}
	/**
	 * This method allows you to change the ice cream flavor
	 * @param flv the flavor of the ice cream
	 */
	public void setFlavor(String flv) {
		flavor=flv;
	}
	/**
	 * This method allows you to change the type of cone
	 * @param cone the type of cone it is
	 */
	public void setTypeOfCone(String cone) {
		typeOfCone=cone;
	}
	/**
	 * This method allows you to add toppings from an ArrayList
	 * @param top the topping in the array list
	 */
	public void addToppings(List<String> top) {
		toppings.addAll(top);
	}
	/**
	 * This method allows you to add one topping
	 * @param top a topping
	 */
	public void addToppings(String top) {
		toppings.add(top);
	}
	/**
	 * This method return a String with a list of the toppings
	 * @return list of the toppings
	 */
	public ArrayList<String> getToppings () {
		return toppings;
	}
	/**
	 * This method returns the number of toppings
	 * @return number of toppings
	 */
	public int getNumberOfToppings()
	{
		int count = 0;
		for (String topping : this.getToppings())
		{
			count++;
		}
		return count;
	}

	/**
	 * Sets the cone to the state passed by the memento
	 * @param memento the memento used to restore the cone
	 */

	public void restore(IceCreamMemento memento)
	{
		flavor = memento.getFlavor();
		numberOfScoops =  memento.getNumberOfScoops();
		typeOfCone = memento.getTypeOfCone();
		toppings.clear();
		for(String topping: memento.getToppings())
		{
			toppings.add(topping);
		}
		System.out.println("Selection restored to: " + this);
	}

	/**
	 * Saves the current cone as a Memento object.
	 * @return memento of the current state
	 */

	public IceCreamMemento save()
	{
		return new IceCreamMemento(this);
	}

	/**
	 * Algorithm to calculate the cost of the cone
	 * @return the cones total price
	 */

	public double calcPrice()
	{
		double flavPrice;
		switch (this.getFlavor()) {
			case "chocolate":
			case "vanilla":
				flavPrice = 1.25;
				break;
			case "strawberry":
				flavPrice = 1.50;
				break;
			default:
				flavPrice = 1.75;
				break;
		}
		return this.getNumberOfScoops() * flavPrice + this.getNumberOfToppings();
	}

	/**
	 * this method overrides the inherited toString()
	 * @return cone as a string
	 */

	public String toString() {
		return ("The number of scoops is " + numberOfScoops + ". The flavor is "
				+ flavor + ". And the type of cone is " + typeOfCone +
				" and the toppings are: " + getToppings());
	}
}
