package org.yevhenstadnik.newinjava.java11;

import java.util.Arrays;
import java.util.List;

public class LocalVariableSyntaxForLambda {
    public static void main(String[] args) {
        // Using 'var' in lambda parameters
        List<String> list = Arrays.asList("one", "two", "three");
        list.forEach((var item) -> System.out.println(item));
    }
}
