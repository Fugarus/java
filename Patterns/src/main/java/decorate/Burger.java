package decorate;

public class Burger {
    private String components = "Burger: ";
    private int cost = 100;

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return components;
    }
}
