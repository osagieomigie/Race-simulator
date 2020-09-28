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
	
	public void move (String driveMode)
    {
		if (driveMode.equals("normal")) {
			consumeFuel(CONSUMPTION_RATE);
		}else consumeFuel(CONSUMPTION_RATE+1); // suv consumes more in awd mode 
       
       System.out.println("Current fuel: " + fuel);
       
       // print consumption rate 
       if (driveMode.equals("normal")) {
    	   System.out.println("Fuel use: " + CONSUMPTION_RATE);
		}else {
			int tmp = CONSUMPTION_RATE+1;
			System.out.println("Fuel use: " + tmp); // suv consumes more in awd mode 
		}
       
//       if (driveMode.equals("normal")){
//    	   return normalDrive(); 
//       }else {
//    	   return awd();
//       }
    }

	public int getDistance()
	{
		return distanceMoved;
	}
	
	public int consumptionRate(String driveMode) {
		if (driveMode.equals("normal"))return CONSUMPTION_RATE;
		
		return CONSUMPTION_RATE+1;
	}
}