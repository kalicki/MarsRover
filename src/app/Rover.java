package app;
/**
 * 
 * @author kalicki
 *
 */
public class Rover {
	private Position pos;
	private Plateau tableland;

	/**
	 * Constructor with Plateau and Position
	 * @param tableland
	 * @param pos
	 */
	public Rover(Plateau tableland, Position pos) {
		this.tableland = tableland;
		this.pos = pos;
	}

	/**
	 * Method that controls the robo
	 * @param instructions
	 */
	public void instructionsRover(String instructions) {
		// Break String to Character and Convert Lower->UpperCase
		for (Character c : instructions.toUpperCase().toCharArray()) {
			switch (c) {
				case 'L':
					if (pos.getFront() == 'N') {			// Left: North -> West
						pos.setFront('W');
					} else if (pos.getFront() == 'S') {		// Left: South -> East
						pos.setFront('E');
					} else if (pos.getFront() == 'E') {		// Left: East -> North
						pos.setFront('N');
					} else if (pos.getFront() == 'W') { 	// Left: West -> South
						pos.setFront('S');
					}
					break;
				case 'R':
					if (pos.getFront() == 'N') {			// Right: North -> East
						pos.setFront('E');
					} else if (pos.getFront() == 'S') {		// Right: South -> West
						pos.setFront('W');
					} else if (pos.getFront() == 'E') {		// Right: East -> South
						pos.setFront('S');
					} else if (pos.getFront() == 'W') {		// Right: West -> North
						pos.setFront('N');
					}
	
					break;
				case 'M':
					this.moveRover();
					break;
				default:
					// Error
					throw new IllegalArgumentException("Dont support: " + c);
			}
		}
	}

	/**
	 * Method to move (go/back) the robo
	 * This dont move front = face
	 */
	private void moveRover() {
		switch (pos.getFront()) {
			case 'N':
				// North Y+1
				if (pos.getY() < tableland.getSizeY())
					pos.setY(pos.getY() + 1);
				break;
			case 'S':
				// South Y-1
				if (pos.getY() > 0)
					pos.setY(pos.getY() - 1);
				break;
			case 'E':
				// East X+1
				if (pos.getX() < tableland.getSizeX())
					pos.setX( pos.getX() + 1);
				break;
			case 'W':
				// West X-1
				if (pos.getX() > 0)
					pos.setX(pos.getX() - 1);
				break;
			}
	}

	/**
	 * Default return with X Y Front (e.g: 1 5 N)
	 */
	@Override
	public String toString() {
		return pos.getX() + " " + pos.getY() + " " + pos.getFront();
	}
}
