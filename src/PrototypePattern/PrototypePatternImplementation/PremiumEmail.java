package PrototypePattern.PrototypePatternImplementation;

public class PremiumEmail extends Email {
    String cc ;
    String bcc;

    PremiumEmail(String senderEmail, String receiverEmail, String subject, String body, String cc ,String bcc){
        super(senderEmail, receiverEmail, subject, body);
        this.cc = cc;
        this.bcc = bcc;
    }

    // Here we cant just make copy constructor as it violates OCP we will Implement Prototype Interface or Cloneable

    PremiumEmail(PremiumEmail email){
        super(email); //copy constructor of Email
        this.cc = email.cc;
        this.bcc = email.bcc;
    }

    @Override //of Prototype Interface
    public PremiumEmail clone(){
        return new PremiumEmail(this);
    }


}
