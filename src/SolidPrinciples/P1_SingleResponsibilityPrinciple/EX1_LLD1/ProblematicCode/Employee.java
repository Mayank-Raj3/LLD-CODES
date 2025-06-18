package SolidPrinciples.P1_SingleResponsibilityPrinciple.EX1_LLD1.ProblematicCode;

public class Employee {
    String name ;
    int id ;
    int salary ;
    String address ;

    public Employee(String name, int id, int salary, String address) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.address = address;
    }
    //getter setters

    public void calculateSalary() {
        //Implements tax calculation methods
        System.out.println("Salary: " + salary);
    }

    public void printPerformance(){
        //calculates performance based on diffrent parameters
        System.out.println("Performance of Employee " );
    }

    public void updateEmployeeStringString() {
        //update Employee data
        System.out.println("print updated employee data ");
    }

    public void fetchEmployeeData(){
        System.out.println("fetched employee data");

    }

}

/*
* Now this Class does too many things and there are more than one reason to change it ,
* which leads to violation of SRP principle .
*
* if some new tax slabs comes implementation of calculate salary will change
*similary with other functions
* */















