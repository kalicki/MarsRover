package app;
/**
 * 
 * @author kalicki
 *
 */
public class Plateau {
	private int sizeX;
	private int sizeY;

	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Plateau(int x, int y) {
		this.sizeX = x;
		this.sizeY = y;
	}

	public int getSizeX() {
		return this.sizeX;
	}

	public int getSizeY() {
		return this.sizeY;
	}
}
