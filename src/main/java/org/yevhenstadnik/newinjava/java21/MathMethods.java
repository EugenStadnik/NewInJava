package org.yevhenstadnik.newinjava.java21;

public class MathMethods {

    public static void main(String[] args) {
        int min = 5;
        int max = 12;
        int value = 21;
        int clampedValue = Math.clamp(value, min, max); // New method in Java 21
        System.out.println("Clamped Value: " + clampedValue);
        // Output: Clamped Value: 12
    }

}
