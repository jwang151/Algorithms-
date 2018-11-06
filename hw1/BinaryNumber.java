package hw1;

/***
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 * 
 * @author jingwang
 *
 */
public class BinaryNumber {
	/**
	 * data fields 
	 */
	private int data[]; //will represent a binary number as an array --> [1,0,0,0,1]
	private boolean overflow;
	//as of now, the data fields have been DECLARED, but have not been INITIALIZED with actual values
	
	//the purpose of a constructor is to assign value or meaning to the DECLARED data fields
	//this constructor produces an array of zeros of size "length"
	/**
	 * Constructors that assign the value to the declare fields and produce the array of zeros of size 
	 * length 
	 * @param length
	 */
	public BinaryNumber(int length) {
		this.data = new int[length];
		this.overflow = false;
	}
	/**
	 * This method creates a new binary number given a string 
	 * The string that represents a binary number will be created
	 * @param str
	 */
	public BinaryNumber(String str) { //takes a string "10111" --> [1,0,1,1,1]
		overflow = false;
		this.data = new int[str.length()];
		for(int j = 0; j<str.length(); j++){
			int temp = java.lang.Character.getNumericValue(str.charAt(j));
			if (temp == 1 || temp == 0) {
				this.data[j] = java.lang.Character.getNumericValue(str.charAt(j));}
			else { System.out.println("Only works with 0 or 1");
			break; }
		}
	}
	/** 
	 * @return the length of the binary number 
	 */
	public int getLength() {
			return data.length;
	}
	/**
	 * 
	 * @param index
	 * @return the digit of the binary number at that index 
	 */
	public int getDigit(int index) {
		if (index >= data.length || index < 0) {
			throw new IndexOutOfBoundsException("This index is out of bounds");
		}
		return this.data[index];
	}
	/**
	 * This will shifts all the digits in binary number a number of places to the right
	 */
	public void shiftR(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount has to be greater than or equal to 0.");
		}
		int var[] = data;
		data = new int[amount + var.length];
		for (int j = 0; j < amount; j++) {
			data[j] = 0;
		}
		for (int j = amount; j < data.length; j++) {
			data[j] = var[j - amount];
		}
	}
	
	/**
	 * 
	 * 
	 * @return This method adds two recieving binary numbers, 
	 * if the lengths are not the same an error message is printed. 
	 */
	public BinaryNumber add(BinaryNumber aBinaryNumber){
		if(data.length != aBinaryNumber.getLength()){
			throw new IllegalArgumentException("The lengths of the binary numbers do not match.");
		}
		boolean dataHold = false;
			for (int i = 0; i< data.length; ++i) {
				if (aBinaryNumber.getDigit(i)== 0 && data[i]==0) {
					if (dataHold) {
						data[i] = 1; 
							dataHold = false; 
					} else { 
						data[i] = 0; 
					}
					continue;
				}
				if ((aBinaryNumber.getDigit(i)== 1 && data[i]==0) ||(aBinaryNumber.getDigit(i)== 0 && data[i]==1) ) {
					if (dataHold) {
						data[i] = 0; 
							dataHold = true; 
					} else { 
						data[i] = 1; 
					} continue;
				}
				if (aBinaryNumber.getDigit(i)== 1 && data[i]==1) {
					if (dataHold) {
						data[i] = 1; 
							dataHold = true; 
					} else { 
						data[i] = 0;
						dataHold = true; 
					}
				}
			}
			overflow = dataHold; 
		
		return aBinaryNumber;
			
			}
		
	/**
	 * Returns the string of the binary number 
	 */
	public String toString() {
		String out = "";
		for (int i : this.data)
			out += Integer.toString(i);
		return out;
	}
	/**
	 * 
	 *This method @returns the decimal notation of the binary number 
	 */
	public int toDecimal() {
		int sum = 0;
		for (int j = 0; j < data.length; j++) {
			sum += this.data[j] * Math.pow(2, j);
		}
		return sum;
	}
	/**
	 * This method here clears the overflow.
	 */
	public void clearOverflow() {
		this.overflow = false; 
	}
	/**
	 * This is to test out the different methods in the code 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryNumber b = new BinaryNumber(5); // --> [0,0,0,0,0]
		BinaryNumber b2 = new BinaryNumber("01011");
		b.add(b2);
		System.out.println(b);
		System.out.println(b.toDecimal());
	}
}

