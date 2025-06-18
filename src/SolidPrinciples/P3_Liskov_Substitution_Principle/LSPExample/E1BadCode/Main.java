package SolidPrinciples.P3_Liskov_Substitution_Principle.LSPExample.E1BadCode;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<CreditCard> cards = new ArrayList<>();
        for(CreditCard it : cards){
            if(it instanceof RupayCard ){
                it.upiPayment(); // bad method as we are exposing the implementation of rupayCard
            }
        }

    }
}
