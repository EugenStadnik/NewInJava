package org.yevhenstadnik.newinjava.java21;

public class StringBuilderMethods {

    public static void main(String[] args) {
        var sb = new StringBuilder("Hello, ");
        sb.repeat(" Java21!", 3);   // New method in Java 21
        System.out.println(sb);
        // Output: Hello,  Java21! Java21! Java21!
    }
}
