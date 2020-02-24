package Project_BinaryIO;

/**
 * Purpose: This class prompts the user to make an ice cream object
 * 		and manipulate the object.
 * Inputs: What the Scanner receives from the user.
 * Outputs: N/A
 *
 */

import java.util.*;
import java.io.*;

public class IceCreamTester {
	/* This class is used to test the functionality of the IceCreamCone class */
	public static void main(String [] args) throws IOException, ClassNotFoundException {
		IceCreamCaretaker caretaker = new IceCreamCaretaker("abc");
		Scanner in = new Scanner(System.in);
		System.out.println("Mimi's Mini Ice Cream Shop ");
		System.out.println("***************************");
		String flavor = "";
		String type = "";
		int numofScoops = 0;
		AdvancedIceCreamCone ICC = null;

		//choice A decides if the default constructor will be used
		// choice B decides if the overloaded constructor will be used
		System.out.println("Do you want to choose the regular vanilla cone(A) or customize your cone(B)?");
		char choice = Character.toUpperCase(in.next().charAt(0));
		if (choice == 'A') {
			//calls the default constructor
			ICC = new AdvancedIceCreamCone();
		}
		else {
			System.out.println(" ~~~~  Flavors  ~~~~  ");
			System.out.println(" 1. Vanilla   ");
			System.out.println(" 2. Chocolate ");
			System.out.println(" 3. Strawberry ");
			System.out.println(" 4. Mimi's Minty ");
			in.nextLine();
			System.out.println("Input the flavor please:");
			flavor = in.nextLine();

			if (flavor != null) {
				System.out.println("How many scoops do you want?");
				numofScoops = in.nextInt();
				System.out.println(" ~~~~~ Cone Types ~~~~~");
				System.out.println(" Regular ");
				System.out.println(" Waffle  ");
				System.out.println(" Sugar ");
				System.out.println("Input the cone type: ");
				in.nextLine();
				type = in.nextLine();
			}
			ICC = new AdvancedIceCreamCone(numofScoops, flavor, type);



		}

		System.out.println("Do you want to add one more scoop(Y/N)?");
		char s = Character.toUpperCase(in.next().charAt(0));
		if (s == 'Y') {
			//adds a scoop if the user inputs yes
			ICC.addScoop();
		}



		System.out.println("Do you want to add toppings(Y/N)?");
		char yesorNo = Character.toUpperCase(in.next().charAt(0));
		if(yesorNo == 'Y') {
			ArrayList toppings = new ArrayList(0);

			// calls the two overloaded methods of addToppings
			System.out.println("Do you want to toppings one at a time(1) or a list(2)?");
			int decision = in.nextInt();
			if(decision == 1) {
				//asks how many toppings so we know when to stop for the loop
				System.out.println("How many toppings are you entering?");
				int num = in.nextInt();
				in.nextLine(); // clears the scanner
				for(int i = 0; i < num; i++) {
					System.out.println("Enter a topping:"); //keeps asking for topping
					String t = in.nextLine();
					ICC.addToppings(t); // simultaneously enters string in method
				}

			}
			else if (decision == 2) {
				in.nextLine();
				String q;
				do {
					//do while is in charge of adding elements to list
					System.out.println("Keep adding toppings and press enter to stop");
					q = in.nextLine();
					if(!q.equals("")) {
						toppings.add(q);
					}
				}
				while (!q.equals(""));


			}
			// adds the list to the method itself
			ICC.addToppings(toppings);

			// displays the current state of the ice cream
			System.out.println("The cone is now " + ICC);

		}
		//in charge of writing the memento to the file
		ifSave(in,ICC, caretaker);

		System.out.println("Do you want to change flavor (Y/N)?");
		char changeFlavor = Character.toUpperCase(in.next().charAt(0));

		if (changeFlavor == 'Y'){
			System.out.println("To which flavor: (1)Vanilla | (2) Chocolate | (3) Strawberry |" +
					"(4) Mint");
			int n = in.nextInt();
			if (n == 1) {
				flavor = "vanilla";
			}
			else if (n == 2) {
				flavor = "chocolate";
			}
			else if( n == 3 ) {
				flavor = "strawberry";
			}
			else {
				flavor = "mint";
			}

			ICC.setFlavor(flavor);

			// displays the current state of the ice cream
			System.out.println("The flavor of this cone is now " + ICC.getFlavor());

			//in charge of writing the memento to the file
			ifSave(in,ICC, caretaker);

		}

		System.out.println("Do you want to change the type of cone?(Y/N)");
		char changeCone = Character.toUpperCase(in.next().charAt(0));
		if(changeCone == 'Y'){
			in.nextLine();
			//asks user to what type of cone they want to change to
			System.out.println("To what type, do you want to change it to?");
			System.out.println("|waffle, sugar or regular|");
			String newCone = in.nextLine();

			ICC.setTypeOfCone(newCone);

			//displays current state
			System.out.println("The type of cone is now " + ICC.getTypeOfCone());

			ifSave(in,ICC, caretaker);

		}
		//passes in the originator and the caretaker to restore
		ifRestore(in,ICC,caretaker);
		System.out.println("The total price is $" + ICC.calcPrice());



	}


	/**
	 * Responsible for writing the ice cream into the file
	 * @param in the scanner
	 * @param ICC the advancedicecreamcone (the originator)
	 * @param c the caretaker
	 * @throws IOException input/output error for the file name
	 */
	public static void ifSave(Scanner in, AdvancedIceCreamCone ICC, IceCreamCaretaker c) throws IOException {

		System.out.println("Do you want to save (Y/N)?");
		char saving = Character.toUpperCase(in.next().charAt(0));
		if (saving == 'Y') {
			c.addMemento(ICC.save());
		}
	}

	/**
	 * Responsible for restoring the object with the same flavor.
	 * @param in the scanner
	 * @param ICC the advancedicecreamcone (the originator)
	 * @param c the caretaker
	 * @throws IOException input/output error for the file name
	 * @throws ClassNotFoundException message thrown if class is not found
	 */
	public static void ifRestore(Scanner in, AdvancedIceCreamCone ICC, IceCreamCaretaker c)
			throws IOException, ClassNotFoundException {
		System.out.println("Do you want to restore a previous ice cream(Y/N)?");
		char restoring = Character.toUpperCase(in.next().charAt(0));
		if (restoring == 'Y') {
			in.nextLine();
			System.out.println("Based on what flavor?");
			String f = in.nextLine();
			ICC.restore(c.getMemento(f));
			//System.out.println("The user choice restored to: " + ICC);


		}


	}




}
