package hw5;
//I pledge my honor that I have abided by the Stevens Honor System -jwang151
import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {

	@Test
	public void add() {
		Treap<Integer> testTree = new Treap<Integer>();
		Treap<Integer> secondTest = new Treap<Integer>();
		testTree.add(4,19); 
		testTree.add(2,31);
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		secondTest.add(4,19); 
		secondTest.add(2,31);
		secondTest.add(6,70); 
		secondTest.add(1,84);
		secondTest.add(3,12); 
		secondTest.add(5,83);
		secondTest.add(7,26);
		assertEquals(testTree.toString(), secondTest.toString());
	}
	
	@Test

	public void delete(){
		Treap<Integer> testTree = new Treap<Integer>();
		Treap<Integer> secondTest = new Treap<Integer>();
		testTree.add(4,19); 
		testTree.add(2,31);
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		secondTest.add(4,19); 
		secondTest.add(2,31);
		secondTest.add(6,70); 
		secondTest.add(1,84);
		secondTest.add(3,12); 
		secondTest.add(5,83);
		secondTest.add(7,26);
		testTree.delete(1);
		secondTest.delete(1);
		assertEquals(testTree.toString(), secondTest.toString());
	}

	@Test
	public void find(){
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19); 
		testTree.add(2,31);
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		assertEquals(testTree.find(7), true);
	}


}


