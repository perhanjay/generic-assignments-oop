public class LandVehicle extends Vehicle{
    private int wheels;

    public LandVehicle(String name, int speed, double fuelLevel, int wheels) {
        super(name, speed, fuelLevel);
        this.wheels = (wheels < 0) ? 0 : wheels;
        setDistanceFactor(10);
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = (wheels < 0) ? 0 : wheels;
    }

    @Override
    void move() {
        System.out.println(this.getName() + " is moving in land with " + getWheels()
                            + " wheels at " + getSpeed() + " km/h");
    }


    @Override
    void powerSavingMode(){
        if (!getIsPowerSafe()) {
            System.out.println("Switching " + getName() + " to power safe mode.");
            setPowerSpeedDifference(getSpeed() - getSpeed() * 4/ 5);
            setSpeed(getSpeed() - getPowerSpeedDifference());
            setDistanceFactor(12);
            setIsPowerSafe(true);
        }else {
            System.out.println(getName() + " already in power safe mode.");
        }
    }

    @Override
    void powerSavingModeOff(){
        if (getIsPowerSafe()) {
            System.out.println("Turning " + getName() + " power safe mode off.");
            setSpeed(getSpeed() + getPowerSpeedDifference());
            setDistanceFactor(10);
            setIsPowerSafe(false);
        } else{
            System.out.println(getName() + " already in power mode.");
        }
    }

    @Override
    double calculateFuelConsumption(double distance) {
        double remainingFuel = Math.floor((getFuelLevel() - distance / getDistanceFactor()) * 10) / 10 ;
        double fuelNeeded;
        if (remainingFuel < 0){
            double whenFuelIs0 = getFuelLevel() * getDistanceFactor();
            System.out.println("Your vehicle fuel will reach 0 if travelling for " + distance + "km, refuelling at "+ whenFuelIs0 + "km");
            fuelNeeded = 0 - remainingFuel;
            refuel(fuelNeeded);
            remainingFuel = Math.floor((getFuelLevel() - distance / getDistanceFactor()) * 10) / 10 ;
        } else if (remainingFuel > 100){
            System.out.println("Can't move negative value " + distance + "km. Fuel consumed: 0%");
            return remainingFuel = getFuelLevel();
        }
        setFuelLevel(remainingFuel);
        System.out.println(getName() + " fuel consumption for " + distance + " km is "
                        + (Math.floor((distance / getDistanceFactor()) * 10)/10) + "%. Fuel left: " + remainingFuel + "%");
        return remainingFuel;
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