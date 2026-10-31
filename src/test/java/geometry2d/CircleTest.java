package geometry2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import exceptions.InvalidFigureParameterException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Негативные тесты (проверка на ошибки)

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5}) // Запускает 3 раза с этими данными
    void constructorRejectsZeroAndNegativeRadius(double radius) {
        assertThrows(InvalidFigureParameterException.class, () -> new Circle(radius));
    }

    @Test
    void constructorRejectsNaN() {
        assertThrows(InvalidFigureParameterException.class, () -> new Circle(Double.NaN));
    }

    @Test
    void constructorRejectsPositiveInfinity() {
        assertThrows(InvalidFigureParameterException.class, () -> new Circle(Double.POSITIVE_INFINITY));
    }

    @Test
    void constructorRejectsNegativeInfinity() {
        assertThrows(InvalidFigureParameterException.class, () -> new Circle(Double.NEGATIVE_INFINITY));
    }

    // Тесты геттера
    @Test
    void getRadiusReturnsConstructorValue() {
        Circle circle = new Circle(2.5);
        assertEquals(2.5, circle.getRadius(), 1e-9);
    }

    // Тест toString()
    @Test
    void toStringContainsTypeAndRadius() {
        Circle circle = new Circle(2.5);
        String s = circle.toString();
        assertTrue(s.contains("Circle"));
        assertTrue(s.contains("2.5"));
    }
}
