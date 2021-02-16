package intlist.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import intlist.IntList;

class IntListTest {

	@Test
	void test() {
		IntList intList = new IntList();
		intList.addElement(42);
		
		int[] elements = intList.getElements();
		
		assertEquals(42, elements[0]);
		
		intList.setElement(0, 43);

		assertEquals(42, elements[0]);
		
		int[] newElements = intList.getElements();
		
		assertEquals(43, newElements[0]);
	}

}
