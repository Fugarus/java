package transports;

import components.Engine;
import components.GPSNavigator;
import components.TripComputer;

public class Ship extends Transports{
    public Ship(int seats, Engine engine, TripComputer tripComputer, GPSNavigator gpsNavigator) {
        super(seats, engine, tripComputer, gpsNavigator, Type.SHIP);
    }

    @Override
    public void setFuel(double fuel) {
        super.setFuel(fuel);
    }
}
