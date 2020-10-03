public class Truck extends Car 
{
	private static final int STANDARD_DISTANCE = 3;
	private static final int STARTING_FUEL = 60;
	private static final int CONSUMPTION_RATE = 4;
	
	private int fuel_consumption;
	private int fuel;
	private int distanceMoved;
	
	public Truck(Track track)
	{
		super(track);
		setAppearance('T');
		fuel = STARTING_FUEL;
		fuel_consumption = CONSUMPTION_RATE;
	}

	public int getFuel()
	{
		return fuel;
	}

	public int getDistanceMoved()
	{
		return STANDARD_DISTANCE;
	}
	
	public int getStartingFuel() {
		return STARTING_FUEL;
	}
	
	public int getFuelConsumption()
	{
		return fuel_consumption;
	}
	
	public void setFuelConsumption(int x)
	{
		fuel_consumption = x;
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
	
	public int move()
    {
		consumeFuel(CONSUMPTION_RATE);
		System.out.println("Current fuel: " + fuel);
       
       // print consumption rate 
		System.out.println("Fuel use: " + CONSUMPTION_RATE);
		
		return STANDARD_DISTANCE;
    }
	
	public int consumptionRate() {
		return CONSUMPTION_RATE;
	}
}