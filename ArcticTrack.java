import java.util.Random;

public class ArcticTrack extends Track 
{
	public static final int START = 0;
	private boolean blizzard = false;

	private int currentLocation;

	public ArcticTrack()
	{
		super("SUV");
		setLocation(new Suv(this), START);
    	currentLocation = START;
	}


	public void blizzard()
	{
		Random aGenerator = new Random();
		int generate = aGenerator.nextInt(100)+1;
		int blizValue = 10;
		
		
		if (blizValue >= generate)
		{
			blizzard = true;
		}else blizzard = false;
	}

	public boolean getBlizzard()
	{
		return blizzard;
	}

	public void move(String driveMode)
	{
		Suv [] track = getTrackSuv();
		Suv car = track[currentLocation];

		// only move if there is fuel in the car
		if (car.getFuel() >0 && car.consumptionRate(driveMode) <= car.getFuel() ) { 
			int tmp = car.move(driveMode);
			//setLocation(car, currentLocation+1);
			setLocation(car, currentLocation+tmp);
			track[currentLocation] = null;
			//currentLocation++;
			currentLocation += tmp; // update current location 
		}else {
			System.out.println("Out of fuel, please refuel!");
		}
	}
}