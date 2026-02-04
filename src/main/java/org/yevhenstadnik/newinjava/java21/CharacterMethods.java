package org.yevhenstadnik.newinjava.java21;

public class CharacterMethods {

    public static void main(String[] args) {
        char charValue = '☺';
        boolean isEmoji = Character.isEmoji(charValue);     // New method in Java 21
        System.out.printf("The 0x%x code character is emoji: %b%n", (int)charValue, isEmoji);
    }
}
