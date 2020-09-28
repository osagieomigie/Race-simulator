import java.util.Scanner;

public class GameController
{
	private Scanner in;
	private ArcticTrack arcticTrack;
    private Suv suv;
	//private DesertTrack desertTrack;
	
	public GameController(ArcticTrack arcticTrack)
	{
		in = new Scanner(System.in);
        this.arcticTrack = arcticTrack;
        //this.suv = suv;
	}

	public void suvMenu ()
    {
		System.out.println("(a)ll wheel drive mode - SUV");
		System.out.println("(d)rive normally - SUV");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
    }
	
	public void truckMenu ()
    {
		System.out.println("(d)rive normally - Truck");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
    }

//    public void sportsCarMenu ()
//    {
//		System.out.println("(d)rive normally");
//		System.out.println("(q)uit simulation");
//		System.out.println ("(c)hange fuel of car "); 
//		System.out.print("Enter selection: ");
//    }

//    public void cheatMenu()
//    {
//    	System.out.println ("(0) Toggle debugging messages on/off ");
//		System.out.println ("(1) Change fuel of sports car ");
//		System.out.println ("(2) Change fuel of SUV car "); 
//		System.out.println ("(3) Change location of sports car ");
//		System.out.println ("(4) Change location of SUV car ");
//		System.out.println ("(5) Make a blizzard in the artic track ");
//		System.out.println ("(6) Make a heat wave in the desert track ");
//    }

    public void processSuvMenu (ArcticTrack track, char selection)
    {
    	switch(selection)
    	{
    		case 'D':
    		case 'd':
    			processMove(track, "normal");
    			break;

    		case 'A':
    		case 'a':
    			processMove(track, "awd");
    			break;
    			
            case 'q':
            case 'Q':
                break;

    		default:
    			System.out.println ("Please enter 'd', 'a', or 'q'");
    	}
    }
    
    public void processTruckMenu (ArcticTrack track, char selection)
    {
    	switch(selection)
    	{
    		case 'D':
    		case 'd':
    			processTruckMove(track, "truck");
    			break;

            case 'q':
            case 'Q':
                break;

    		default:
    			System.out.println ("Please enter 'd', or 'q'");
    	}
    }

    
    public char startCar(String selection) {
    	
    	if (selection.equals("SUV")) {
    		return startSuv();
    	}
    	
    	return startTruck();
    }
    
    public char startSuv()
    {
        String suvSelection;
        char a;
        suvMenu();
        suvSelection = in.nextLine();
        a = suvSelection.charAt(0);
        return a; 
    }
    
    public char startTruck()
    {
        String truckSelection;
        char a;
        truckMenu();
        truckSelection = in.nextLine();
        a = truckSelection.charAt(0);
        return a; 
    }

    public void runTurn(char selection)
    {
    	char tmp = Character.toLowerCase(selection);
    	if (tmp == 'd') {
    		processTruckMenu(arcticTrack, selection);
    	}else {
    		processSuvMenu(arcticTrack, selection);
    	}
        //processMenu(sports);
    }
    
    // responsible for determining if the track is already won, and whether to move 
    private void processMove(ArcticTrack track, String driveMode) {
    	
    	if (track.isWonSUV()) {
    		System.out.println("You have won the game!!");
    	}else {
    		if(driveMode.equals("truck")) track.moveTruck();
    		else track.moveSUV(driveMode);

    	}
    }
    
    // responsible for determining if the track is already won, and whether to move 
    private void processTruckMove(ArcticTrack track, String driveMode) {
    	
    	if (track.isWonTruck()) {
    		System.out.println("You have won the game!!");
    	}else {
    		track.moveTruck();
    	}
    }

}