import decorate.*;
import factory.Kitchen;
import factory.TypeKitchen;
import factory.chef.IChef;

public class Demo {
    public static void main(String[] args) {
        // Decorator
        Burger burger = new ComponentCheese(new ComponentSalad(new ChickenBurger())).buildBurger();
        System.out.println(burger);
        new ComponentCheese(new ChickenBurger());
        // Builder + Singleton + Factory + Adapter + Decorator
        IChef russianChef = Kitchen.getInstance().getKitchen(TypeKitchen.RUSSIAN_KITCHEN);
        russianChef.printDinner();
        russianChef = Kitchen.getInstance().getKitchen(TypeKitchen.RUSSIAN_KITCHEN);


        Kitchen.getInstance().getKitchen(TypeKitchen.BASE64_KITCHEN).printBreakfast();
    }
}
