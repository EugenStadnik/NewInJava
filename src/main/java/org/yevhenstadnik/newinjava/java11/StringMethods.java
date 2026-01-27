package org.yevhenstadnik.newinjava.java11;

import java.util.List;

public class StringMethods {
    public static void main(String[] args) {
        String str = " Hello, Java 11! \n ";

        // Using strip(), isBlank(), lines(), repeat() methods
        String stripped = str.strip();
        boolean isBlank = str.isBlank();
        List<String> lines = str.lines().toList();
        String repeated = stripped.repeat(3);

        System.out.println("Stripped: '" + stripped + "'");
        System.out.println("Is Blank: " + isBlank);
        System.out.println("Lines: " + lines);
        System.out.println("Repeated: '" + repeated + "'");
    }
}
