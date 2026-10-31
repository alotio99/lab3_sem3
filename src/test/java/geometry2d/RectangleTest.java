package geometry2d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
