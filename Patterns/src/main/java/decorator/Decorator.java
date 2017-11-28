package decorator;

public class Decorator implements IPrinter{
    protected IPrinter printer;

    public Decorator(IPrinter printer){
        this.printer=printer;
    }

    @Override
    public void print() {
        printer.print();
    }
}
