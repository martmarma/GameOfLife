package bbc.gameoflifestub;

public class Cell {
	
	private int x;
	private int y;
	private boolean alive;

	public Cell(int x, int y, boolean alive) {
		
		this.x = x;
		this.y = y;	
		this.alive = alive;
	}
	
	public int getX() {
		
		return this.x;
	}
	
	public int getY() {
		
		return this.y;
	}
	
	public boolean isAlive() {
		
		return this.alive;
	}
	
	public String toString() {
		
		String aliveChar = "*";
		
		if (!alive) {
			
			aliveChar = ".";
		}
		
		return aliveChar;
	}
}
