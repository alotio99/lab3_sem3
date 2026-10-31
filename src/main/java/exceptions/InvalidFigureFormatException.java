package exceptions;

import storage.FigureStorageException;

// проверяемое исключение для некорректной записи
// из-за наследования является подтипом родителя,
// чтобы не расширять список исключений

public class InvalidFigureFormatException extends FigureStorageException {

    public InvalidFigureFormatException(String message) {
        super(message);
    }

    public InvalidFigureFormatException(String message, Throwable prichina) {
        super(message, prichina);
    }
}
