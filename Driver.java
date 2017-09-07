/*
  Author:  James Tam
  Version: April 1, 2013

  Starting execution point.

*/


public class Driver
{
    public static void main(String [] args)
    {
        char suv;
        char sports;
      ArcticTrack arcticTrack  = new ArcticTrack();

      GameController control = new GameController(arcticTrack);


      suv = control.startSuv();
      arcticTrack.display();

        while(suv != 'q') {
            // sports = control.startSports();
            control.runTurn(suv);
            arcticTrack.display();
            suv = control.startSuv();
        }
    }
}