package Src.ex2_3;

import java.util.List;
import java.util.Scanner;

import Src.ex4.TextTableCalculationResult;

/**
 * Клас, який надає консольний інтерфейс для взаємодії з користувачем.
 */
public class ConsoleInterface {

    /**
     * Головний метод програми, який взаємодіє з користувачем через консоль.
     *
     * @param args аргументи командного рядка (не використовуються)
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

            // Виведення результату на екран у вигляді таблиці
            System.out.println(TextTableCalculationResult.getAsTextTable(List.of(result)));
        }
    }
}
