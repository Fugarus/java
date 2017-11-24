package factory;

import factory.chef.Base64Chef;
import factory.chef.IChef;
import factory.chef.JapanChef;
import factory.chef.RussianChef;

import java.util.HashMap;
import java.util.Map;

public class Kitchen {
    private static Map<TypeKitchen,IChef> chefs = new HashMap<>();
    private  static volatile Kitchen instance;
    private String message = "Why do you need a new cook? You don't love him.";
    private Kitchen(){}

    public static Kitchen getInstance(){
        if(instance==null) {
            synchronized (Kitchen.class) {
                if (instance == null) {
                    instance = new Kitchen();
                }
            }
        }
        return instance;
    }

    public IChef getKitchen(TypeKitchen typeKitchen){
        IChef chef = null;
        switch (typeKitchen){
            case JAPAN_KITCHEN:
                chef = chefs.get(typeKitchen);
                if(chef==null) chef = new JapanChef(); else System.out.println(message);
                chefs.put(typeKitchen, chef);
                break;
            case RUSSIAN_KITCHEN:
                chef = chefs.get(typeKitchen);
                if(chef==null) chef = new RussianChef(); else System.out.println(message);
                chefs.put(typeKitchen, chef);
                break;
            case BASE64_KITCHEN:
                chef = chefs.get(typeKitchen);
                if(chef==null) chef = new Base64Chef(); else System.out.println(message);
                chefs.put(typeKitchen, chef);
                break;
        }
        return chef;
    }
}
