package exceptions;

// непроверяемое исключение для недопустимых параметров фигур

public class InvalidFigureParameterException extends RuntimeException {

    public InvalidFigureParameterException(String message) {
        super(message); // вызывает конструктор родмтеля и передает ему аргумент
    }

    public InvalidFigureParameterException(String message, Throwable prichina) {
        super(message, prichina);
    }
}
