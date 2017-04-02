package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Plateau;
import app.Position;
import app.Rover;

public class MarsRoverTest {
	private Position pos;
	private Plateau plateaux;
	private Rover rov;
	
	@Before
	public void setUp() {
		plateaux = new Plateau(5, 5);
		pos = new Position(1, 2, 'N');
		/*
		pos = new Position(); // Default is (0, 0, N) need required sets
		pos.setX(1);
		pos.setY(2);
		pos.setFront('N');
		*/
		rov = new Rover(plateaux, pos);
		//rov.instructionsRover("LMLMLMLMM"); // Contains IllegalArgumentException
	}
	
	/*
	 * Actual front is North rotating by right is East
	 */
	@Test
	public void testFrontToRight() throws Exception {
		rov.instructionsRover("R");
		assertEquals('E', pos.getFront());
	}
	
	/*
	 * Actual front is North rotating by left is West
	 */
	@Test
	public void testFrontToLeft() throws Exception {
		rov.instructionsRover("L");
		assertEquals('W', pos.getFront());
	}
	
	/*
	 * Actual front is North 2x rotating by left/right is South
	 */
	@Test
	public void testFrontToSouth() throws Exception {
		// North -> West -> South
		pos.setFront('N');
		rov.instructionsRover("LL");
		assertEquals('S', pos.getFront());
		
		// North -> East -> South
		pos.setFront('N');
		rov.instructionsRover("RR");
		assertEquals('S', pos.getFront());
	}
	
	/*
	 * Check move from 1 2 N to 0 1 N
	 */
	@Test
	public void testMove() throws Exception {
		rov.instructionsRover("LLMRM");
		
		// Correct: 0 1 W
		assertEquals(0, pos.getX());
		assertEquals(1, pos.getY());
		assertEquals('W', pos.getFront());
	}
	
	/*
	 * Check move from 3 3 E to 5 1 E
	 */
	@Test
	public void testMove2() throws Exception {
		// Reset position
		pos.setFront('E');
		pos.setX(3);
		pos.setY(3);
		rov.instructionsRover("MMRMMRMRRM");
		
		// Correct: 5 1 E
		assertEquals(5, pos.getX());
		assertEquals(1, pos.getY());
		assertEquals('E', pos.getFront());
	}
}
