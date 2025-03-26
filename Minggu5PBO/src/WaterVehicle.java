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
    void powerSavingMode(){
        if (!getIsPowerSafe()) {
            //reduce the power usage of given vehicle
            System.out.println("Switching " + getName() + " to power safe mode.");
            setPowerSpeedDifference(getSpeed() - getSpeed() * 4/ 5);
            setSpeed(getSpeed() - getPowerSpeedDifference());
            setDistanceFactor(10);
            setIsPowerSafe(true);
        }else {
            System.out.println(getName() + " already in power safe mode.");
        }
    }

    @Override
    void powerSavingModeOff() {
        if (getIsPowerSafe()) {
            System.out.println("Turning " + getName() + " power safe mode off.");
            setSpeed(getSpeed() + getPowerSpeedDifference());
            setDistanceFactor(8);
            setIsPowerSafe(false);
        } else {
            System.out.println(getName() + " already in power mode.");
        }
    }

    @Override
    double calculateFuelConsumption(double distance) {
        double fuelConsumed = getFuelLevel() - distance / getDistanceFactor() ;
        double actualValue;
        if (fuelConsumed < 0){
            System.out.println("Your vehicle fuel will reach 0 if travelling for " + distance + "km, refuelling now");
            actualValue = 0 - fuelConsumed;
            refuel(actualValue);
            fuelConsumed = getFuelLevel() - distance / getDistanceFactor() ;
        }else if (fuelConsumed > 100){
            System.out.println("Can't move negative value " + distance + "km. Fuel consumed: 0");
            return fuelConsumed = getFuelLevel();
        }
        setFuelLevel(fuelConsumed);
        System.out.println(getName() + " fuel consumption for " + distance + " km is "
                + (distance / getDistanceFactor()) + "%. Fuel left: " + fuelConsumed + "%");
        return fuelConsumed;
    }

    @Override
    public void refuel(double amount){
        if (amount < 0) {
            System.out.println("Your attempt at refueling " + getName() + " failed. Your fuel can has a hole...");
        } else if (getFuelLevel() + amount < 100){
            setFuelLevel(getFuelLevel() + amount);
            System.out.println("Adding " + amount + "% of fuel to "+ getName()
                                + ". Your fuel is now at " + getFuelLevel() + "%");
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