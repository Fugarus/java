package factory.chef;

import menu.Breakfast;
import menu.Dinner;

public interface IChef {
    void setDinner();
    void setBreakfast();

    Dinner getDinner();
    Breakfast getBreakfast();

    void printDinner();
    void printBreakfast();
}
