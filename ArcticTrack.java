import java.util.Random;

public class ArcticTrack extends Track 
{
	public static final int START = 0;
	private boolean blizzard = false;

	private int currentLocation;

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

	public void moveSUV(String driveMode)
	{
		Suv [] track = getTrackSuv();
		Suv car = track[currentLocation];

		// only move if there is fuel in the car
		if (car.getFuel() >0 && car.consumptionRate(driveMode) <= car.getFuel() ) { 
			car.move(driveMode);
			
			int tmp = 0;
			
			if (driveMode.equals("normal")){
	    	   tmp =  car.normalDrive(); 
			}else {
	    	   tmp = car.awd();
	       }
			
			//setLocation(car, currentLocation+1);
			setLocation(car, currentLocation+tmp);
			track[currentLocation] = null;
			//currentLocation++;
			currentLocation += tmp; // update current location 
		}else {
			System.out.println("Out of fuel, please refuel!");
		}
	}
	
	public void moveTruck()
	{
		Truck [] track = getTrackTruck();
		Truck car = track[currentLocation];

		// only move if there is fuel in the car
		if (car.getFuel() >0 && car.consumptionRate() <= car.getFuel() ) { 
			
			int tmp = car.move();
			
			setLocation(car, currentLocation+tmp);
			track[currentLocation] = null;
			//currentLocation++;
			currentLocation += tmp; // update current location 
		}else {
			System.out.println("Out of fuel, please refuel!");
		}
	}
}