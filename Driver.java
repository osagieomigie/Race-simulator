/*
  Starting execution point.
*/

import java.util.Scanner;

public class Driver{
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		char car;
		char s;
		String selection;
		
		
		System.out.println("Choose car:");
		System.out.println("(SUV) for SUV");
		System.out.println("(Truck) for Truck");
		selection = in.nextLine();

		ArcticTrack arcticTrack  = new ArcticTrack(selection);
		GameController control = new GameController(arcticTrack);
		
		car = control.startCar(selection);
		arcticTrack.display(selection);

        while(car != 'q') {
        	// sports = control.startSports();
            control.runTurn(car, selection);
            arcticTrack.display(selection);
            car = control.startCar(selection);
        }
    }
}