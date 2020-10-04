/*
  Features:
  * Stores and tracks all information associated with a racetrack.
*/


public class Track
{
    private static final int SIZE = 25;
    private Car [] aTrack;
    
    // Create the track of suvs and initialize all elements to sensible default values.
    public Track(String type){
    	if (type.equals("SUV")) {
		   int c;
		   aTrack = new Suv[SIZE];
		   for (c = 0; c < SIZE; c++)
			   aTrack[c] = null;
    	}else { // initialize a track of trucks 
    		int c;
    		aTrack = new Truck[SIZE];
 		   	for (c = 0; c < SIZE; c++)
 		   	aTrack[c] = null;
    	}
    }
    
    
    public void printTrackLabels() {
    	int c;
    	final int FIRST_CAPITAL = 65;     // ASCII value for 'A' = 65
    	int temp_code;
    	char temp_char;
    	// Labels for the columns
    	for (c = 0; c < SIZE; c++){
    		if (c < 9) {
    			System.out.print(" " + (c+1));
    		}
    		// Display letters for values >= 10, A = 10, B = 11 etc.
    		// ASCII 'A' = 65, 'B' = 66
    		else{
    			// Determine ASCII code of label
    			temp_code = FIRST_CAPITAL + (c - 9);
    			
    			// Convert ASCII code to a character and display
    			temp_char = (char) temp_code;
    			System.out.print(" " + temp_char);
    		}	
 		}
 		System.out.println();
    }
    
    public void printSeparator() {
    	int c;
    	// Row of dashes before the elements of the track
    	for (c = 0; c < SIZE; c++){
    		System.out.print(" -");
    	}
    	System.out.println();
    }
    
    public void printTrack(Car [] carTrack) {
    	int c;
    	for (c = 0; c < SIZE; c++){
    		if (carTrack[c] != null){
    			// Each element is preceeded by a vertical bar.
    			System.out.print('|');
    			// Display element element.
    			System.out.print(carTrack[c]);
		    }
		    else {
		    	System.out.print("| ");
		    }
		}
    	
    	// Closing bar at end of row (follows last element)
    	System.out.println('|');
    }

    // Displays the track with a numbered grid around element element.
    // Columns 10 and greater are labeled with capital letters of the alphabet
    public void display(String carType)
    {
    	// print the column labels
    	printTrackLabels();
		
    	// print separator 
    	printSeparator();
    	
    	// Display each track element bound left and right by vertical bar.
    	printTrack(aTrack);
	
		// print separator 
    	printSeparator();

    }

    public Truck [] getTruckTrack (){
		return (Truck[]) aTrack;
    }
    
    public Suv []  getSuvTrack (){
		return (Suv[]) aTrack;
    }

    // Used place a car object at a particular index in the track, useful for 
    // child classes that needs to place the two cars at the starting location.
    protected void setLocation(Car aCar, int index){
		if ((index >= 0) && (index < Track.SIZE))
		    aTrack[index] = aCar;
		else
		{
		    if ((index < 0) || (index >= Track.SIZE)) {
		    	aTrack[Track.SIZE] = aCar;
		    	System.out.println("You have won the game!!");
		    	//System.out.println("Placing car out of bounds of track 0-" + Track.SIZE);	
		    }
		}
    }


    // The whole track is empty except for a single car so if a car reaches the 
    // final column then the simulation is 'won' for this track.
    public boolean isWon (){
	   if (aTrack[SIZE-1] != null)
	       return true;
	   else
	       return false;
    }
}