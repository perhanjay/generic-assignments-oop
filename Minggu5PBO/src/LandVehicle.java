public class LandVehicle extends Vehicle{

    private int wheels;

    public LandVehicle(String name, int speed, double fuelLevel, int wheels) {
        super(name, speed, fuelLevel);
        this.wheels = (wheels < 0) ? 0 : wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = (wheels < 0) ? 0 : wheels;
    }

    @Override
    void move() {
        System.out.println(this.getName() + " is moving in land with " + getWheels() + " wheels at " + getSpeed() + " km/h");
    }

    @Override
    double calculateFuelConsumption(double distance) {
        System.out.print(getName() + " fuel consumption for " + distance + " km is " + distance / 10 + "%. Fuel left: ");
        double fuelConsumed = getFuelLevel() - distance / 10 ;
        setFuelLevel(fuelConsumed);
        System.out.println(fuelConsumed + "%");
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