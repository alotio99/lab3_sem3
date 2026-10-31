package geometry2d;

import exceptions.InvalidFigureParameterException;

public class Circle implements Figure {

    private static final long serialVersionUID = 1L; // номер версии сериализуемого класса

    private final double radius;

    public Circle(double radius) {
        if (!Double.isFinite(radius) || radius <= 0) { // isFinite - конечное число
            throw new InvalidFigureParameterException(
                    "Радиус должен быть положительным конечным числом: radius= " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{radius= " + radius + "}";
    }
}
