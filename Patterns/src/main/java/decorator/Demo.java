package decorator;

public class Demo {
    public static void main(String[] args) {
        IPrinter printer = new Printer("Hello");
        printer.print();
        System.out.println();

        printer = new QuotesDecorator(new Printer("Hello"));
        printer.print();
        System.out.println();

        printer = new QuotesDecorator(new LeftBracketDecorator(new Printer("Hello")));
        printer.print();
        System.out.println();

        printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello")));
        printer.print();
        System.out.println();

        printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello")));
        printer = new QuotesDecorator(printer);
        printer.print();
        System.out.println();
    }
}
