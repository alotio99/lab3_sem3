package geometry3d;

import exceptions.InvalidFigureParameterException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}