package decorate;

public class ComponentSalad extends DecoratorBurger{

    public ComponentSalad(IComponent iComponent) {
        super(iComponent);
    }

    @Override
    public Burger addComponent(Burger burger){
        burger.setComponents(burger.getComponents() + "with salad ");
        burger.setCost(burger.getCost()+6);
        return super.addComponent(burger);
    }
}
