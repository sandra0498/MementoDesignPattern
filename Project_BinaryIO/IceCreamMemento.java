package Project_BinaryIO;

/**
 * Purpose: This class represents the ice cream object.
 * Inputs:  The number of scoops, flavor and type of cone.
 * Outputs: N/A
 *
 *
 */
import java.io.Serializable;
import java.util.ArrayList;


public class IceCreamMemento implements Serializable {
	private int numberOfScoops;
	private String flavor;
	private String typeOfCone;
	private ArrayList<String> toppings = new ArrayList<String>();


	/**
	 * Default constructor for the IceCreamMemento
	 */
	public IceCreamMemento() {
		numberOfScoops=1;
		flavor="vanilla";
		typeOfCone="regular";
		toppings = new ArrayList<>(0);
	}

	/**
	 * Overloaded constructor for the IceCreamMemento
	 * @param ns the number of scoops
	 * @param flv the flavor of the ice cream
	 * @param cone the type of cone
	 * @param t ArrayList of toppings
	 */
	public IceCreamMemento(int ns, String flv, String cone, ArrayList<String> t) {
		numberOfScoops = ns;
		flavor = flv;
		typeOfCone = cone;
		toppings = t;
	}

	/**
	 * Retrieves the ice cream that is being stored
	 * @param advancedIceCreamCone the ice cream cone
	 */

	public IceCreamMemento(AdvancedIceCreamCone advancedIceCreamCone) {
		numberOfScoops = advancedIceCreamCone.getNumberOfScoops();
		flavor = advancedIceCreamCone.getFlavor();
		typeOfCone = advancedIceCreamCone.getTypeOfCone();
		toppings = advancedIceCreamCone.getToppings();

	}

	/**
	 * This method returns the number of scoops in the cone
	 * @return number of scoops
	 */
	public int getNumberOfScoops() {
		return numberOfScoops;
	}

	/**
	 * This method returns the ice cream flavor
	 * @return ice cream flavor
	 */	public String getFlavor() {
		return flavor;
	}

	/**
	 * This method returns the type of cone
	 * @return This method returns the type of cone
	 */	public String getTypeOfCone() {
		return typeOfCone;
	}

	/**
	 * This method returns a String with a list of the toppings
	 * @return the toppings as a String
	 */	public ArrayList<String> getToppings() {
		return toppings;
	}


	/**
	 * this method overrides the inherited toString()
	 * @return cone as a string
	 */
	public String toString() {
		return ("The number of scoops is " + numberOfScoops + ". The flavor is " +
				flavor + ". And the type of cone is " + typeOfCone + " and the toppings are: " + getToppings());

	}
}

