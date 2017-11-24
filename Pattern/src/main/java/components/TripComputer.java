package components;

import transports.Car;

/**
 * Одна из фишек автомобиля.
 */
public class TripComputer {

    public void condition(Engine engine) {
        if (engine.isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }

    public void fuelLevel(double fuel) {
        System.out.println("Level of fuel - " + fuel);
    }
}