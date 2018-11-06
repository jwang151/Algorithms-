package hw3;
/**
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System - JWang
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class IDLListTest {

	@Test
	public void test() {
		fail("This has not been implemented yet");IDLList<String> test = new IDLList<String>(); 
		//This is to test the add elements such as add() and append()
		assertEquals(true, test.add(0, "Hello"));
		assertEquals(true, test.add(1, "this is "));
		assertEquals(true, test.append("Jing"));
		assertEquals("[Hi, this is, Jing]", test.toString());
		
		//This is to test the retrieving elements such as get(), getHead(), and getLast()
		assertEquals("This is", test.get(1));
		assertEquals("Hi", test.getHead());
		assertEquals("Jing", test.getLast());
		
		//This is to test out the finding size() element
		assertEquals(3, test.size());
		assertEquals(true, test.append("."));
		assertEquals(4,  test.size());
		assertEquals("[Hi, this is, Jing, .]", test.toString());
		
		//This is to test out remove elements like remove() and etc.
		assertEquals("Hi", test.remove());
		assertEquals(".", test.removeLast());
		assertEquals("Hi", test.removeAt(0));
		assertEquals(false, test.remove("Joseph"));
		assertEquals(true, test.remove("Jing"));
		assertEquals("[my]", test.toString());
		
		//Additional test cases 
		IDLList<String> test2 = new IDLList<String>();
		assertEquals(false, test2.add(3, "Pretty"));
		assertEquals(false, test2.add(5, "NewWord"));
		assertEquals(false, test2.add(0,NoSuchElementException()));
		assertEquals(false, test2.add(NoSuchElementException()));
		assertEquals(false, test2.append(NoSuchElementException()));
		assertEquals(true, test2.append("wow"));
		assertEquals("[wow]", test2.toString());
		
		IDLList<String> test3 = new IDLList<String>();
		assertEquals(NoSuchElementException(), test3.getHead());
		assertEquals(NoSuchElementException(), test3.getLast());
		assertEquals(0, test3.size());
		assertEquals(true, test3.add("wow"));
		assertEquals("wow", test3.getHead());
		assertEquals("wow", test3.getLast());
		assertEquals(1, test3.size());
		assertEquals("[wow]", test3.toString());
		
		IDLList<String> test4 = new IDLList<String>();
		assertEquals(NoSuchElementException(), test4.remove());
		assertEquals(true, test4.add("cool"));
		assertEquals("cool", test4.remove());
		assertEquals(null, test4.getHead());
		assertEquals(null, test4.getLast());
		assertEquals("[]", test4.toString());
		
		IDLList<String> test5 = new IDLList<String>();
		assertEquals(NoSuchElementException(), test5.removeLast());
		assertEquals(true, test5.add("LION"));
		assertEquals("LION", test5.removeLast());
		assertEquals(null, test5.getHead());
		assertEquals(null, test5.getLast());
		assertEquals("[]", test5.toString());
		
		IDLList<String> test6 = new IDLList<String>();
		assertEquals(false, test6.remove("funSentences"));
		assertEquals(false, test6.remove(NoSuchElementException()));
		assertEquals("[]", test6.toString());
	}
	
	private String NoSuchElementException() {
		return null;
	}

}
