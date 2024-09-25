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


# **Single Responsibility Principle (SRP)**
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

# Open-closed Principle (OCP)
 











