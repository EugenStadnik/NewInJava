package org.yevhenstadnik.newinjava.java11;

public class EpsilonGarbageCollectorExample {
    public static void main(String[] args) {
        // To enable Epsilon GC, run the JVM with the following option:
        // -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
        System.out.println("Epsilon Garbage Collector Example");
        // Allocate memory and observe behavior
        for (int i = 0; i < 100000; i++) {
            byte[] b = new byte[1024 * 1024]; // Allocate 1MB
        }
        System.out.println("Finished memory allocation");
    }
}
