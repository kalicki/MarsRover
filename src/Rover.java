
public class Rover {
	private Position pos;

	public Rover() {

	}

	private void instructionsRover(String instructions) {
		for (char c : instructions.toCharArray()) {

			switch (c) {
				case 'L':
					// Left: North -> West
					if (pos.getFront() == 'N') {
						pos.setFront('W');
					}
					if (pos.getFront() == 'S') {
						pos.setFront('E');
					}
					if (pos.getFront() == 'E') {
						pos.setFront('N');
					}
					if (pos.getFront() == 'W') {
						pos.setFront('S');
					}
					break;
				case 'R':
					// Right: North -> East
					if (pos.getFront() == 'N') {
						pos.setFront('E');
					}
					if (pos.getFront() == 'S') {
						pos.setFront('W');
					}
					if (pos.getFront() == 'E') {
						pos.setFront('S');
					}
					if (pos.getFront() == 'W') {
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
				pos.getY(); 			// +1
				break;
			case 'S': 					// South Y-1
				pos.getY(); 			// decrement -1
				break;
			case 'E': 					// East X+1
				pos.getX(); 			// +1
				break;
			case 'W': 					// West X-1
				pos.getX(); 			// decrement -1
				break;
		}
	}
}
