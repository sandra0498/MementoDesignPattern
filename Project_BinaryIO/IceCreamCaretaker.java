package Project_BinaryIO;

/**
 * Purpose: This class is responsible for dealing with the serializable interface.
 * Inputs: the file name
 * Outputs: N/A
 */
import java.io.*;

/**
 * The IceCreamCaretaker keeps track of multiple Memento objects.
 */
public class IceCreamCaretaker implements Serializable {
	private ObjectOutputStream out;
	private ObjectInputStream read;
	private String fileName;

	/**
	 * Constructs a caretaker and creates filename
	 * @param str the name of the file
	 * @throws IOException input/output errors for the file name
	 */
	public IceCreamCaretaker(String str) throws IOException {
		fileName = str;
		out = new ObjectOutputStream(new FileOutputStream(fileName));

	}

	/**
	 * This method retrieves the memento for the ice cream
	 * @param flavor the flavor of the ice cream
	 * @return iceCream the current ice cream
	 * @throws ClassNotFoundException message thrown if class is not found
	 * @throws IOException input/output error for the file name
	 */

	public IceCreamMemento getMemento(String flavor) throws  ClassNotFoundException, IOException{
		IceCreamMemento iceCream = null;
		out.close();

		read = new ObjectInputStream(new FileInputStream(fileName));
		do {
			iceCream = (IceCreamMemento) read.readObject();

		} // keeps reading the objects until the flavor matches the string
		while(!iceCream.getFlavor().equalsIgnoreCase(flavor));
		read.close();
		//System.out.println("read successfully");

		return iceCream;

	}


	/**
	 * This method will add to the memento with the new ice cream
	 * @param save saves the new ice cream to the file
	 * @throws IOException input/output error for the file name
	 */

	public void addMemento(IceCreamMemento save) throws IOException {
		out.writeObject(save);
	}
}
