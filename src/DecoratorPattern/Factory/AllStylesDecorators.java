package DecoratorPattern.Factory;

import DecoratorPattern.BoldTextDecorator;
import DecoratorPattern.ItalicDecorator;
import DecoratorPattern.TextView;
import DecoratorPattern.UnderLineTextDecorator;

public class AllStylesDecorators {

    public static TextView Allstyless(TextView text){
        return  new UnderLineTextDecorator(new ItalicDecorator(new BoldTextDecorator(text)));
    }
}
