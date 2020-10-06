public class Sports extends Car 
{
	private static final int STANDARD_DISTANCE = 3;
	private static final int STARTING_FUEL = 30;
	private static final int CONSUMPTION_RATE = 3;
	
	private int distanceMoved;
	
	public Sports(Track track)
	{
		super(track);
		setAppearance('P');
		setFuel(STARTING_FUEL);
	}
	
	public int getStartingFuel() {
		return STARTING_FUEL;
	}

	public int getDistanceMoved()
	{
		return distanceMoved;
	}
	
	public void driveNormally()
	{
		distanceMoved = STANDARD_DISTANCE;
	}
	
	public void printCurrentFuel(String driveMode) {
		consumeFuel(CONSUMPTION_RATE);
		System.out.println("Current fuel: " + getFuel());
	}
    
    public void printFuelConsumption(String driveMode) {
    	// print consumption rate 
    	System.out.println("Fuel use: " + CONSUMPTION_RATE);
    }
}