package Src.ex6;

import java.util.List;

public class AverageTask implements Runnable {
    private final List<Double> numbers;
    private double average;

    public AverageTask(List<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        average = sum / numbers.size();
        System.out.println("Середнє значення: " + average);
    }

    public double getAverage() {
        return average;
    }
}
