package org.yevhenstadnik.newinjava.java21;

public class StringBufferMethods {

    public static void main(String[] args) {
        var sBuff = new StringBuffer("Hello, ");
        sBuff.repeat(" Java21!", 2); // New method in Java 21
        System.out.println(sBuff);
        // Output: Hello,  Java21! Java21!
    }
}
