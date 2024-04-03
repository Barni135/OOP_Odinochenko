package Src.ex4;

import java.util.List;

import Src.ex2_3.CalculationResult;

public class ResultProcessor {
    public static void main(String[] args, List<CalculationResult> results) {
        // Створення об'єктів результатів обчислень
        // ...

        // Отримання результатів у вигляді текстової таблиці
        String table = getResultsAsTextTable(results);
        System.out.println(table);
    }

    public static String getResultsAsTextTable(List<CalculationResult> results) {
        StringBuilder table = new StringBuilder();
        // Додайте заголовок таблиці
        table.append(String.format("%-15s%-15s%n", "Маса", "Швидкість"));

        // Додайте дані у вигляді рядків таблиці
        for (CalculationResult result : results) {
            table.append(String.format("%-15.2f%-15.2f%n", result.getMass(), result.getVelocity()));
        }

        return table.toString();
    }
}

