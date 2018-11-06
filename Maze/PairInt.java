package Maze;

public class PairInt {
	//data fields
	private int x;
	private int y;
	
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals (Object p) {
		if(p.getClass() == this.getClass()) {
			PairInt pair = (PairInt)p;
			return pair.x == this.x && pair.y == this.y;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public PairInt copy() {
		return new PairInt(this.x, this.y);
	}
}
