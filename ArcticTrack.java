import java.util.Random;

public class ArcticTrack extends Track 
{
	public static final int START = 0;
	private boolean blizzard = false;

	private int currentLocation;

	public ArcticTrack()
	{
		super();
		setLocation(new Suv(this), START);
    	currentLocation = START;
	}


	public void blizzard()
	{
		Random aGenerator = new Random();
		int generate = aGenerator.nextInt(100)+1;
		int blizValue = 10;
		
		if (blizValue <= generate)
		{
			blizzard = true;
		}
	}

	public boolean getBlizzard()
	{
		return blizzard;
	}

	public void move()
	{
		Car [] track = getTrack();
		Car car = track[currentLocation];

		// only move if there is fuel in the car
		if (car.getFuel() >0) { 
			car.move();
			setLocation(car, currentLocation+1);
			track[currentLocation] = null;
			currentLocation++;
		}
	}
}