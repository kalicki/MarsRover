
public class Rover {
	private Position pos;
	
	public Rover(Position pos) {
		this.pos = pos;
	}

	public void instructionsRover(String instructions) {
		for (char c : instructions.toCharArray()) {
			System.out.println(c);

			switch (c) {
				case 'L':
					// Left: North -> West
					if (pos.getFront() == (char) 'N') {
						pos.setFront('W');
					}
					if (pos.getFront() == (char) 'S') {
						pos.setFront('E');
					}
					if (pos.getFront() == (char) 'E') {
						pos.setFront('N');
					}
					if (pos.getFront() == (char) 'W') {
						pos.setFront('S');
					}
					break;
				case 'R':
					// Right: North -> East
					if (pos.getFront() == (char)'N') {
						pos.setFront('E');
					}
					if (pos.getFront() == (char)'S') {
						pos.setFront('W');
					}
					if (pos.getFront() == (char)'E') {
						pos.setFront('S');
					}
					if (pos.getFront() == (char)'W') {
						pos.setFront('N');
					}
	
					break;
				case 'M':
					this.moveRover();
					break;
				default:
					// error
					throw new IllegalArgumentException("Dont support: " + c);
			}
		}
	}

	private void moveRover() {
		switch (pos.getFront()) {
			case 'N': 					//North Y+1
				pos.setY( pos.getY() + 1);
				break;
			case 'S': 					// South Y-1
				pos.setY( pos.getY() - 1);
				break;
			case 'E': 					// East X+1
				pos.setX( pos.getX() + 1);
				break;
			case 'W': 					// West X-1
				pos.setX( pos.getX() - 1);
				break;
		}
	}
}
