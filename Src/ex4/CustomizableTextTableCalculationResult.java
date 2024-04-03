package Src.ex4;

import java.util.List;
import Src.ex2_3.CalculationResult;

/**
 * Клас, що представляє результати обчислень у вигляді текстової таблиці з налаштуваннями.
 */
public class CustomizableTextTableCalculationResult implements TextTableRepresentation {
    private String column1Header;
    private String column2Header;

    /**
     * Конструктор з параметрами, що встановлює заголовки стовпців таблиці.
     *
     * @param column1Header заголовок першого стовпця
     * @param column2Header заголовок другого стовпця
     */
    public CustomizableTextTableCalculationResult(String column1Header, String column2Header) {
        this.column1Header = column1Header;
        this.column2Header = column2Header;
    }

    /**
     * Повертає текстове представлення результатів обчислень у вигляді таблиці з налаштуваннями.
     *
     * @param results список результатів обчислень
     * @return текстове представлення у вигляді таблиці
     */
    public String getAsTextTable(List<CalculationResult> results) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("%-15s%-15s%n", column1Header, column2Header));

        for (CalculationResult result : results) {
            // Отримуйте масу та швидкість з CalculationResult
            double mass = (double) result.getMass();
            double velocity = (double) result.getVelocity();
            table.append(String.format("%-15.2f%-15.2f%n", mass, velocity));
        }

        return table.toString();
    }
}
