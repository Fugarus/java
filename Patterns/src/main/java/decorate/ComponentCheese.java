package decorate;

public class ComponentCheese extends DecoratorBurger{

    public ComponentCheese(IComponent iComponent) {
        super(iComponent);
    }

    @Override
    public Burger addComponent(Burger burger){
        burger.setComponents(burger.getComponents() + "with cheese ");
        burger.setCost(burger.getCost()+5);
        return super.addComponent(burger);
    }
}
