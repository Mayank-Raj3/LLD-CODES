package DecoratorPattern;

public class ItalicDecorator extends TextViewDecorator{
    public ItalicDecorator(TextView textView) {
        super(textView);
    }
    @Override
    public void render() {
        System.out.println("<i>");
        textView.render();
        System.out.println("</i>");
    }
}
