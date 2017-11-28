package builder.car;

public class Car {
    private Transmission transmission = Transmission.MANUAL;
    private String make = "Default";
    private int speed = 100;

    @Override
    public String toString() {
        return "Make: " + make + "\nSpeed: " + speed + "\nTransmission: " + transmission;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
