package Src.ex6;

import java.util.List;

public class MinTask implements Runnable {
    private final List<Double> numbers;
    private double min;

    public MinTask(List<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = numbers.stream().min(Double::compareTo).orElse(0.0);
        System.out.println("Мінімум: " + min);
    }

    public double getMin() {
        return min;
    }
}
