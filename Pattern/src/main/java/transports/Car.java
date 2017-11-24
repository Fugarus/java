package transports;


import components.Engine;
import components.GPSNavigator;
import components.TripComputer;

/**
 * Автомобиль — это класс продукта.
 */
public class Car extends Transports{
    private double fuel = 0;

    public Car(int seats, Engine engine, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        super(seats, engine, tripComputer, gpsNavigator, Type.CAR);
    }

    @Override
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}