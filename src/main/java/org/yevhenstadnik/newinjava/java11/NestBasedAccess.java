package org.yevhenstadnik.newinjava.java11;

public class NestBasedAccess {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        int x = inner.getOuterPrivateVar();
    }

    public static class Outer {

        private int x = 10;

        protected class Inner {

            private int y = x;

            public int getOuterPrivateVar() {
                return x;
            }
        }
    }
}
