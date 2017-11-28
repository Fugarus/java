package decorator;

public class RightBracketDecorator  extends Decorator{
    public RightBracketDecorator(IPrinter printer){
        super(printer);
    }

    @Override
    public void print() {
        printer.print();
        System.out.print("]");
    }
}