package factory.chef;

import menu.Breakfast;
import menu.Dinner;

public class Chef implements IChef {
    protected Breakfast breakfast = new Breakfast();
    protected Dinner dinner = new Dinner();
    protected Chef(){
    }

    @Override
    public void setDinner() {
    }

    @Override
    public void setBreakfast() {
    }

    @Override
    public Dinner getDinner() {
        return dinner;
    }

    @Override
    public Breakfast getBreakfast() {
        return breakfast;
    }

    @Override
    public void printDinner(){
        System.out.println(dinner);
    }

    @Override
    public void printBreakfast(){
        System.out.println(breakfast);
    }
}
