package factory.chef;

import menu.Breakfast;
import menu.Dinner;

public class JapanChef extends Chef {

    public JapanChef(){
        super();
        setBreakfast();
        setDinner();
    }

    @Override
    public void setDinner() {
        dinner.addDessert("JapanSugar").addDrink("JapanMilk").addGarnish("Rice").addSalad("megaRice");
    }

    @Override
    public void setBreakfast() {
        breakfast.addDessert("IceCream").addDrink("Tea").addGarnish("Eggs");
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
