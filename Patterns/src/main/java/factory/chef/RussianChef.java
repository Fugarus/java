package factory.chef;

import decorate.ChickenBurger;
import decorate.ComponentCheese;
import decorate.ComponentSalad;
import menu.Breakfast;
import menu.Dinner;

public class RussianChef extends Chef {

    public RussianChef(){
        super();
        setBreakfast();
        setDinner();
    }

    @Override
    public void setDinner() {
        dinner.addDessert("CandySweet")
                .addDrink("Bear")
                .addGarnish(new ComponentCheese(new ComponentSalad(new ChickenBurger())).buildBurger().toString())
                .addSalad("Oliv'e");
    }

    @Override
    public void setBreakfast() {
        breakfast.addDessert("Cookies").addDrink("Coffee").addGarnish("Eggs");

    }

    @Override
    public Dinner getDinner() {
        return super.getDinner();
    }

    @Override
    public Breakfast getBreakfast() {
        return super.getBreakfast();
    }
}
