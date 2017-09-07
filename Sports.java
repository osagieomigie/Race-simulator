public class Sports extends Car 
{
	public static final int STANDARD_DISTANCE = 3;
	public static final int STARTING_FUEL = 30;
	
	private int fuel_consumption;
	private int fuel;
	private int distanceMoved;
	
	public Sports(Track track)
	{
		super(track);
		setAppearance('P');
		fuel = STARTING_FUEL;
		fuel_consumption = super.CONSUMPTION_RATE;
	}

	public int getFuel()
	{
		return fuel;
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