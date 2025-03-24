public class WaterVehicle extends Vehicle{

    private boolean hasPropeler;

    public WaterVehicle(String name, int speed, double fuelLevel, boolean hasPropeler) {
        super(name, speed, fuelLevel);
        this.hasPropeler = hasPropeler;
    }

    public boolean getHasPropeler() {
        return hasPropeler;
    }

    public void setHasPropeler(boolean hasPropeler) {
        this.hasPropeler = hasPropeler;
    }

    void move() {
        String propelerOrNot = getHasPropeler() ? "propeler" : "no Propeler";
        System.out.println(this.getName() + " is moving at water with " + propelerOrNot + " at " + getSpeed() + " km/h");
    }

    @Override
    double calculateFuelConsumption(double distance) {
        System.out.print(getName() + " fuel consumption for " + distance + " km is " + distance / 8 + "%. Fuel left: ");
        double fuelConsumed = getFuelLevel() - distance / 8 ;
        setFuelLevel(fuelConsumed);
        System.out.println(fuelConsumed);
        return fuelConsumed;
    }

    @Override
    public void refuel(double amount){
        if (amount < 0) {
            System.out.println("Your attempt at refueling " + getName() + " failed. Your fuel can has a hole...");
        } else if (getFuelLevel() + amount < 100){
            setFuelLevel(getFuelLevel() + amount);
            System.out.println("Adding " + amount + "% of fuel to "+ getName()+ ". Your fuel is now at " + getFuelLevel() + "%");
        } else {
            setFuelLevel(100);
            System.out.println("Amount of fuel to add exceeds 100% capacity.");
        }
    }

    @Override
    public boolean isFuelLow(){
        if (getFuelLevel() < 20) {
            System.out.println("Your "  + getName()+ " fuel is low at " + getFuelLevel() + "% !!!");
            return true;
        } else {
            System.out.println("Relax, your " + getName() + " fuel is at " + getFuelLevel() + "%");
            return false;
        }
    }
}