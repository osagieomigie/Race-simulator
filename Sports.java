public class Sports extends Car 
{
	private static final int STANDARD_DISTANCE = 3;
	private static final int STARTING_FUEL = 30;
	private static final int CONSUMPTION_RATE = 3;
	
	private int fuel_consumption;
	private int fuel;
	private int distanceMoved;
	
	public Sports(Track track)
	{
		super(track);
		setAppearance('P');
		fuel = STARTING_FUEL;
		fuel_consumption = CONSUMPTION_RATE;
	}

	public int getFuel()
	{
		return fuel;
	}
	
	public int getStartingFuel() {
		return STARTING_FUEL;
	}

	public int getDistanceMoved()
	{
		return distanceMoved;
	}
	
	public int getFuelConsumption()
	{
		return fuel_consumption;
	}
	
	public void setFuelConsumption(int x)
	{
		fuel_consumption = x;
	}
	
	public void driveNormally()
	{
		distanceMoved = STANDARD_DISTANCE;
	}
}