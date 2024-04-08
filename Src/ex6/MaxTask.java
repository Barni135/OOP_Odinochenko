package Src.ex6;

import java.util.List;

public class MaxTask implements Runnable {
    private final List<Double> numbers;
    private double max;

    public MaxTask(List<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = numbers.stream().max(Double::compareTo).orElse(0.0);
        System.out.println("Максимум: " + max);
    }

    public double getMax() {
        return max;
    }
}
