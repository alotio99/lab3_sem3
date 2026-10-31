package storage;

public class FigureStorageException extends Exception {

    public FigureStorageException(String message) {
        super(message); // вызывает конструктор родителя и передает ему аргумент
    }

    public FigureStorageException(String message, Throwable prichina) {
        super(message, prichina);
    }
}