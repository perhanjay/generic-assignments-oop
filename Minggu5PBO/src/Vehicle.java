//tambahin
public abstract class Vehicle implements Refuelable {
    private String name;
    private int speed;
    private double fuelLevel;
    private boolean isPowerSafe;
    private int powerSpeedDifference;
    private int distanceFactor;

    public Vehicle(String name, int speed, double fuelLevel) {
        this.name = name;
        this.speed = (speed < 0) ? 0 : speed;
        this.fuelLevel = (fuelLevel < 0) ? 0 : fuelLevel;
        this.isPowerSafe = false;
    }

    public int getDistanceFactor() {
        return distanceFactor;
    }

    public void setDistanceFactor(int distanceFactor) {
        this.distanceFactor = distanceFactor;
    }


    public int getPowerSpeedDifference() {
        return powerSpeedDifference;
    }

    public void setPowerSpeedDifference(int powerSpeedDifference) {
        this.powerSpeedDifference = powerSpeedDifference;
    }

    public boolean getIsPowerSafe() {
        return isPowerSafe;
    }

    public void setIsPowerSafe(boolean powerSafe) {
        isPowerSafe = powerSafe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = (speed < 0) ? 0 : speed;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = (fuelLevel < 0) ? 0 : fuelLevel;
    }

    abstract void move();
    abstract double calculateFuelConsumption(double distance    );
    abstract void powerSavingMode();
    abstract void powerSavingModeOff();

}
