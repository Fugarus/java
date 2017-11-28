package decorator;

public class QuotesDecorator extends Decorator {
    public QuotesDecorator(IPrinter printer){
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("\"");
        printer.print();
        System.out.print("\"");
    }
}
