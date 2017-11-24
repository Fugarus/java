package adapter;

public class ChickenToDuckAdapter implements IDuck {
    private Chicken chicken;

    public ChickenToDuckAdapter(Chicken chicken){
        this.chicken=chicken;
    }

    @Override
    public void quack() {
        chicken.squeak();
    }
}
