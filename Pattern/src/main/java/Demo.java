import builders.CarBuilder;
import transports.Car;
import director.Director;

/**
 * Демо-класс. Здесь всё сводится воедино.
 */
public class Demo {

    public static void main(String[] args) {
//        Director director = new Director();
//
//        // Директор получает объект конкретного строителя от клиента
//        // (приложения). Приложение само знает какой строитель использовать,
//        // чтобы получить нужный продукт.
//        CarBuilder builder = new CarBuilder();
//        director.constructSportsCar(builder);
//
//        // Готовый продукт возвращает строитель, так как Директор чаще всего не
//        // знает и не зависит от конкретных классов строителей и продуктов.
//        Car car = builder.getResult();
//        System.out.println("Car built:\n" + car.getEngine());
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println(car.printAllInfo());
        car.getFuelLevel();


    }

}