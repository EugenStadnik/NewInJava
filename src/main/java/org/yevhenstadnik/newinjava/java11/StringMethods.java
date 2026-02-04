package org.yevhenstadnik.newinjava.java11;

import java.util.List;

public class StringMethods {
    public static void main(String[] args) {
        String str = " Hello, Java 11! \n ";

        // Using strip(), isBlank(), lines(), repeat() methods
        String stripped = str.strip();              // Removes leading and trailing whitespaces
        boolean isBlank = str.isBlank();            // Checks if the string is empty or contains only whitespaces
        List<String> lines = str.lines().toList();  // Splits the string into lines
        String repeated = stripped.repeat(3);   // Repeats the string 3 times

        System.out.println("Stripped: '" + stripped + "'");
        System.out.println("Is Blank: " + isBlank);
        System.out.println("Lines: " + lines);
        System.out.println("Repeated: '" + repeated + "'");
    }
}
