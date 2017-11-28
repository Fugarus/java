package decorator;

public class LeftBracketDecorator extends Decorator{

    public LeftBracketDecorator(IPrinter printer){
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("[");
        printer.print();
    }
}
