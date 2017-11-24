package builders;
import components.Engine;
import components.GPSNavigator;
import components.TripComputer;

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги
 * конфигурации продукта.
 */
public interface Builder {
    public void setSeats(int seats);
    public void setEngine (Engine engine);
    public void setTripComputer(TripComputer tripComputer);
    public void setGPSNavigator(GPSNavigator gpsNavigator);
}