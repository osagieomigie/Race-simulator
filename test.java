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
		 arcticTrack = new ArcticTrack();
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
		control.processMenu(arcticTrack, 'w');
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Please enter 'd', 'a', or 'c'", result);
	}
	
	@Test
	public void testNormalDrive_one() {
		outContent.reset(); // clear buffer 
		control.processMenu(arcticTrack, 'd'); 
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 47\nFuel use: 3\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | |V| | | | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}
	
	@Test
	public void testNormalDrive_two() {
		outContent.reset(); // clear buffer 
		control.processMenu(arcticTrack, 'd');
		outContent.reset(); // clear buffer 
		control.processMenu(arcticTrack, 'd');
		arcticTrack.display("SUV");
		String result = outContent.toString().trim(); // remove trailing spaces 
		assertEquals("Current fuel: 44\nFuel use: 3\n 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P\n - - - - - - - - - - - - - - - - - - - - - - - - -\n| | | | |V| | | | | | | | | | | | | | | | | | | | |\n - - - - - - - - - - - - - - - - - - - - - - - - -", result);
	}
//
//	@Test
//	void testTrack() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testTrackString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetTrack() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testGetTrackSuv() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetLocationCarInt() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testSetLocationSuvInt() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testIsWon() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	void testIsWonSUV() {
//		fail("Not yet implemented"); // TODO
//	}

}
