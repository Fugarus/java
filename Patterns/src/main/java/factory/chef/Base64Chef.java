package factory.chef;

import menu.Breakfast;
import menu.Dinner;

import java.util.Base64;

public class Base64Chef extends Chef {
    public Base64Chef(){
        super();
        setBreakfast();
        setDinner();
    }

    @Override
    public void setDinner() {
        dinner.addDessert("Rmxhc2hjYXJkcw==").addDrink("VGVhcnMgb2YgdGhlIHN5c3RlbSBhZG1pbmlzdHJhdG9y").addGarnish("RGlza2V0dGU=").addSalad("MiBib2x0cw==");
    }

    @Override
    public void setBreakfast() {
        breakfast.addDessert("QnJva2VuIHByaW50ZXI=").addDrink("VGhlIGJyYWlucyBvZiB0aGUgc2VjcmV0YXJ5");
    }

    @Override
    public Dinner getDinner() {
        return super.getDinner();
    }

    @Override
    public Breakfast getBreakfast() {
        return super.getBreakfast();
    }

    @Override
    public void printDinner(){
        System.out.println(adapter(dinner.toString()));
    }

    @Override
    public void printBreakfast(){
        System.out.println(adapter(breakfast.toString()));
    }

    private String adapter(String menu){
        int end=menu.length();
        int start = end-1;
        while(true){
            end = menu.lastIndexOf("\n", end);
            start = menu.lastIndexOf(": ", end);
            if(start==-1 || end==-1)
                break;
            String template = menu.substring(start+2,end--);
            end=start-1;
            menu = menu.replace(template, new String(Base64.getDecoder().decode(template)));
        }
        return menu;
    }
}
