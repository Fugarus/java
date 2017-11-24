package decorate;

public class ChickenBurger implements IComponent{
     @Override
    public Burger addComponent(Burger burger) {
        burger.setComponents(burger.getComponents() + "with chicken ");
        burger.setCost(burger.getCost()+10);
        return burger;
    }
}
