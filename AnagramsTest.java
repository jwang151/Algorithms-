package hw6;
//I pledge my honor that I have abided by the Stevens Honor System -jwang151

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

public class AnagramsTest {

	@Test
	public void max() {
		Anagrams a = new Anagrams ();
		  final long startTime = System.nanoTime(); 
		  try {
		  a.processFile("words_alpha.txt"); 
		  } catch (IOException e1) {
			  e1.printStackTrace();
		  }
		  
		  ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries(); 
		  final long estimatedTime = System.nanoTime() - startTime;
		  final double seconds = ((double) estimatedTime/1000000000); 
		  
		  
		  System.out.println("Time: "+ seconds);
		  System.out.println("List of max anagrams: "+ maxEntries); 
		  }
		
	}