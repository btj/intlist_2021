package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of integers.
 * 
 * @invar | getElements() != null
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @creates | result
	 * @basic
	 */
	public int[] getElements() {
		return elements.clone();
	}
	
	/**
	 * @post | result == getElements().length
	 */
	public int getLength() {
		return elements.length;
	}
	
	/**
	 * @pre | 0 <= index && index < getLength()
	 * @post | result == getElements()[index]
	 */
	public int getElementAt(int index) {
		return elements[index];
	} 

	/**
	 * @post | getLength() == 0
	 */
	public IntList() {
		elements = new int[0];
	}
	
	/**
	 * @mutates | this
	 * 
	 * @post | getLength() == old(getLength()) + 1
	 * @post | getElementAt(old(getLength())) == value
	 * @post | IntStream.range(0, old(getLength())).allMatch(i ->
	 *       |     getElementAt(i) == old(getElements())[i])
	 * @post | Arrays.equals(getElements(), 0, getLength() - 1,
	 *       |               old(getElements()), 0, old(getLength()))
	 */
	public void addElement(int value) {
		int[] newElements = new int[elements.length + 1];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		newElements[elements.length] = value;
		elements = newElements;
	}

	/**
	 * @mutates | this
	 * 
	 * @pre | 1 <= getLength()
	 * 
	 * @post | getLength() == old(getLength()) - 1
	 * @post | Arrays.equals(getElements(), 0, getLength(), old(getElements()), 0, getLength())
	 */
	public void removeLastElement() {
		int[] newElements = new int[elements.length - 1];
		System.arraycopy(elements, 0, newElements, 0, newElements.length);
		elements = newElements;
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index < getLength()
	 * @post | getLength() == old(getLength())
	 * @post | IntStream.range(0, getLength()).allMatch(i ->
	 *       |     i == index ?
	 *       |         getElementAt(i) == value
	 *       |     :
	 *       |         getElementAt(i) == old(getElements())[i])
	 * 
	 * // voorwaarde ? waar-waarde : onwaar-waarde 
	 */
	public void setElement(int index, int value) {
		elements[index] = value;
	}
	
}
