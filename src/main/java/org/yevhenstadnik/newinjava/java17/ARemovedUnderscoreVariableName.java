package org.yevhenstadnik.newinjava.java17;

public class ARemovedUnderscoreVariableName {

    // private int _;               // This will cause a compilation error in Java 17 and later

    private void doSomething(
    //        String _              // This will cause a compilation error in Java 17 and later
    ) {
    //    double _ = 1.0;           // This will cause a compilation error in Java 17 and later
        if (System.currentTimeMillis() % 2 == 0) {
        //    boolean _ = true;     // This will cause a compilation error in Java 17 and later
        }
    }
}
