package DecoratorPattern;

public class BoldTextDecorator extends TextViewDecorator{

    public BoldTextDecorator(TextView textView) {
        super(textView);
    }
    @Override
    public void render() {
        System.out.println("<b>");
        textView.render();
        System.out.println("</b>");
    }
}
