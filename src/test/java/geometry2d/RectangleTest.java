package geometry2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import exceptions.InvalidFigureParameterException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleTest {

    private static final double EPSILON = 1e-9; // Погрешность для double

    // Правильные тесты площади
    @Test // Запускается когда прошу это
    void areaOfThreeByFourRectangleIsTwelve() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(12.0, rectangle.area(), EPSILON); // Сравнивает что получилось и что должно было
    }

    @Test
    void areaOfSquareWithSideFiveIsTwentyFive() {
        Rectangle square = new Rectangle(5.0, 5.0);
        assertEquals(25.0, square.area(), EPSILON);
    }

    @Test
    void areaOfTwoBySevenRectangleIsFourteen() {
        Rectangle rectangle = new Rectangle(2.0, 7.0);
        assertEquals(14.0, rectangle.area(), EPSILON);
    }

    // Правильные тесты периметра
    @Test
    void perimeterOfThreeByFourRectangleIsFourteen() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        assertEquals(14.0, rectangle.perimeter(), EPSILON);
    }

    @Test
    void perimeterOfSquareWithSideFiveIsTwenty() {
        Rectangle square = new Rectangle(5.0, 5.0);
        assertEquals(20.0, square.perimeter(), EPSILON);
    }

    @Test
    void perimeterOfTwoBySevenRectangleIsEighteen() {
        Rectangle rectangle = new Rectangle(2.0, 7.0);
        assertEquals(18.0, rectangle.perimeter(), EPSILON);
    }

    // Негативные тесты (проверка на ошибки)

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5}) // Запускает 3 раза с этими данными
    void constructorRejectsZeroAndNegativeWidth(double width) {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(width, 4.0));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5})
    void constructorRejectsZeroAndNegativeHeight(double height) {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(4.0, height));
    }

    @Test
    void constructorRejectsNaNWidth() {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(Double.NaN, 4.0));
    }

    @Test
    void constructorRejectsNaNHeight() {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(4.0, Double.NaN));
    }

    @Test
    void constructorRejectsPositiveInfinityWidth() {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(Double.POSITIVE_INFINITY, 4.0));
    }

    @Test
    void constructorRejectsNegativeInfinityHeight() {
        assertThrows(InvalidFigureParameterException.class, () -> new Rectangle(4.0, Double.NEGATIVE_INFINITY));
    }

    // Тесты геттеров
    @Test
    void getWidthAndHeightReturnConstructorValues() {
        Rectangle rectangle = new Rectangle(3.0, 4.5);
        assertEquals(3.0, rectangle.getWidth(), 1e-9);
        assertEquals(4.5, rectangle.getHeight(), 1e-9);
    }

    // Тест toString()
    @Test
    void toStringContainsTypeAndSideValues() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        String s = rectangle.toString();
        assertTrue(s.contains("Rectangle"));
        assertTrue(s.contains("3.0"));
        assertTrue(s.contains("4.0"));
    }
}
