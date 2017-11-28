package builder.food;

public class MenuBuilder implements IMenu {
    private String soup ="";
    private String salad ="";
    private String garnish ="";
    private String dessert ="";
    private String drink ="";

    @Override
    public void addSoup(String item) {
        this.soup=item;
    }

    @Override
    public void addSalad(String item) {
        this.salad=item;
    }

    @Override
    public void addGarnish(String item) {
        this.garnish=item;
    }

    @Override
    public void addDessert(String item) {
        this.dessert=item;
    }

    @Override
    public void addDrink(String item) {
        this.drink=item;
    }

    public Menu getMenu(){
        return new Menu(soup, salad, garnish, dessert, drink);
    }
}
