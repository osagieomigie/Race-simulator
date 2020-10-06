public class Suv extends Car
{
	private static final int CONSUMPTION_RATE = 3;
	private int STARTING_FUEL = 50;
	private int distanceMoved;
	private static int currentLocation;

	public Suv(Track track)
	{
		super(track);
		setAppearance('V');
		setFuel(STARTING_FUEL);
		currentLocation = START;
	}

	public int normalDrive()
	{
		distanceMoved = getStandardDistance();
		return distanceMoved;
	}

	public int awd()
	{
		distanceMoved = getStandardDistance() + 1; 
		return distanceMoved;
	}
	
	public void printCurrentFuel(String driveMode) {
		if (driveMode.equals("normal")) {
			consumeFuel(CONSUMPTION_RATE);
		}else consumeFuel(CONSUMPTION_RATE+1); // suv consumes more in awd mode 
       
       System.out.println("Current fuel: " + getFuel());
	}
    
    public void printFuelConsumption(String driveMode) {
    	// print consumption rate 
        if (driveMode.equals("normal")) {
     	   System.out.println("Fuel use: " + CONSUMPTION_RATE);
 		}else {
 			int tmp = CONSUMPTION_RATE+1;
 			System.out.println("Fuel use: " + tmp); // suv consumes more in awd mode 
 		}
    }

	public int getDistance()
	{
		return distanceMoved;
	}
	
	public int consumptionRate(String driveMode) {
		if (driveMode.equals("normal"))return CONSUMPTION_RATE;
		
		return CONSUMPTION_RATE+1;
	}
	
	public static void drive(ArcticTrack atrack, String driveMode){
		Suv [] track = atrack.getSuvTrack();
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
			atrack.setLocation(car, currentLocation+tmp);
			track[currentLocation] = null;
			//currentLocation++;
			currentLocation += tmp; // update current location 
		}else {
			System.out.println("Out of fuel, please refuel!");
		}
	}
}