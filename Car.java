/*
  Features:
  * Tracks and manages information for appearance and fuel capacity.
 */

public abstract class Car
{
    protected static final int STARTING_FUEL = 40;
    protected static final int STANDARD_DISTANCE = 2;
    protected static final int CONSUMPTION_RATE = 2;

    private char appearance;
    protected int fuel;

    private Track track;

    public Car(Track track)
    {
        setAppearance('c');
        fuel = STARTING_FUEL;

        this.track = track;
    }
    
    public int getStartingFuel() {
    	return STARTING_FUEL;
    }
    
    public int getStandardDistance() {
    	return STANDARD_DISTANCE; 
    }
    
    public int getConsumptionRate() {
    	return CONSUMPTION_RATE; 
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

    // Allows external queries of the fuel state of a particular car.
    public boolean isEmpty()
    {
       if (fuel <= 0)
           return true;
       else
           return false;
    }

    // Car internally knows how much fuel to use and how far to move. However the 
    // actual movement in the virtual track must be done by another class hence
    // this method must communicate to the caller how far it moves.


    // If this method is overriden then all child class methods must also display
    // the same debugging messages shown below.
    public void move (String driveMode)
    {
       printCurrentFuel(driveMode);
       printFuelConsumption(driveMode);
    }
    
    public abstract void printFuelConsumption(String driveMode);
    
    public abstract void printCurrentFuel(String driveMode);

    public void setAppearance (char anAppearance)
    {
       appearance = anAppearance;
    }

    public void setFuel (int newFuel)
    {
       if (newFuel < 0)
           System.out.println("Fuel cannot be set to a negative value");
       else
           fuel = newFuel;
    }

    public String toString() 
    {
       String s = "";
       s = s + appearance;
       return s;
    }
}