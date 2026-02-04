package org.yevhenstadnik.newinjava.java21;

public class PatternMatching {

    public interface Point {}

    public record CartesianPoint(double x, double y) implements Point {}

    public record PolarPoint(double radius, double theta) implements Point {}

    public record Path<P extends Point>(P start, P end) {}

    public static void main(String[] args) {
        Point point1 = new CartesianPoint(3.0, 4.0);
        Point point2 = new PolarPoint(5.0, Math.atan2(4.0, 3.0));
        Path<Point> path = new Path<>(point1, point2);

        if (point1 instanceof CartesianPoint cp) {  // Starting from Java 11 we can
                                                    // determine variable name such will be cast automatically
            System.out.println("Cartesian Point: x=" + cp.x() + ", y=" + cp.y());
        } else if (point2 instanceof PolarPoint(double r, double theta)) {  // Starting from Java 21 we can
                                                                            // decompose and cast record's attributes directly in
                                                                            // instanceof including recursive decomposition
            System.out.println("Polar Point: radius=" + r + ", theta=" + theta);
        }

        switch(path) {
            case Path(CartesianPoint(double x1, double y1), CartesianPoint(double x2, double y2)) ->    // Recursive decomposition
                    System.out.println("Path between Cartesian Points: (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
            case Path(PolarPoint(double r1, double t1), PolarPoint(double r2, double t2)) ->            // Recursive decomposition
                    System.out.println("Path between Polar Points: (r=" + r1 + ", θ=" + t1 + ") to (r=" + r2 + ", θ=" + t2 + ")");
            default -> System.out.println("Path between different types of Points.");
        }

        int switchIndex = switch (point1) {
            case CartesianPoint cp: yield 1;    // Now switch can yield values
            case PolarPoint p: yield 2;
            default: yield 0;
        };
        System.out.println("Switch index: " + switchIndex);

    }
}