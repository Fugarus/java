package director;

import components.Engine;
import components.GPSNavigator;
import builders.Builder;
import components.TripComputer;

/**
 * Директор знает в какой последовательности заставлять работать строителя. Он
 * работает с ним через общий интерфейс Строителя. Из-за этого, он может не
 * знать какой конкретно продукт сейчас строится.
 */
public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setGPSNavigator(new GPSNavigator());
    }
}