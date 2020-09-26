/*
  Features:
  * Stores and tracks all information associated with a racetrack.
*/


public class Track
{
    public static final int SIZE = 25;

    private Car [] aTrack;
    private Suv [] suvTrack;


    // Create the track and initialize all elements to sensible default values.
    public Track()
    {
	   int c;
	   aTrack = new Car[SIZE];
	   for (c = 0; c < SIZE; c++)
	       aTrack[c] = null;
    }
    
 // Create the track of suvs and initialize all elements to sensible default values.
    public Track(String type)
    {
    	if (type.equals("SUV")) {
		   int c;
		   suvTrack = new Suv[SIZE];
		   for (c = 0; c < SIZE; c++)
		       suvTrack[c] = null;
    	}
    }

    // Displays the track with a numbered grid around element element.
    // Columns 10 and greater are labeled with capital letters of the alphabet
    public void display(String carType)
    {
	   int c;
	   final int FIRST_CAPITAL = 65;     // ASCII value for 'A' = 65
	   int temp_code;
	   char temp_char;
	   // Labels for the columns
	   for (c = 0; c < SIZE; c++)
	   {
	       if (c < 9)
		      System.out.print(" " + (c+1));
	       // Display letters for values >= 10, A = 10, B = 11 etc.
	       // ASCII 'A' = 65, 'B' = 66
	       else
	       {
		      // Determine ASCII code of label
		      temp_code = FIRST_CAPITAL + (c - 9);

		      // Convert ASCII code to a character and display
		      temp_char = (char) temp_code;
		      System.out.print(" " + temp_char);
	       }	
		}
		System.out.println();
	
	
		// Row of dashes before the elements of the track
		for (c = 0; c < SIZE; c++)
		{
		    System.out.print(" -");
		}
		System.out.println();
		
		if (carType.equals("SUV")) {
			// Display each track element bound left and right by vertical bar.
			for (c = 0; c < SIZE; c++)
			{
			    if (suvTrack[c] != null)
			    {
				   // Each element is preceeded by a vertical bar.
				   System.out.print('|');
				   // Display element element.
				   System.out.print(suvTrack[c]);
			    }
			    else
				   System.out.print("| ");
			} 
		}else {
			// Display each track element bound left and right by vertical bar.
			for (c = 0; c < SIZE; c++)
			{
			    if (aTrack[c] != null)
			    {
				   // Each element is preceeded by a vertical bar.
				   System.out.print('|');
				   // Display element element.
				   System.out.print(aTrack[c]);
			    }
			    else
				   System.out.print("| ");
			} 
		}
		
		
		// Closing bar at end of row (follows last element)
		System.out.println('|');
	
		// Row of dashes after the elements of the track
		for (c = 0; c < SIZE; c++)
		{
		    System.out.print(" -");
		}
		System.out.println();

    }

    public Car []  getTrack ()
    {
		return aTrack;
    }
    
    public Suv []  getTrackSuv ()
    {
		return suvTrack;
    }


    // Used place a car object at a particular index in the track, useful for 
    // child classes that needs to place the two cars at the starting location.
    protected void setLocation(Car aCar, int index)
    {
	if ((index >= 0) && (index < Track.SIZE))
	    aTrack[index] = aCar;
	else
	{
	    if ((index < 0) || (index >= Track.SIZE))
		System.out.println("Placing car out of bounds of track 0-" + Track.SIZE);	    
	}
    }
    
    protected void setLocation(Suv aCar, int index)
    {
	if ((index >= 0) && (index < Track.SIZE))
	    suvTrack[index] = aCar;
	else
	{
	    if ((index < 0) || (index >= Track.SIZE))
		System.out.println("Placing car out of bounds of track 0-" + Track.SIZE);	    
	}
    }

    // The whole track is empty except for a single car so if a car reaches the 
    // final column then the simulation is 'won' for this track.
    public boolean isWon ()
    {
	   if (aTrack[SIZE-1] != null)
	       return true;
	   else
	       return false;
    }
    
    
    // used for determining if an suv has won
    public boolean isWonSUV ()
    {
	   if (suvTrack[SIZE-1] != null)
	       return true;
	   else
	       return false;
    }
}