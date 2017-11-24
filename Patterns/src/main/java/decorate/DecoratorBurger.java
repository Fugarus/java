package decorate;

public class DecoratorBurger implements IComponent{
    protected IComponent component;

    public DecoratorBurger (IComponent iComponent){
        this.component = iComponent;
    }

    @Override
    public Burger addComponent(Burger burger) {
        return component.addComponent(burger);
    }

    public Burger buildBurger(){
        return addComponent(new Burger());
    }
}
