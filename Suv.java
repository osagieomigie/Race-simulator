public class Suv extends Car
{
	private static final int CONSUMPTION_RATE = 3;
	private int STARTING_FUEL = 50;
	private int distanceMoved;

	public Suv(Track track)
	{
		super(track);
		setAppearance('V');
		setFuel(STARTING_FUEL);
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
}