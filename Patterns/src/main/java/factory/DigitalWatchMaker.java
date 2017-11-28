package factory;

public class DigitalWatchMaker implements IWatchMaker {
    @Override
    public IWatch createWatch() {
        return new DigitalWatch();
    }
}
