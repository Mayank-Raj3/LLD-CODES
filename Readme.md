# LLD
LLD (Low-Level Design) refers to the detailed **design phase** of a system or software where the focus is on specifying how the individual components or modules of a system will be implemented. It involves designing the **system's architecture** at a granular level, defining the classes, methods, interfaces, data flow, algorithms, and other details that are necessary for the actual coding phase.

##  What is SOLID?
[SOLID](https://en.wikipedia.org/wiki/SOLID)  is a set of principles distilled from the writings of Robert C. Martin in the early 2000s. It was proposed as a way to think specifically about the quality of object-oriented (OO) programming. As a whole, the SOLID principles make arguments for how code should be split up, which parts should be internal or exposed, and how code should use other code. I'll dive into each letter below and explain its original meaning, as well as an expanded meaning that can apply outside of OO programming.

SOLID stands for:
-   [**S**  - Single-responsibility Principle](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#single-responsibility-principle)
-   [**O**  - Open-closed Principle](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#open-closed-principle)
-   [**L**  - Liskov Substitution Principle](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#liskov-substitution-principle)
-   [**I**  - Interface Segregation Principle](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#interface-segregation-principle)
-   [**D**  - Dependency Inversion Principle](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#dependency-inversion-principle)


# **1. Single Responsibility Principle (SRP)**
The **Single Responsibility Principle (SRP)** is one of the five SOLID principles of object-oriented design, which were introduced by Robert C. Martin (Uncle Bob). The principle states that:

**A class should have only one reason to change, meaning it should have only one job or responsibility.**

In other words, a class should be responsible for a **single part of the functionality** provided by the software. This makes the class easier to understand, maintain, and modify because any changes required for that specific responsibility will only affect that class.

### Key Benefits:
1. **Improved Maintainability**: If a class has a single responsibility, it becomes easier to locate where changes need to be made.
2. **Reduced Complexity**: A class with only one responsibility will generally be simpler, making it easier to comprehend.
3. **Enhanced Testability**: Smaller, focused classes are easier to test because they have fewer dependencies and fewer possible points of failure.
4. **Encourages Reusability**: Classes with a single responsibility can often be reused in other parts of the program or in different programs.

### Example:
Imagine a class called `User` that handles user data and also manages user notifications. According to the Single Responsibility Principle, this class has two reasons to change: if the way user data is handled changes, or if the way notifications are managed changes. To adhere to SRP, you should split this into two classes:

- `User` class that handles user data.
- `UserNotification` class that manages sending notifications.

This separation ensures that each class has only one reason to change, thus following the Single Responsibility Principle.

### Bad Code Example (Violating SRP)

In this example, the `User` class is responsible for **both managing user data and sending notifications,** which **violates the Single Responsibility Principle**.
```java
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void sendNotification(String message) {
        // Code to send email notification
        System.out.println("Sending email to " + email + ": " + message);
    }

    public void saveToDatabase() {
        // Code to save user data to the database
        System.out.println("Saving user " + name + " to database.");
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");
        user.saveToDatabase();
        user.sendNotification("Welcome to our service!");
    }
}
```

### Issues:
- The `User` class **handles multiple responsibilities**: managing user data, sending notifications, and saving to the database.
- Any changes in how notifications are sent or how data is saved require modifications to the `User` class, increasing the risk of introducing bugs.

### Better Code Example (Adhering to SRP)

Here, the responsibilities are split into **separate classes (User , NotificationService , UserRepository)**, each with its own focus.
```Java
class User { //class1 
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// Separate class for handling notifications
class NotificationService { //class2 
    public void sendNotification(User user, String message) {
        // Code to send email notification
        System.out.println("Sending email to " + user.getEmail() + ": " + message);
    }
}

// Separate class for handling database operations
class UserRepository {  //class 3 
    public void saveToDatabase(User user) {
        // Code to save user data to the database
        System.out.println("Saving user " + user.getName() + " to database.");
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");

        UserRepository userRepository = new UserRepository();
        userRepository.saveToDatabase(user);

        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(user, "Welcome to our service!");
    }
}
```


### Benefits:
- **Separation of Concerns**: Each class has a single responsibility. The `User` class handles only user data, `NotificationService` handles notifications, and `UserRepository` handles database operations.
- **Flexibility**: Changes in notification logic or database storage can be made without affecting the `User` class.
- **Easier Testing**: Each class can be tested independently, making unit tests simpler and more focused.


# 2. Open/Closed Principle (OCP) 

The **Open/Closed Principle (OCP)** is one of the SOLID principles of object-oriented design. It states that:

**"Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."**

This means that we should be able to extend a class's behavior without modifying its existing code. Below, we will explore both a **bad implementation** that violates OCP and a **good implementation** that adheres to it.

## Bad Implementation (Violates OCP)

In this example, the `DiscountCalculator` class violates the OCP because every time a new discount type is added, the class must be modified. This makes the class hard to maintain and susceptible to bugs.

```java
class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1; // 10% discount for regular customers
        } else if (customerType.equals("VIP")) {
            return amount * 0.2; // 20% discount for VIP customers
        } else if (customerType.equals("Employee")) {
            return amount * 0.3; // 30% discount for employees
        } else {
            return 0;
        }
    }
}
```

### Why This Is Bad:
- **Modification**: Every time a new customer type is introduced (e.g., a "Student" or "Affiliate"), the `DiscountCalculator` class must be changed.
- **Brittle Code**: Changing the code repeatedly makes it prone to errors.
- **Violation of OCP**: The class is not closed for modification, as we have to modify it for each new feature.

## Good Implementation (Follows OCP)

In this refactored version, the `DiscountCalculator` class adheres to OCP by introducing an abstract `Customer` class with specific discount logic for each type of customer. This way, adding new customer types only requires creating a new class, without modifying the existing ones.

```java
// Abstract class or interface to represent a Customer
abstract class Customer {
    public abstract double getDiscount(double amount);
}

// Concrete implementations for each customer type
class RegularCustomer extends Customer {
    @Override
    public double getDiscount(double amount) {
        return amount * 0.1; // 10% discount for regular customers
    }
}

class VipCustomer extends Customer {
    @Override
    public double getDiscount(double amount) {
        return amount * 0.2; // 20% discount for VIP customers
    }
}

class EmployeeCustomer extends Customer {
    @Override
    public double getDiscount(double amount) {
        return amount * 0.3; // 30% discount for employees
    }
}

// DiscountCalculator class is open for extension but closed for modification
class DiscountCalculator {
    public double calculateDiscount(Customer customer, double amount) {
        return customer.getDiscount(amount);
    }
}
```

### Why This Is Good:
- **Closed for Modification**: The `DiscountCalculator` class is now closed for modification. We no longer need to modify it when a new customer type is added.
- **Open for Extension**: If a new customer type (e.g., `StudentCustomer`) needs to be added, we can simply create a new class that extends `Customer` without changing existing code.
- **Scalable**: The design is now more flexible, allowing easy extensions with minimal risk of breaking existing functionality.

### Adding a New Customer Type (Extension without Modification)

If we need to add a new customer type, like a **StudentCustomer**, we simply create a new class that extends `Customer`:

```java
class StudentCustomer extends Customer {
    @Override
    public double getDiscount(double amount) {
        return amount * 0.15; // 15% discount for students
    }
}
```

No changes are required in the `DiscountCalculator` class. We just use the new class:

```java
public class Main {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        
        Customer regular = new RegularCustomer();
        Customer vip = new VipCustomer();
        Customer student = new StudentCustomer();
        
        System.out.println("Regular Discount: " + calculator.calculateDiscount(regular, 100));
        System.out.println("VIP Discount: " + calculator.calculateDiscount(vip, 100));
        System.out.println("Student Discount: " + calculator.calculateDiscount(student, 100));
    }
}
```

## Conclusion

By following OCP:
- We avoid modifying existing, tested code, reducing the chances of introducing bugs.
- We make the system more scalable, as new features can be added easily by extending the functionality.



# 3. Liskov Substitution Principle (LSP)

The **Liskov Substitution Principle (LSP)** is one of the SOLID design principles in object-oriented programming. It states that objects of a superclass should be replaceable with objects of a subclass without altering the correctness of the program. In simple terms, derived classes must be completely substitutable for their base classes.

## Formal Definition

Barbara Liskov, who introduced the principle in 1987, defines LSP as:

> *“Subtypes must be substitutable for their base types without altering the expected behaviors of a program.”*

This means that if class `B` is a subclass of class `A`, then objects of class `A` should be able to be replaced by objects of class `B` without any side effects.

## Violation of LSP

A violation of the Liskov Substitution Principle occurs when a subclass modifies the behavior of a superclass in such a way that it breaks the expectations set by the superclass. This is often seen when a subclass throws exceptions or returns different results for methods that are expected to be handled uniformly by the superclass.

In the code example provided, the **CreditCard** class is designed with several payment methods (like `tapAndPay()`, `onlineTransfer()`, `upiPayment()`, etc.). However, not all credit card types support every form of payment:

- **Rupay** only supports UPI payments.
- **Visa** supports only international payments and a few other payment methods.

This design violates the Liskov Substitution Principle because not all subclasses of `CreditCard` can handle the same set of operations uniformly. For instance, if a `Rupay` card object is used in place of a `CreditCard` and methods like `intlPayment()` are called, the system would fail since Rupay doesn’t support international payments.

### Example Breakdown

```java
public abstract class CreditCard {
    public abstract void tapAndPay();
    public abstract void onlineTransfer();
    public abstract void swipeAndPay();
    public abstract void mandatePayments();
    public abstract void upiPayment();  // Not all cards support UPI payment
    public abstract void intlPayment(); // Not all cards support International Payment
}
```

Here, the `CreditCard` class has abstract methods for all the types of payments. This forces every subclass to implement all these methods, even if some don’t apply. For example:

- A **Rupay card** only supports UPI payments.
- A **Visa card** supports international payments but not UPI.

In this case, either we have to throw exceptions in unsupported methods, or we have to check the card type using `if-else` statements, which violates both the **Liskov Substitution Principle** and **Open-Closed Principle**.

### Issues with the Above Design

- **LSP Violation**: Subclasses like `RupayCard` or `VisaCard` cannot fully replace the `CreditCard` class because they do not support all the payment methods.
- **Behavioral Inconsistency**: Consumers of the `CreditCard` class cannot safely assume all credit cards behave the same way, resulting in potential runtime errors when unsupported operations are called.

## Solution: Refactor for Compliance with LSP

A better design approach is to use interfaces or abstract classes to model different types of payments that a card can support, and ensure that each card class only implements the relevant interfaces. This will allow for greater flexibility and compliance with the Liskov Substitution Principle.

### Example Refactoring:

```java
// Interface for cards supporting UPI payment
public interface UpiPaymentCard {
    void upiPayment();
}

// Interface for cards supporting international payments
public interface InternationalPaymentCard {
    void intlPayment();
}

// Abstract base class for generic card methods
public abstract class CreditCard {
    public abstract void tapAndPay();
    public abstract void onlineTransfer();
    public abstract void swipeAndPay();
    public abstract void mandatePayments();
}

// Rupay card only supports UPI payment
public class RupayCard extends CreditCard implements UpiPaymentCard {
    @Override
    public void tapAndPay() {
        // Rupay-specific implementation
    }

    @Override
    public void onlineTransfer() {
        // Rupay-specific implementation
    }

    @Override
    public void swipeAndPay() {
        // Rupay-specific implementation
    }

    @Override
    public void mandatePayments() {
        // Rupay-specific implementation
    }

    @Override
    public void upiPayment() {
        // Rupay-specific implementation
    }
}

// Visa card supports international payment
public class VisaCard extends CreditCard implements InternationalPaymentCard {
    @Override
    public void tapAndPay() {
        // Visa-specific implementation
    }

    @Override
    public void onlineTransfer() {
        // Visa-specific implementation
    }

    @Override
    public void swipeAndPay() {
        // Visa-specific implementation
    }

    @Override
    public void mandatePayments() {
        // Visa-specific implementation
    }

    @Override
    public void intlPayment() {
        // Visa-specific implementation
    }
}
```

### Advantages of This Approach:
- **LSP Compliance**: Subclasses can be substituted for the base class without causing errors since they only implement methods they actually support.
- **No Runtime Exceptions**: No need to throw exceptions for unsupported operations.
- **Flexible and Extensible**: Adding support for new card types or payment methods is easy by implementing or extending the appropriate interfaces.

## Conclusion

The Liskov Substitution Principle ensures that a subclass can replace its superclass without altering the correctness of the program. Violating LSP can lead to unexpected behavior, especially when subclasses don’t support all the functionalities of the base class. By refactoring using interfaces or proper abstraction, we can ensure that our designs remain flexible, scalable, and compliant with LSP.



