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
		System.out.println("(a)ll wheel drive mode");
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.print("Enter selection: ");
    }

    public void sportsCarMenu ()
    {
		System.out.println("(d)rive normally");
		System.out.println("(q)uit simulation");
		System.out.println ("(c)hange fuel of car "); 
		System.out.print("Enter selection: ");
    }

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

    public void processMenu (ArcticTrack track, char selection)
    {
    	switch(selection)
    	{
    		case 'D':
    		case 'd':
                track.move("normal");
    			break;

    		case 'A':
    		case 'a':
    			track.move("awd");
    			break;

    		case 'C':
    		case 'c':
    			//track.
    			break;

            case 'q':
            case 'Q':
                break;

    		default:
    			System.out.println ("Please enter 'd', 'a', 'c'");
    	}
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

    public char startSports()
    {
        String sportSelection;
        char a;
        sportsCarMenu();
        sportSelection = in.nextLine();
        a = sportSelection.charAt(0);
        return a;
    }

    public void runTurn(char suvSelection)
    {
        processMenu(arcticTrack, suvSelection);
        //processMenu(sports);
    }

    /*if (track1[START] instanceof Suv)
    {
        int distance = ((Suv)track1[START]).awd();
        track1[START].move(distance);
    }*/

        /*public void runMoves()
    {
        for (int i = 0; i < (SIZE); i++)
        {
            System.out.print("Turn: " + (i+1) + ":");
            display();
            moveOne();
            System.out.println();
        }
    }*/
}