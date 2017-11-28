package builder.car;

public class HondaBuilder extends CarBuilder{
    @Override
    void buildMake() {
        car.setMake("Honda Accord");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(220);
    }
}
