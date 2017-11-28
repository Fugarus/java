package builder.car;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new HondaBuilder());
        Car car = director.BuildCar();
        System.out.println(car);
    }
}
