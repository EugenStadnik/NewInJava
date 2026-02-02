package org.yevhenstadnik.newinjava.java17;

public class InstanceofSwitch {

    public static void main(String[] args) {
        InstanceofSwitch example = new InstanceofSwitch();
        example.check(null);
        example.check("Hello, World!");
        example.check(42);
        example.check(3.14);
    }

    void check(Object obj) { // right arrow "->" notation (fallthrough is not allowed)
        switch (obj) {
            case null -> System.out.println("It's null");  // in other case will throw NullPointerException
            case String s -> System.out.println("It's a string: " + s); // the subtype pattern should be first
            case CharSequence cs -> additionalConditions(cs);                      // the supertype pattern should be after
            case Number n -> additionalConditions(n);
            default -> System.out.println("Unknown type"); // omitting default will produce a compilation error except sealed classes
        }
    }

    void additionalConditions(Number number) { // colon ":" notation (fallthrough is possible)
        switch (number) {
            case null: // in other case will throw NullPointerException
                break;
            case Integer i:
                if (i >= 100) {
                    System.out.println("The number is 100 or greater");
                }
                break; // always use break in ":" switch notation either will produce "cannot find symbol" compilation error (falling through is not allowed)
            case Double d:
                if (d >= 100.0) {
                    System.out.println("The number is 100.0 or greater");
                }
                break;
            default:
                System.out.println("The number is less than 100"); // omitting default will produce a compilation error except sealed classes
        }
    }

    void additionalConditions(CharSequence text) {
        switch (text) {  // could throw NullPointerException
            case String s /*&& (s.length() > 10)*/ -> //Somehow it doesn't work for me
                    System.out.println("The text is longer than 10 characters: " + s);
            default ->
                    System.out.println("The text is less than 10 characters: " + text); // omitting default will produce a compilation error except sealed classes
        }
    }

    /**
     * Each end every subclass of all sealed classes must be handled in the switch,
     * */
    void checkSealed(SealedClasses s) {
//        switch (s) {
//            case SealedClasses.Circle c -> System.out.println("It's Circle");
//            case SealedClasses.Rectangle r -> System.out.println("It's Rectrangle");
//            case SealedClasses.Data d -> System.out.println("It's Data");
//        }
    }
}
