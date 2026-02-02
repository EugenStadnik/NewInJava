package org.yevhenstadnik.newinjava.java17;

public class SealedClasses {

    protected final class Circle extends Polygon { // subclass must be final, sealed, or non-sealed

    }

    protected non-sealed class Rectangle extends Polygon { // subclass must be final, sealed, or non-sealed

    }

    protected class Square extends Rectangle { // non-sealed subclass can be extended freely

    }

    protected abstract sealed class Polygon implements Shape { // subclass must be final, sealed, or non-sealed

    }

    protected record Data (int x) implements Shape { // records can also implement sealed interfaces

    }

    // class Square implements Shape { }
    // Will produce compilation failure because Shape is sealed and only Circle and Rectangle are permitted to extend it.

    // non-sealed class Fruit {}
    // non-sealed class should have super class

    protected sealed interface Shape permits Data, Polygon { // only permitted subclasses can implement this interface

    }

}
