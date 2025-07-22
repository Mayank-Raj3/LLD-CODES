package DecoratorPattern;


public class UnderLineTextDecorator extends TextViewDecorator{

    public UnderLineTextDecorator(TextView textView) {
        super(textView);
    }
    @Override
    public void render() {
        System.out.println("<u>");
        textView.render();
        System.out.println("</u>");
    }
}
