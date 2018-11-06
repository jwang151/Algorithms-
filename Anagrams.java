package hw6;

//I pledge my honor that I have abided by the Stevens Honor System. -jwang151
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Anagrams {
  //data fields
  public final Integer[] primes;
  public Map<Character,Integer> letterTable = new HashMap<Character, Integer>(); 
  public Map<Long, ArrayList<String>> anagramTable = new HashMap<Long, ArrayList<String>>();
  
  //constructor
  public Anagrams(){
    primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    buildLetterTable();
    
  }
 
  
  //methods
  public void processFile(String s) throws IOException { 
    FileInputStream filestream = new FileInputStream(s);
    BufferedReader br = new BufferedReader(new InputStreamReader(filestream)); 
    String strLine;
    
    while ((strLine = br.readLine()) != null) { 
      this.addWord(strLine);
    } 
    br.close();
  }
  
  /**
   * This is to build the hash table
   */
  public void buildLetterTable() {
    int index = 0;
    for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
      letterTable.put(alphabet, primes[index]);
      index++;
    }
  }
  
  /**
   * This multiplies each letter in given key using LetterTable
   * @param s given string
   * @return the result key from s  
   */
  public long myHashCode(String s){
    long result = (long) 1;
    char[] temp = s.toCharArray();
    for(int i=0; i < temp.length; i++){
      result *= letterTable.get(temp[i]);       
    }
    
    	return result;
  }
  /**
   * This computes hash code of given string, s and adds this word to anagramTable 
   * @param s given string
   */
  public void addWord(String s){
	  
    if(anagramTable.containsKey(myHashCode(s)) == false){
      ArrayList temp = new ArrayList<String>();
      temp.add(s);
      anagramTable.put(myHashCode(s), temp);
      
    } else {
      ArrayList list = anagramTable.get(myHashCode(s));
      list.add(s);
    }
  }
  /**
   *This compares arraylist size with int max and replace max and longest if given arraylist is bigger
   * @return a list of entries in anagramTable that have the largest num of anagrams
   */
 public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
	  Iterator it = anagramTable.entrySet().iterator();
	  int max = 0;
	  ArrayList<Map.Entry<Long,ArrayList<String>>> longest = new ArrayList();
	  while(it.hasNext()) {
		  Map.Entry pair = (Map.Entry)it.next();
		  pair.getKey();
		  if(((ArrayList<String>)(pair.getValue())).size() > max) {
			  max = ((ArrayList<String>)(pair.getValue())).size(); 
			  longest.clear();
			  longest.add(pair);
		  }
	  }
	  return longest;
  }
  public static void main(String[] args) {
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