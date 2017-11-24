package transports;

import components.*;

public abstract class Transports extends Components implements HelpfulInfo{
    private final Type type;
    private final int seats;
    private final Engine engine;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Transports(int seats, Engine engine, TripComputer tripComputer, GPSNavigator gpsNavigator, Type type) {
        this.seats = seats;
        this.engine = engine;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
        this.type = type;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public Type getType() {
        return type;
    }

    public String printAllInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Type of transport: " + type + "\n");
        info.append("Count of seats: " + seats + "\n");
        info.append("Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n");
        info.append("Trip Computer: Trip Computer" + "\n");
        info.append("GPS Navigator: " + gpsNavigator.toString() + "\n");
        return info.toString();
    }

    @Override
    public String getFuelLevel() {
        tripComputer.fuelLevel(fuel);
        return "";
    }
}
