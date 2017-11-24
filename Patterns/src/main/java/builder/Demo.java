package builder;

public class Demo {
    public static void main(String[] args) {
        Chef chef = new Chef();
        MenuBuilder builder = new MenuBuilder();
        chef.setKidsMenu(builder);

        Menu kidsMenu = builder.getMenu();
        System.out.println(kidsMenu);
    }
}
