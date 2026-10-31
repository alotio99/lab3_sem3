package geometry2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    private static final double EPSILON = 1e-9; // Погрешность для double

    // Правильные тесты площади
    @Test // Запускается когда прошу это
    void areaOfUnitCircleIsPi() {
        Circle circle = new Circle(1.0);
        assertEquals(Math.PI, circle.area(), EPSILON); // Сравнивает что получилось и что должно было
    }

    @Test
    void areaOfRadiusTwoIsFourPi() {
        Circle circle = new Circle(2.0);
        assertEquals(4.0 * Math.PI, circle.area(), EPSILON);
    }

    @Test
    void areaOfRadiusHalfIsQuarterPi() {
        Circle circle = new Circle(0.5);
        assertEquals(0.25 * Math.PI, circle.area(), EPSILON);
    }

    // Правильные тесты периметра
    @Test
    void perimeterOfUnitCircleIsTwoPi() {
        Circle circle = new Circle(1.0);
        assertEquals(2.0 * Math.PI, circle.perimeter(), EPSILON);
    }

    @Test
    void perimeterOfRadiusTwoIsFourPi() {
        Circle circle = new Circle(2.0);
        assertEquals(4.0 * Math.PI, circle.perimeter(), EPSILON);
    }

    @Test
    void perimeterOfRadiusHalfIsPi() {
        Circle circle = new Circle(0.5);
        assertEquals(Math.PI, circle.perimeter(), EPSILON);
    }
}
