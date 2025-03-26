//tambahin
public abstract class Vehicle implements Refuelable {
    private String name;
    private int speed; //kecepatan dalam km/jam
    private double fuelLevel; //persentase bahan bakar
    private boolean isPowerSafe;

    public int getDistanceFactor() {
        return distanceFactor;
    }

    public void setDistanceFactor(int distanceFactor) {
        this.distanceFactor = distanceFactor;
    }

    private int distanceFactor = 10;

    public int getPowerSpeedDifference() {
        return powerSpeedDifference;
    }

    public void setPowerSpeedDifference(int powerSpeedDifference) {
        this.powerSpeedDifference = powerSpeedDifference;
    }

    private int powerSpeedDifference;

    public boolean getIsPowerSafe() {
        return isPowerSafe;
    }

    public void setIsPowerSafe(boolean powerSafe) {
        isPowerSafe = powerSafe;
    }

    public Vehicle(String name, int speed, double fuelLevel) {
        this.name = name;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
        this.isPowerSafe = false;
    }

    abstract void powerSavingMode();
    abstract void powerSavingModeOff();



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


}
