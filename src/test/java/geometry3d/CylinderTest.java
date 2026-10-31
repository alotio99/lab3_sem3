package geometry3d;

import exceptions.InvalidFigureParameterException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CylinderTest {

    // Правильные тесты
    @Test
    void constructorAcceptsCircleBase() {
        Cylinder cylinder = new Cylinder(new Circle(2.0), 3.0);
        assertNotNull(cylinder);
    }

    @Test
    void constructorAcceptsRectangleBase() {
        Cylinder cylinder = new Cylinder(new Rectangle(2.0, 4.0), 5.0);
        assertNotNull(cylinder);
    }

    // Негативные тесты (ошибки высоты)
    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.0})
    void constructorRejectsZeroAndNegativeHeight(double height) {
        Circle base = new Circle(1.0);
        assertThrows(InvalidFigureParameterException.class, () -> new Cylinder(base, height));
    }

    @Test
    void constructorRejectsNaNHeight() {
        assertThrows(InvalidFigureParameterException.class, () -> new Cylinder(new Circle(1.0), Double.NaN));
    }

    @Test
    void constructorRejectsPositiveInfinityHeight() {
        assertThrows(InvalidFigureParameterException.class, () -> new Cylinder(new Circle(1.0), Double.POSITIVE_INFINITY));
    }

    @Test
    void constructorRejectsNegativeInfinityHeight() {
        assertThrows(InvalidFigureParameterException.class, () -> new Cylinder(new Circle(1.0), Double.NEGATIVE_INFINITY));
    }

    // Негативный тест (null вместо основания)
    @Test
    void constructorRejectsNullBase() {
        assertThrows(InvalidFigureParameterException.class, () -> new Cylinder(null, 3.0));
    }

    // Тесты объёма (volume)

    @Test
    void volumeOfCylinderWithCircleRadiusTwoAndHeightThree() {
        Cylinder cylinder = new Cylinder(new Circle(2.0), 3.0);
        double expected = Math.PI * (2.0 * 2.0) * 3.0; // π * r^2 * h
        assertEquals(expected, cylinder.volume(), 1e-9);
    }

    @Test
    void volumeOfCylinderWithCircleRadiusHalfAndHeightFour() {
        Cylinder cylinder = new Cylinder(new Circle(0.5), 4.0);
        double expected = Math.PI * (0.5 * 0.5) * 4.0;
        assertEquals(expected, cylinder.volume(), 1e-9);
    }

    @Test
    void volumeOfCylinderWithRectangleThreeByFourAndHeightTwo() {
        Cylinder cylinder = new Cylinder(new Rectangle(3.0, 4.0), 2.0);
        double expected = (3.0 * 4.0) * 2.0;
        assertEquals(expected, cylinder.volume(), 1e-9);
    }

    @Test
    void volumeOfCylinderWithRectangleOneByOneAndHeightFive() {
        Cylinder cylinder = new Cylinder(new Rectangle(1.0, 1.0), 5.0);
        double expected = (1.0 * 1.0) * 5.0;
        assertEquals(expected, cylinder.volume(), 1e-9);
    }

    // Тесты геттеров

    @Test
    void getBaseReturnsSameObjectPassedToConstructor() {
        Circle base = new Circle(2.0);
        Cylinder cylinder = new Cylinder(base, 3.0);
        assertSame(base, cylinder.getBase()); // проверяет, что две переменные ссылаются на один и тот же объект в памяти
    }

    @Test
    void getHeightReturnsConstructorValue() {
        Cylinder cylinder = new Cylinder(new Circle(1.0), 3.5);
        assertEquals(3.5, cylinder.getHeight(), 1e-9);
    }

    // Тесты toString()
    // проверять заявленное содержание (тип и параметры), а не пробелы

    @Test
    void toStringContainsTypeAndBaseAndHeight() {
        Cylinder cylinder = new Cylinder(new Circle(2.0), 3.0);
        String s = cylinder.toString();
        assertTrue(s.contains("Cylinder"));
        assertTrue(s.contains("Circle"));
        assertTrue(s.contains("3.0")); // высота
    }
}