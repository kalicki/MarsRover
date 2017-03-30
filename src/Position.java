
public class Position {
	private int x;
	private int y;
	private char front;
	
	public Position(int x, int y, char front) {
		this.setX(x);
		this.setY(y);
		this.setFront(front);
	}
	public Position() {
		this.setX(0);
		this.setY(0);
		this.setFront('N');
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getFront() {
		return front;
	}
	public void setFront(char front) {
		this.front = front;
	}
}
