public class Truck extends Car 
{
	private static final int STANDARD_DISTANCE = 3;
	private static final int STARTING_FUEL = 60;
	private static final int CONSUMPTION_RATE = 4;
	
	private int distanceMoved;
	
	public Truck(Track track)
	{
		super(track);
		setAppearance('T');
		setFuel(STARTING_FUEL);
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
}