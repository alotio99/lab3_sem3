package app;

import geometry2d.Figure;
import geometry3d.Cylinder;
import storage.BinaryFigureStorage;
import storage.FigureStorage;
import storage.TextFigureStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. пути к файлам
        System.out.print("Введите путь к входному текстовому файлу: ");
        Path textPath = Path.of(scanner.nextLine().trim());
        System.out.print("Введите путь к выходному бинарному файлу: ");
        Path binPath = Path.of(scanner.nextLine().trim());

        // 2. чтение через текстовую реализацию интерфейса
        FigureStorage textStorage = new TextFigureStorage();
        List<Figure> figures;
        try {
            figures = textStorage.read(textPath);
        } catch (Exception e) {
            System.err.println("Ошибка чтения текстового файла: " + e.getMessage());
            return;
        }

        // 3. вывод фигур через интерфейс Figure
        System.out.println("Прочитано фигур: " + figures.size());
        for (Figure figure : figures) {
            System.out.println(
                    figure + " | area=" + String.format("%.4f", figure.area()) // %.4f для округления
                            + " | perimeter=" + String.format("%.4f", figure.perimeter()));
        }

        // 4. случайное основание для Cylinder
        if (figures.isEmpty()) {
            System.out.println("Список фигур пуст — цилиндр не создаётся.");
        } else {
            Figure base = figures.get(new Random().nextInt(figures.size()));
            double height = readHeight(scanner);
            try {
                Cylinder cylinder = new Cylinder(base, height);
                System.out.println("Основание: " + cylinder.getBase());
                System.out.println("Высота: " + cylinder.getHeight());
                System.out.println("Объём цилиндра: " + String.format("%.4f", cylinder.volume()));
            } catch (RuntimeException e) {
                System.err.println("Не удалось создать цилиндр: " + e.getMessage());
            }
        }

        // 5. сохранение списка через сериализацию
        FigureStorage binaryStorage = new BinaryFigureStorage();
        try {
            binaryStorage.write(binPath, figures);
            System.out.println("Список сохранён в " + binPath.toAbsolutePath()); // возвращает путь
        } catch (IOException | storage.FigureStorageException e) {
            System.err.println("Ошибка записи бинарного файла: " + e.getMessage());
        }
    }

    private static double readHeight(Scanner scanner) {
        System.out.print("Введите высоту цилиндра: ");
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Некорректное число, попробуйте ещё раз: ");
            }
        }
    }
}
