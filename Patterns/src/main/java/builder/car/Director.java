package builder.car;

public class Director {
    CarBuilder builder;
    void setBuilder(CarBuilder builder){
        this.builder = builder;
    }

    Car BuildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildSpeed();
        return builder.getCar();
    }
}
