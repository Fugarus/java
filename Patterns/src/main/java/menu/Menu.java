package menu;

public class Menu {
    private String soup ="";
    private String salad ="";
    private String garnish ="";
    private String dessert ="";
    private String drink ="";

    public Menu addSoup(String item){
        this.soup = item;
        return this;
    }

    public Menu addSalad(String item){
        this.salad = item;
        return this;
    }

    public Menu addGarnish(String item){
        this.garnish = item;
        return this;
    }

    public Menu addDessert(String item){
        this.dessert = item;
        return this;
    }

    public Menu addDrink(String item){
        this.drink = item;
        return this;
    }

    @Override
    public String toString() {
        return checkAndGetMenu("Salad", salad) +
                checkAndGetMenu("Drink", drink) +
                checkAndGetMenu("Dessert", dessert) +
                checkAndGetMenu("Garnish", garnish) +
                checkAndGetMenu("Soup", soup);
    }

    public String checkAndGetMenu(String type, String item){
        if (item.length() != 0)
            return String.format("%s: %s\n", type, item);
        return "";
    }
}
