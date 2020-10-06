public class Truck extends Car 
{
	private static final int STANDARD_DISTANCE = 3;
	private static final int STARTING_FUEL = 60;
	private static final int CONSUMPTION_RATE = 4;
	private static int currentLocation;
	
	private int distanceMoved;
	
	public Truck(Track track)
	{
		super(track);
		setAppearance('T');
		setFuel(STARTING_FUEL);
		currentLocation = START;
	}

	public int getDistanceMoved()
	{
		return STANDARD_DISTANCE;
	}
	
	public int getStartingFuel() {
		return STARTING_FUEL;
	}
	
	public void printCurrentFuel(String driveMode) {
		consumeFuel(CONSUMPTION_RATE);
		System.out.println("Current fuel: " + getFuel());
	}
    
    public void printFuelConsumption(String driveMode) {
    	// print consumption rate 
    	System.out.println("Fuel use: " + CONSUMPTION_RATE);
    }
	
	public int consumptionRate() {
		return CONSUMPTION_RATE;
	}
	
	public static void drive(ArcticTrack atrack){
		Truck [] track = atrack.getTruckTrack();
		Truck car = track[currentLocation];

		// only move if there is fuel in the car
		if (car.getFuel() >0 && car.consumptionRate() <= car.getFuel() ) { 
			
			car.move("non");
			int distanceMoved = car.getDistanceMoved();
			atrack.setLocation(car, currentLocation+distanceMoved);
			track[currentLocation] = null;
			//currentLocation++;
			currentLocation += distanceMoved; // update current location 
		}else {
			System.out.println("Out of fuel, please refuel!");
		}
	}
}