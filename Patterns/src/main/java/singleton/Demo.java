package singleton;

public class Demo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("First");
        System.out.println(singleton.getValue());

        Singleton singleton1 = Singleton.getInstance("Second");
        System.out.println(singleton1.getValue());
    }
}

/* Output:
Create new singleton with value = First
First
First*/

