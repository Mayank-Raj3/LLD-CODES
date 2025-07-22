package DecoratorPattern;

public abstract class TextViewDecorator implements TextView{
    protected TextView textView;
    public TextViewDecorator(TextView textView) {
        this.textView = textView;
    }

}
