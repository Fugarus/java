package builder;

public class Menu{
    private String soup ="";
    private String salad ="";
    private String garnish ="";
    private String dessert ="";
    private String drink ="";

    public Menu(String soup, String salad, String garnish, String dessert, String drink){
        this.soup=soup;
        this.salad=salad;
        this.garnish=garnish;
        this.dessert=dessert;
        this.drink=drink;
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
