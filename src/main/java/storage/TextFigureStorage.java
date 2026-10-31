package storage;

import exceptions.InvalidFigureFormatException;
import geometry2d.Circle;
import geometry2d.Figure;
import geometry2d.Rectangle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// текстовая реализация хранилища

public class TextFigureStorage implements FigureStorage {

    private static final String CIRCLE = "CIRCLE";
    private static final String RECTANGLE = "RECTANGLE";
    private static final String RAZDEL = ";";

    @Override
    public List<Figure> read(Path path) throws IOException, FigureStorageException {
        List<Figure> figures = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) { // открываем файл для чтения
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) { // читает одну строку
                lineNumber++;
                if (line.isBlank()) {
                    continue;
                }
                figures.add(parseLine(line, lineNumber));
            }
        }
        return figures;
    }
    // берёт одну строку файла и превращает её в объект фигуры
    private Figure parseLine(String line, int lineNumber) throws InvalidFigureFormatException {
        String[] parts = line.split(RAZDEL);
        String type = parts[0].trim(); // убираем пробелы по краям

        try {
            switch (type) {
                case CIRCLE: {
                    if (parts.length != 2) {
                        throw new InvalidFigureFormatException(
                                "Строка " + lineNumber + ": ожидается 1 параметр для CIRCLE, получено "
                                        + (parts.length - 1));
                    }
                    double radius = Double.parseDouble(parts[1].trim());
                    return new Circle(radius);
                }
                case RECTANGLE: {
                    if (parts.length != 3) {
                        throw new InvalidFigureFormatException(
                                "Строка " + lineNumber + ": ожидается 2 параметра для RECTANGLE, получено "
                                        + (parts.length - 1));
                    }
                    double width = Double.parseDouble(parts[1].trim());
                    double height = Double.parseDouble(parts[2].trim());
                    return new Rectangle(width, height);
                }
                default:
                    throw new InvalidFigureFormatException(
                            "Строка " + lineNumber + ": неизвестный тип фигуры '" + type + "'");
            }
        } catch (NumberFormatException e) { //ловит exception в e
            throw new InvalidFigureFormatException(
                    "Строка " + lineNumber + ": не удалось преобразовать число", e);
        } catch (RuntimeException e) {
            throw new InvalidFigureFormatException(
                    "Строка " + lineNumber + ": некорректная фигура (" + e.getMessage() + ")", e);
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Figure figure : figures) {
                writer.write(format(figure));
                writer.newLine();
            }
        }
    }

    private String format(Figure figure) {
        if (figure instanceof Circle c) {
            return CIRCLE + RAZDEL + c.getRadius();
        }
        if (figure instanceof Rectangle r) {
            return RECTANGLE + RAZDEL + r.getWidth() + RAZDEL + r.getHeight();
        }
        throw new IllegalArgumentException("Неподдерживаемый тип фигуры: " + figure.getClass());
    }
}
