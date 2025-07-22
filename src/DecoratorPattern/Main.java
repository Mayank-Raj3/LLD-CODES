package DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        TextView text = new PlainTextView("Hello World");

        System.out.print("Plain: ");
        text.render();
        System.out.println();

        System.out.print("Bold: ");
        TextView boldText = new BoldTextDecorator(text);
        boldText.render();
        System.out.println();

        System.out.print("Italic + Underline: ");
        TextView italicUnderline = new UnderLineTextDecorator(new ItalicDecorator(text));
        italicUnderline.render();
        System.out.println();

        System.out.print("Bold + Italic + Underline: ");
        TextView allStyles = new UnderLineTextDecorator(new ItalicDecorator(new BoldTextDecorator(text)));
        allStyles.render();
        System.out.println();
    }
}
