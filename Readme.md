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



# 4. Interface Segregation Principle (ISP)

The **Interface Segregation Principle (ISP)** is one of the SOLID design principles in object-oriented programming. It states that no client should be forced to depend on interfaces it does not use. In simpler terms, it's better to create multiple small, specific interfaces rather than one large, general-purpose interface that contains methods not all clients will need.

## Formal Definition

The principle was introduced by Robert C. Martin, and it can be defined as:

> *“Clients should not be forced to depend on methods they do not use.”*

This principle promotes the creation of highly cohesive and focused interfaces that cater specifically to the needs of the clients using them.

## Why Follow ISP?

In systems that violate the Interface Segregation Principle, classes may end up depending on interfaces that include methods they don't need, leading to unnecessary complexity, code bloat, and a fragile design. By following ISP, each client is only exposed to the methods that are relevant to its role, resulting in cleaner, more maintainable code.

### Example of a Violation (Problematic Code)

In the provided example, the `User` interface has several methods:

```java
public interface User {

    boolean canBuyProducts();

    boolean canModifyProducts();

    boolean canAddProducts();

    boolean canApproveProducts();

    void approveProduct();
}
```

Here, the `User` interface tries to cater to different types of users: **admin**, **buyer**, and **seller**. However, not all users need all the methods:

- **Admin** can do everything (buy, modify, add, approve products).
- **Buyer** can only buy products.
- **Seller** can add, modify, and buy products, but they don’t approve products.

### Problems with This Design:

- **Interface Bloat**: The interface `User` includes methods that certain classes may not need. For example, a **buyer** should not need to implement `canModifyProducts()`, `canAddProducts()`, or `approveProduct()`, because a buyer does not perform these actions.
- **Violation of ISP**: By forcing all user types to implement a general-purpose interface, we are violating the Interface Segregation Principle, which leads to unnecessary implementation of methods and potential misuse.
- **Violation of LSP**: In a scenario where a `Buyer` class implements the `User` interface but doesn’t need methods like `approveProduct()`, it might throw exceptions or leave methods unimplemented, violating the **Liskov Substitution Principle (LSP)** as well.

## Refactoring to Follow ISP

The solution is to break down the `User` interface into smaller, role-specific interfaces, ensuring that each user type only implements the methods they require.

### Refactoring Example

Here’s how you can refactor the code to adhere to the Interface Segregation Principle:

```java
// Interface for users who can buy products
public interface Buyer {
    boolean canBuyProducts();
    void buyProduct();
}

// Interface for users who can modify products
public interface Modifier {
    boolean canModifyProducts();
    void modifyProduct();
}

// Interface for users who can add products
public interface Adder {
    boolean canAddProducts();
    void addProduct();
}

// Interface for users who can approve products
public interface Approver {
    boolean canApproveProducts();
    void approveProduct();
}

// Admin can do everything, so it implements all interfaces
public class Admin implements Buyer, Modifier, Adder, Approver {

    @Override
    public boolean canBuyProducts() {
        return true;
    }

    @Override
    public void buyProduct() {
        // Admin-specific implementation
    }

    @Override
    public boolean canModifyProducts() {
        return true;
    }

    @Override
    public void modifyProduct() {
        // Admin-specific implementation
    }

    @Override
    public boolean canAddProducts() {
        return true;
    }

    @Override
    public void addProduct() {
        // Admin-specific implementation
    }

    @Override
    public boolean canApproveProducts() {
        return true;
    }

    @Override
    public void approveProduct() {
        // Admin-specific implementation
    }
}

// Buyer only implements the Buyer interface
public class BuyerUser implements Buyer {

    @Override
    public boolean canBuyProducts() {
        return true;
    }

    @Override
    public void buyProduct() {
        // Buyer-specific implementation
    }
}

// Seller can buy, add, and modify products, but not approve
public class SellerUser implements Buyer, Adder, Modifier {

    @Override
    public boolean canBuyProducts() {
        return true;
    }

    @Override
    public void buyProduct() {
        // Seller-specific implementation
    }

    @Override
    public boolean canModifyProducts() {
        return true;
    }

    @Override
    public void modifyProduct() {
        // Seller-specific implementation
    }

    @Override
    public boolean canAddProducts() {
        return true;
    }

    @Override
    public void addProduct() {
        // Seller-specific implementation
    }
}
```

### Advantages of the Refactored Design:

- **ISP Compliance**: Now, each class only implements the interfaces that are relevant to its role, meaning there’s no unnecessary implementation of unrelated methods.
- **Modularity**: Each interface serves a specific purpose, leading to a more modular and flexible design.
- **Maintainability**: The system is easier to maintain because changes in one part of the system won’t affect other unrelated parts.
- **LSP Compliance**: By ensuring that each class only implements relevant functionality, we reduce the risk of violating the Liskov Substitution Principle as well.

## Conclusion

The **Interface Segregation Principle** helps to create a system where clients only need to know about the methods that are relevant to their specific needs. By splitting large interfaces into smaller, more specific ones, we achieve a more modular, maintainable, and robust design. This not only reduces unnecessary dependencies but also ensures a cleaner and more flexible architecture.


# 5.Dependency Inversion Principle (DIP)

The **Dependency Inversion Principle (DIP)** is the last of the SOLID principles in object-oriented design. It suggests that high-level modules should not depend on low-level modules but should instead depend on abstractions. This principle emphasizes reducing the coupling between components in a system by relying on abstractions (e.g., interfaces) rather than concrete implementations.

## Definition

Robert C. Martin, who introduced the SOLID principles, defines the Dependency Inversion Principle as:

> *"High-level modules should not depend on low-level modules. Both should depend on abstractions."*

> *"Abstractions should not depend on details. Details should depend on abstractions."*

This means that instead of directly instantiating classes or depending on concrete classes, a class should depend on interfaces or abstract classes, allowing for more flexibility and better modularity.

## Why Follow DIP?

In systems that violate DIP, high-level modules (the core logic of the system) depend directly on low-level modules (specific implementations). This tight coupling makes the system rigid, harder to change, and more prone to breaking when changes occur. By following DIP, you make your code more maintainable, testable, and flexible, as dependencies can be swapped out without affecting the core logic.

### Example of a Violation

Consider the following example where a high-level class directly depends on a low-level implementation:

```java
public class EmailService {
    public void sendEmail(String message) {
        // Code to send an email
        System.out.println("Sending email: " + message);
    }
}

public class UserNotification {
    private EmailService emailService;

    public UserNotification() {
        emailService = new EmailService();  // High-level module depends on low-level module
    }

    public void notifyUser() {
        emailService.sendEmail("You've got a new message!");
    }
}
```

### Problems with This Design:

1. **Tight Coupling**: The `UserNotification` class is tightly coupled to the `EmailService` class. If we want to change how notifications are sent (e.g., via SMS or push notifications), we must modify the `UserNotification` class, violating the **Open-Closed Principle**.
2. **Difficult to Test**: Testing `UserNotification` in isolation is difficult because it always depends on a concrete `EmailService`. We cannot mock or replace `EmailService` with a different implementation for testing purposes.
3. **No Flexibility**: There’s no way to easily switch from sending an email to another type of notification without changing the high-level class.

## Refactoring to Follow DIP

To adhere to the Dependency Inversion Principle, we can introduce an abstraction (an interface) that both the high-level `UserNotification` class and the low-level `EmailService` depend on. This way, the `UserNotification` class depends on an abstraction instead of a concrete implementation.

### Refactoring Example

```java
// Define an abstraction (interface) for sending messages
public interface MessageService {
    void sendMessage(String message);
}

// Low-level module: Email service
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        // Code to send an email
        System.out.println("Sending email: " + message);
    }
}

// Low-level module: SMS service
public class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        // Code to send an SMS
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module: Now depends on abstraction, not on the concrete class
public class UserNotification {
    private MessageService messageService;

    // The service can be injected through constructor or setter
    public UserNotification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser() {
        messageService.sendMessage("You've got a new message!");
    }
}
```

### Advantages of the Refactored Design:

1. **Loose Coupling**: The `UserNotification` class no longer depends on a specific low-level implementation like `EmailService`. Instead, it depends on the `MessageService` abstraction, allowing us to swap out different message services (e.g., `EmailService`, `SmsService`) without modifying the `UserNotification` class.

2. **Easier Testing**: We can easily mock the `MessageService` interface for unit testing purposes without relying on actual implementations of `EmailService` or `SmsService`.

3. **Flexibility and Extensibility**: If we want to add a new notification method (e.g., push notifications), we can simply create a new class that implements the `MessageService` interface, and the `UserNotification` class remains unchanged. This adheres to the **Open-Closed Principle**.

4. **Inversion of Control**: The high-level module (`UserNotification`) no longer controls which message service to use. The choice of implementation is inverted, allowing it to be injected from outside, often using dependency injection frameworks like Spring or Guice.

### Example with Dependency Injection:

Using a dependency injection framework, we can simplify the creation of dependencies.

```java
public class Application {
    public static void main(String[] args) {
        MessageService messageService = new EmailService(); // Can switch to new SmsService()
        UserNotification notification = new UserNotification(messageService);
        notification.notifyUser();
    }
}
```

## Benefits of the Dependency Inversion Principle:

- **Increased Flexibility**: Systems that follow DIP are more flexible and allow for easier swapping of different implementations without modifying the core logic.
- **Easier Maintenance**: High-level modules can be maintained and updated without worrying about changes to low-level details.
- **Testability**: Since the system relies on abstractions, it is easier to mock or replace dependencies for testing purposes, leading to better test coverage.
- **Reduced Coupling**: By relying on interfaces or abstractions, we reduce the dependency between modules, making the code more modular and resilient to changes.

## Conclusion

The **Dependency Inversion Principle** ensures that both high-level modules (business logic) and low-level modules (specific implementations) depend on abstractions rather than each other. This principle is crucial for creating systems that are flexible, maintainable, and easy to test. By following DIP, we invert the flow of control, leading to more loosely coupled and adaptable systems.