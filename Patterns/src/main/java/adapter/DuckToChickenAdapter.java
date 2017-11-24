package adapter;

public class DuckToChickenAdapter implements IChicken {
    private Duck duck;

    public DuckToChickenAdapter(Duck duck){
        this.duck=duck;
    }

    @Override
    public void squeak() {
        duck.quack();
    }
}
