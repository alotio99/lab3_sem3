package geometry3d;

import exceptions.InvalidFigureParameterException;
import geometry2d.Figure;

public class Cylinder {

    private final Figure base;
    private final double height;

    public Cylinder(Figure base, double height) {
        if (base == null) {
            throw new InvalidFigureParameterException("Основание цилиндра не должно быть null");
        }
        if (!Double.isFinite(height) || height <= 0) {
            throw new InvalidFigureParameterException(
                    "Высота должна быть положительным конечным числом: height= " + height);
        }
        this.base = base;
        this.height = height;
    }

    public Figure getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cylinder{base= " + base + ", height= " + height + "}";
    }
}
