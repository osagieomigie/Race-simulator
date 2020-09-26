/*
  Starting execution point.
*/

public class Driver{
	public static void main(String [] args){
		char suv;
        //char sports;
		ArcticTrack arcticTrack  = new ArcticTrack();
		GameController control = new GameController(arcticTrack);
		
		suv = control.startSuv();
		arcticTrack.display("SUV");

        while(suv != 'q') {
        	// sports = control.startSports();
            control.runTurn(suv);
            arcticTrack.display("SUV");
            suv = control.startSuv();
        }
    }
}