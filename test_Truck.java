import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test_Truck {
	
	private static GameController control;
	private static ArcticTrack arcticTrack; 
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpBeforeClass() {
		 arcticTrack = new ArcticTrack("Truck");
		 control = new GameController(arcticTrack);
		 
		 System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	

	@Test
	public void testInvalidMoveTruck() {
		outContent.reset(); // clear buffer 
		control.processTruckMenu(arcticTrack, 'w');
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Please enter 'd', or 'q'", result);
	}
	
	@Test
	public void testNormalDriveTruck_one() {
		outContent.reset(); // clear buffer 
		control.processTruckMenu(arcticTrack, 'd'); 
		arcticTrack.display("Truck");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 56\nFuel use: 4\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | |T| | | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}
	
	@Test
	public void testNormalDriveTruck_two() {
		outContent.reset(); // clear buffer 
		control.processTruckMenu(arcticTrack, 'd');
		outContent.reset(); // clear buffer 
		control.processTruckMenu(arcticTrack, 'd');
		arcticTrack.display("Truck");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 52\nFuel use: 4\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | | | | |T| | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}

	@Test
	public void testNormalDriveTruck_win() {
		outContent.reset(); // clear buffer 
		
		// move car to end of track 
		for(int i =0; i<8; i++) {
			Truck.drive(arcticTrack);
			outContent.reset(); // clear buffer 
		}
		control.processTruckMenu(arcticTrack, 'd');

		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("You have won the game!!", result);
	}
}
