import java.util.Random;

public class ArcticTrack extends Track 
{
	public static final int START = 0;
	private boolean blizzard = false;

//	public ArcticTrack()
//	{
//		super("SUV");
//		setLocation(new Suv(this), START);
//    	currentLocation = START;
//	}
	
	public ArcticTrack(String carType)
	{
		super(carType);
		
		if (carType.equals("Truck")) {
			setLocation(new Truck(this), START);
		}else {
			setLocation(new Suv(this), START);
		}
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
}