package org.yevhenstadnik.newinjava.java21;

public class StringMethods {

    public static void main(String[] args) {
        String str = "Hello, World";
        String[] sa = str.splitWithDelimiters(" ", 0);  // New method in Java 21
        for (String s : sa) {
            System.out.println("[" + s + "]");
        }
        // Output:
        // [Hello,]
        // [ ]
        // [World]
    }
}
