
public abstract class Vehicle implements Refuelable {
    private String name;
    private int speed; //kecepatan dalam km/jam
    private double fuelLevel; //persentase bahan bakar

    public Vehicle(String name, int speed, double fuelLevel) {
        this.name = name;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
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


}
