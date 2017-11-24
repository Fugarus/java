package adapter;

public class Demo {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.quack();

        Chicken chicken = new Chicken();
        chicken.squeak();

        ChickenToDuckAdapter duck1 = new ChickenToDuckAdapter(chicken);
        duck1.quack();

        DuckToChickenAdapter chicken1 = new DuckToChickenAdapter(duck);
        chicken1.squeak();
    }
}
