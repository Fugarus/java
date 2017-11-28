package decorator;

public class Printer implements IPrinter {
    private String value;

    public Printer(String value){
        this.value=value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
}
