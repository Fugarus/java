package builder.car;

public class FordBuilder extends CarBuilder{
    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildSpeed() {
        car.setSpeed(240);
    }
}
