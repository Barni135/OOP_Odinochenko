package Src.ex4;

import Src.ex2_3.CalculationResult;

import java.util.List;

/**
 * Клас, що представляє результати обчислень у вигляді текстової таблиці.
 */
public class TextTableCalculationResult {

    /**
     * Повертає текстове представлення результатів обчислень у вигляді таблиці.
     *
     * @param results список результатів обчислень
     * @return текстове представлення у вигляді таблиці
     */
    public static String getAsTextTable(List<CalculationResult> results) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("+---------------+---------------+-----------------+-----------------+%n"));
        table.append(String.format("| Маса          | Швидкість     | Кінетична енергія | Двійкове уявлення |%n"));
        table.append(String.format("+---------------+---------------+-----------------+-----------------+%n"));

        for (CalculationResult result : results) {
            // Перетворення Object на double для getMass()
            double mass = (Double) result.getMass();
            // Перетворення Object на double для getVelocity()
            double velocity = (Double) result.getVelocity();
            double kineticEnergy = 0.5 * mass * velocity * velocity;
            String binaryRepresentation = Integer.toBinaryString((int) kineticEnergy);

            table.append(String.format("| %-13.2f | %-13.2f | %-15.2f | %-15s |%n", mass, velocity, kineticEnergy, binaryRepresentation));
        }

        table.append(String.format("+---------------+---------------+-----------------+-----------------+%n"));

        return table.toString();
    }
}
