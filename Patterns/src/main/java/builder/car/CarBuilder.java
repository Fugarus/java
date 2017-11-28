package builder.car;

public abstract class CarBuilder {
    protected Car car;
    void createCar(){
        car = new Car();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildSpeed();

    Car getCar(){return car;}
}
