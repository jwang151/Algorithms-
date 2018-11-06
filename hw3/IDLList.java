package hw3;
/**
 * I pledge my Honor that I have abided by the Stevens Honor System. 
 * @author JingWang 
 *
 * @param <E>
 */
import java.util.ArrayList;

import java.util.NoSuchElementException;

public class IDLList<E> {
	private static class Node<E>{
		//data fields
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		//Constructors
		/**
		 * This constructs new node, given data
		 * @param element data that is stored in the node
		 */
		private Node(E elem){
			data = elem;
		}
		
	/**
	 * This constructs new node and give data to nodes
	 * @param element data thats stored in the node and previous node in list 
     * @param next next node in the list
	 */
	private Node(E elem, Node<E> prev, Node<E> next){
		data = elem;
		this.prev = prev;
		this.next = next;
		}
	}
	//data fields
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	//Constructor
	/**
	 * This creates an empty double linked list
	 */
	public IDLList() {
		head = null;
		tail = null;
		size = 0;
		indices = new ArrayList<Node<E>>();
	}
	/**
	 * This adds elements at position index
	 * @param index position that the node will be added
	 * @param element data stored in the node
	 * @return true if the elements is successfully added, else returns false
	 */
	public boolean add(int index, E element) {
		if(index == 0) {
			this.add(element);
			return true;
			
		}else if(index == size) {
			this.append(element);
			return true;
			
		}else if(index > 0 && index < size - 1) {
			Node<E> first = indices.get(index);
			Node<E> last = first.prev;
			Node<E> newNode = new Node<E>(element, last ,first);
			last.next = newNode;
			first.prev = newNode;
			indices.add(index,newNode);
			size++;
			return true;
			
		}else {
			return false;
		}
	}
	/**
	 * This adds element at the head of the list
	 * @param element data stored in the new node
	 * @return true when the node is added to front of list
	 */
	public boolean add(E elem) {
		Node<E> node = new Node<E>(elem, null, head);
		if(head == null) {
			head = tail = node;
			size++;
			indices.add(node);
			return true;
		}else {
			head.prev = node;
			head = node;
			size++;
			indices.add(0,node);
			return true;
		}
	}
	/**
	 * This adds element as new last element of list
	 * @param element data stored in new node
	 * @return true when node is successfully added to end of list
	 */
	public boolean append(E elem) {
		if(size >= 1) {
			Node<E> node = new Node<E>(elem, tail, null);
			tail.next = node;
			tail = node;
			size++;
			indices.add(node);
			return true;
			
		}else {
			Node<E> node = new Node<E>(elem, null, null);
			head = node;
			tail = node;
			size++;
			indices.add(node);
			return true;
		}
	}
	/**
	 * This returns object at position index from head
	 * @param index position of the node to be received
	 * @return data of the node at the given index
	 */
	public E get(int index) {
		if(index >= size) {
			System.out.println("No node found at index! " + Integer.toString(index));
			return null;
			
		}else {
			return indices.get(index).data;
		}
	}
	
	/**
	 * This gets data in the node at head
	 * @return object at head
	 */
	public E getHead() {
		if (head == null) {
			System.out.println("The list is empty!");
			throw new NoSuchElementException();
			
		} else {
			return head.data;
		}
	}
	
	/**
	 * This element gets the data in the node at the tail
	 * @return object at the tail
	 */
	public E getLast() {
		if (tail == null) {
			System.out.println("List is empty");
			throw new NoSuchElementException();
			
		}else {
			return tail.data;
		}
	}
	
	 /**
	 * This gets the list size
	 * @return the list size
	 */
	public int size() {
		return indices.size();
	}

	/**
	 * This removes and return element at the head
	 * @return element in the removed node
	 */
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		if (size == 1) {
			Node<E> node = head;
			head = null;
			tail = null;
			size--;
			indices.remove(0);
			return node.data;
			
		} else {
			Node<E> node = head;
			head = head.next;
			head.prev = null;
			size--;
			indices.remove(0);
			return node.data;
		}
	}
	/**
	 * This removes and return element at the tail
	 * @return element in the removed node
	 */
	public E removeLast() {
		if (size == 0) {
			throw new NoSuchElementException();
			
		} else {
			E node = tail.data;
			tail = tail.prev;
			tail.next = null;
			size--;
			indices.remove(size - 1);
			return node;
		}
	}
	/**
	 * This removes and returns element at the index
	 * @param index position of node that needed to be removed
	 * @return element at the index
	 */
	public E removeAt(int index) {
		if (index == 0) {
			Node<E> node = indices.get(index);
			this.remove();
			return node.data;
			
		}else if((0< index) && (index < (size - 1))) {
			Node<E> node = indices.get(index);
			node.prev.next = node.next;
			node.next.prev = node.prev;
			indices.remove(index);
			size--;
			return node.data;
			
		}else if(index == (this.size() - 1)) {
			Node<E> node = indices.get(index);
			this.removeLast();
			return node.data;
			
		}
		
		else {
			return null;
		}
	}
	/**
	 * This removes the first occurrence of element in list and returns True
	 * It returns F if element is not in list 
	 * @param element data inside the node that needs to be removed
	 * @return true if element is removed from the list, else returns false
	 */
	public boolean remove(E elem) {
		for(int i = 0; 
				i <= size - 1; i++) {
			
			if (elem == indices.get(i).data) { //when the element to be removed is in the list 
				removeAt(i);
				i--;
				return true;
			}
		}
			return false;
	}
	/**
	 * This is a string representation of the list
	 */
	public String toString() {
		ArrayList<String> str = new ArrayList<String>();
		
		for(Node<E> x = head; 
				x != null;x = x.next) {
			str.add(x.data.toString());
		}
		
		return str.toString();
	}
}
