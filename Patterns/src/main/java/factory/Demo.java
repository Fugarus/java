package factory;

public class Demo {
    public static void main(String[] args) {
        IWatchMaker watchMaker = getMakerByName("Digital");  //new ReverseWatchMaker();
        IWatch watch = watchMaker.createWatch();
        watch.showTime();

        watchMaker = getMakerByName("Reverse");
        watch = watchMaker.createWatch();
        watch.showTime();
    }

    public static IWatchMaker getMakerByName(String name){
        if(name.equals("Digital")){
            return new DigitalWatchMaker();
        } else if (name.equals("Reverse")) {
            return new ReverseWatchMaker();
        }

        throw new RuntimeException("Maker name is invalid");
    }
}
