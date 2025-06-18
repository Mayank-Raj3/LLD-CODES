package PrototypePattern.PrototypePatternImplementation;

public interface Prototype<T> {
    T clone();
}

/*
    Made it return Generics as we dont know what we will pass
    Also Its Important to make because

    Creating a Cloneable or Prototype<T> interface is crucial for:
        - Standardizing cloning
        - Enabling polymorphic copying
        - Ensuring robust, scalable design patterns
        - Also it make sures everyone  class have clone function else
          will give error
 */