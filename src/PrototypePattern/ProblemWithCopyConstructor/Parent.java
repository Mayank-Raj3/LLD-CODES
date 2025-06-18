package PrototypePattern.ProblemWithCopyConstructor;

//parentclass
public class Parent {
    String Property1 ;
    String Property2 ;
    String Property3 ;

    public Parent(String Property1, String Property2, String Property3){
        this.Property1 = Property1;
        this.Property2 = Property2;
        this.Property3 = Property3;
    }

    public Parent(Parent parent){
        this.Property1 = parent.Property1;
        this.Property2 = parent.Property2;
        this.Property3 = parent.Property3;
    }

    //Getter Setters

}
