package Src.ex2_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Src.ex4.TextTableRepresentation;

/**
 * Конкретна реалізація ResultFactory для CalculationResult.
 */
public class CalculationResultFactory implements ResultFactory {
    /**
     * Конструктор з параметром, що встановлює тип представлення результатів обчислень.
     *
     * @param textTableRepresentation об'єкт, що реалізує представлення результатів у вигляді текстової таблиці
     */
    public CalculationResultFactory(TextTableRepresentation textTableRepresentation) {
    }

    // Реалізація методів create, saveResultsToFile та loadResultsFromFile

    /**
     * Створює об'єкт результату обчислень з вказаною масою та швидкістю.
     *
     * @param mass     маса об'єкта
     * @param velocity швидкість об'єкта
     * @return об'єкт результату обчислень
     */
    @Override
    public CalculationResult create(double mass, double velocity) {
        return new BasicCalculationResult(mass, velocity);
    }

    /**
     * Зберігає результати обчислень у файлі.
     *
     * @param results  список результатів обчислень
     * @param filename назва файлу
     */
    @Override
    public void saveResultsToFile(List<CalculationResult> results, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(results);
            System.out.println("Результати збережені у файлі " + filename);
        } catch (IOException e) {
            System.out.println("Помилка під час збереження результатів у файл " + filename);
            e.printStackTrace();
        }
    }

    /**
     * Відновлює результати обчислень з файлу.
     *
     * @param filename назва файлу
     * @return список результатів обчислень
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<CalculationResult> loadResultsFromFile(String filename) {
        List<CalculationResult> loadedResults = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            loadedResults = (List<CalculationResult>) inputStream.readObject();
            System.out.println("Результати успішно відновлені з файлу " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка під час завантаження результатів з файлу " + filename);
            e.printStackTrace();
        }
        return loadedResults;
    }

    /**
     * Повертає текстове представлення результатів обчислень у вигляді таблиці.
     *
     * @param results список результатів обчислень
     * @return текстове представлення у вигляді таблиці
     */
    public String getResultsAsTextTable(List<CalculationResult> results) {
        return TextTableRepresentation.getAsTextTable(results);
    }
}
