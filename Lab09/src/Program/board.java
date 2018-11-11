package Program;

public class board {
	
	private int x;
	private int y;
	private boolean on;
	
	public board(int x, int y, boolean on) {
		this.x = x;
		this.y = y;
		this.on = on;
	}
	
	public boolean on() {
		return on;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}

}
