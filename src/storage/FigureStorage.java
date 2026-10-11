package storage;

import geometry2d.Figure;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// общий интерфейс списка

public interface FigureStorage {


//    читает список фигур из файла
//    для пустого файла возвращает пустой список

    List<Figure> read(Path path) throws IOException, FigureStorageException;

//   записывает список фигур в файл, заменяя содержимое

    void write(Path path, List<Figure> figures) throws IOException, FigureStorageException;
}
