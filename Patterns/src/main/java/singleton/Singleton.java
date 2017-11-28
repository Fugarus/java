package singleton;


public final class Singleton {
    private static volatile Singleton instance;
    private static String value;

    private Singleton(String value) {
        System.out.println("Create new singleton with value = "+value);
        this.value =value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }

    public String getValue(){
        return value;
    }
}