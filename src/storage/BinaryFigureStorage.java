package storage;

import geometry2d.Figure;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// бинарная реализация хранилища

public class BinaryFigureStorage implements FigureStorage {

    @Override
    public List<Figure> read(Path path) throws IOException, FigureStorageException {
        // открывает файл и оборачивает в ObjectInputStream
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            Object obj = in.readObject();

            if (!(obj instanceof List<?> rawList)) { // является ли списком
                throw new FigureStorageException(
                        "Ожидался список фигур, получен: " + obj.getClass().getName());
            }

            List<Figure> figures = new ArrayList<>();
            for (Object item : rawList) {
                if (!(item instanceof Figure figure)) { // проверка на фигуру и приведение к Figure
                    throw new FigureStorageException(
                            "Элемент списка не является фигурой: "
                                    + (item == null ? "null" : item.getClass().getName()));
                }
                figures.add(figure);
            }
            return figures;

        } catch (ClassNotFoundException e) { // ловит причину в e
            throw new FigureStorageException("Не удалось найти класс при десериализации", e);
        } catch (ClassCastException e) {
            throw new FigureStorageException("Некорректный тип данных в файле", e);
        }
    }

    @Override
    public void write(Path path, List<Figure> figures) throws IOException {
        // открывает файл и оборачивает в ObjectInputStream
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            // чтобы в поток шёл гарантированно сериализуемый ArrayList
            out.writeObject(new ArrayList<>(figures));
        }
    }
}
