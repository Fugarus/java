package project.steam.model;

public class Game {
    private String name;
    private int discountPercentage;
    private double finalPrice;

    public Game(String name,int discountPercentage, double finalPrice){
        this.name=name;
        this.discountPercentage=discountPercentage;
        this.finalPrice=finalPrice;
    }

    public String getName() {
        return name;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
