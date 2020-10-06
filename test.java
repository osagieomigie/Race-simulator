import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class test {
	
	private static GameController control;
	private static ArcticTrack arcticTrack; 
	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpBeforeClass() {
		 arcticTrack = new ArcticTrack("SUV");
		 control = new GameController(arcticTrack);
		 
		 System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	

	@Test
	public void testInvalidMove() {
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'w');
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Please enter 'd', 'a', or 'q'", result);
	}
	
	@Test
	public void testNormalDriveSUV_one() {
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'd'); 
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 47\nFuel use: 3\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | |V| | | | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}
	
	@Test
	public void testNormalDriveSUV_two() {
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'd');
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'd');
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 44\nFuel use: 3\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | | |V| | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}

	@Test
	public void testNormalDriveSUV_win() {
		outContent.reset(); // clear buffer 
		
		// move car to end of track 
		for(int i =0; i<12; i++) {
			Suv.drive(arcticTrack, "normal");
			outContent.reset(); // clear buffer 
		}
		control.processSuvMenu(arcticTrack, 'd');

		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("You have won the game!!", result);
	}
	
	@Test
	public void testAWDDriveSUV_one() {
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'a'); 
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 46\nFuel use: 4\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | |V| | | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}
	
	@Test
	public void testAWDDriveSUV_two() {
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'a');
		outContent.reset(); // clear buffer 
		control.processSuvMenu(arcticTrack, 'a');
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 42\nFuel use: 4\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | | | | |V| | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}

	@Test
	public void testAWDDriveSUV_win() {
		outContent.reset(); // clear buffer 
		
		// move car to end of track 
		for(int i =0; i<8; i++) {
			Suv.drive(arcticTrack, "awd");
			outContent.reset(); // clear buffer 
		}
		control.processSuvMenu(arcticTrack, 'a');

		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("You have won the game!!", result);
	}
}
