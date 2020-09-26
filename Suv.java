public class Suv extends Car
{
	public static final int CONSUMPTION_RATE = 3;
	private int STARTING_FUEL = 50;

	private int fuel;
	private int fuel_consumption;
	private int distanceMoved;

	public Suv(Track track)
	{
		super(track);
		setAppearance('V');
		fuel = STARTING_FUEL;
		fuel_consumption = CONSUMPTION_RATE;
	}

	public int normalDrive()
	{
		distanceMoved = STANDARD_DISTANCE;
		return distanceMoved;
	}

	public int awd()
	{
		distanceMoved = STANDARD_DISTANCE + 1; 
		return distanceMoved;
	}

	public int getFuelConsumption()
	{
		return fuel_consumption;
	}
	
	protected void consumeFuel(int amount)
    {
       if (amount < 0)
           fuel = 0;
       else { // only move to the next distance if there is enough fuel 
    	   int tmpFuel = fuel - amount;
    	   if (tmpFuel > 0) {
    		   fuel = tmpFuel; 
    	   }
           
       }
    }
	
	public int getFuel()
    {
       return fuel;
    }
	
	public int move (String driveMode)
    {
       consumeFuel(CONSUMPTION_RATE);
       System.out.println("Current fuel: " + fuel);
       System.out.println("Fuel use: " + CONSUMPTION_RATE);
       return driveMode.equals("normal") ? normalDrive(): awd();
    }


//	public void printStats() {
//		// System.out.println("Blizzard hits and car spins its wheels");
//		// System.out.println("Blizzard hits and but Suv moves slowly but surely in AWD mode");
//		System.out.println("Current fuel: " + getFuel());
//		System.out.println("Fuel use: " + getFuelConsumption());
//		System.out.println("Distance SUV moved: " + distanceMoved);
//	}


	/*public void setDistance(int x)
	{
		distanceMoved = x;
	}*/

	public int getDistance()
	{
		return distanceMoved;
	}
	
	public int consumptionRate() {
		return CONSUMPTION_RATE;
	}
}