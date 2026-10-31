package geometry2d;

import java.io.Serializable; // разрешает записывать объекты фигур
// в ObjectOutputStream и восстанавливать из ObjectInputStream

public interface Figure extends Serializable {
    double area();
    double perimeter();
}
