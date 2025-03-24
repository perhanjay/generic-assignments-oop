public class LandVehicle extends Vehicle implements Refuelable {

    public LandVehicle(String name, int speed, double fuelLevel) {
        super(name, speed, fuelLevel);
    }

    void move() {
        System.out.println("Land Vehicle is moving");
    }

    double calculateFuelConsumption(double distance) {
        double fuelConsumed = getFuelLevel() - distance / 10 ;
        setFuelLevel(fuelConsumed);
        return fuelConsumed;
    }

    public void refuel(double amount){
        if (getFuelLevel() + amount < 100){
            setFuelLevel(getFuelLevel() + amount);
        } else {
            setFuelLevel(100);
            System.out.println("Amount of fuel to add exceeds 100");
        }
    }

    public boolean isFuelLow(){
        if (getFuelLevel() < 20) {
            return true;
        } else {
            return false;
        }
    }
}