package Src.ex2_3.test;

import Src.ex2_3.BasicCalculationResult;
import Src.ex2_3.CalculationResult;
import Src.ex2_3.CalculationResultFactory;
import Src.ex2_3.ResultFactory;
import Src.ex4.TextTableCalculationResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для тестування.
 */
public class Test {

    /**
     * Метод main, який є точкою входу в програму.
     *
     * @param args масив аргументів командного рядка
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ResultFactory factory = new CalculationResultFactory(null);

            // Введення даних з клавіатури
            System.out.print("Введіть масу об'єкта: ");
            double mass = scanner.nextDouble();

            System.out.print("Введіть швидкість об'єкта: ");
            double velocity = scanner.nextDouble();

            // Розв'язання задачі та створення результату
            CalculationResult result = factory.create(mass, velocity);

            // Виведення результату у вигляді текстової таблиці
            displayResults(result, scanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Виведення результату та запит на збереження.
     *
     * @param result  результат обчислень
     * @param scanner об'єкт для зчитування введення користувача
     * @throws IOException виняток, який виникає при роботі з файлами
     */
    private static void displayResults(CalculationResult result, Scanner scanner) throws IOException {
        System.out.println("Маса: " + result.getMass());
        System.out.println("Швидкість: " + result.getVelocity());
        System.out.println("Кінетична енергія: " + result.getKineticEnergy());

        // Виведення результату у вигляді текстової таблиці
        List<CalculationResult> resultList = new ArrayList<>();
        resultList.add(result);
        String table = TextTableCalculationResult.getAsTextTable(resultList);
        System.out.println(table);

        // Запит на збереження даних
        System.out.print("Зберегти результат (Так/Ні)? ");
        String saveChoice = scanner.next();
        if (saveChoice.equalsIgnoreCase("Так")) {
            saveToFile(result, scanner);
            System.out.println("Результати збережено.");
        } else {
            System.out.println("Результати не збережено.");
        }

        // Запит на вивід збережених даних
        System.out.print("Вивести збережені дані (Так/Ні)? ");
        String printChoice = scanner.next();
        if (printChoice.equalsIgnoreCase("Так")) {
            System.out.print("Введіть назву файлу для виводу збережених даних: ");
            String fileName = scanner.next();
            printSavedData(fileName);
        }
    }

    /**
     * Збереження результату у файл.
     *
     * @param result  результат обчислень
     * @param scanner об'єкт для зчитування введення користувача
     * @throws IOException виняток, який виникає при роботі з файлами
     */
    private static void saveToFile(CalculationResult result, Scanner scanner) throws IOException {
        System.out.print("Введіть назву файлу для збереження: ");
        String fileName = scanner.next();
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.format("Маса: %.2f%n", result.getMass()));
            writer.write(String.format("Швидкість: %.2f%n", result.getVelocity()));
            writer.write(String.format("Кінетична енергія: %.2f%n", result.getKineticEnergy()));
        }
    }

    /**
     * Вивід збережених даних з файлу у вигляді таблиці.
     *
     * @param fileName назва файлу збережених даних
     * @throws IOException виняток, який виникає при роботі з файлами
     */
    private static void printSavedData(String fileName) throws IOException {
        List<CalculationResult> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            double mass = 0.0;
            double velocity = 0.0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(": ");
                if (data.length == 2) {
                    String value = data[1].trim();
                    if (data[0].equalsIgnoreCase("Маса")) {
                        mass = Double.parseDouble(value);
                    } else if (data[0].equalsIgnoreCase("Швидкість")) {
                        velocity = Double.parseDouble(value);
                    }
                }
            }
            // Створення об'єкта підкласу BasicCalculationResult з усіма необхідними даними
            BasicCalculationResult calculationResult = new BasicCalculationResult(mass, velocity);
            resultList.add(calculationResult);
        }

        // Виведення збережених даних у вигляді текстової таблиці
        String table = TextTableCalculationResult.getAsTextTable(resultList);
        System.out.println(table);
    }
}
