package builder.food;

public class Chef {
    public void setKidsMenu(MenuBuilder builder){
        builder.addDessert("IceCream");
        builder.addDrink("Cola");
        builder.addGarnish("Eggs");
    }

    public void setBreakFastMenu(MenuBuilder builder){
        builder.addDrink("Tea");
        builder.addGarnish("Rice");
        builder.addDessert("Cooks");
        builder.addSalad("Salad");
    }
}
