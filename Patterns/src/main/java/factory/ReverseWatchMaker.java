package factory;

public class ReverseWatchMaker implements IWatchMaker {
    @Override
    public IWatch createWatch() {
        return new ReverseWatch();
    }
}
