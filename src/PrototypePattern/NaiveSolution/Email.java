package PrototypePattern.NaiveSolution;

public class Email {
    String senderEmail ;
    String receiverEmail ;
    String subject;
    String body;
    public Email(){

    }
    public Email(String senderEmail, String receiverEmail, String subject, String body) {
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.body = body;
    }
    /**
     * One Solution for Copying Object Is to make copy Constructor
     * When we are passing Email parameter the Second Constructor is getting Overloading
     * this is constructor Overloading
     * which makes this as copy constructor
     */
    Email (Email email) {
        this.senderEmail = email.senderEmail;
        this.receiverEmail = email.receiverEmail;
        this.subject = email.subject;
        this.body = email.body;
    }


    public void displayEmail(){
        System.out.println("******************");
        System.out.println("Sender Email: " + senderEmail);
        System.out.println("Receiver Email: " + receiverEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("******************");
    }

    //Getters Setters
    public String getSenderEmail() {
        return senderEmail;
    }
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
    public String getReceiverEmail() {
        return receiverEmail;
    }
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }


}
