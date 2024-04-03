package Src.ex2_3;

import java.io.Serializable;

/**
 * Абстрактний клас, що представляє результат обчислень.
 */
public abstract class CalculationResult implements Serializable {
    protected double mass;
    protected double velocity;
    protected double kineticEnergy;

    /**
     * Конструктор без параметрів.
     */
    public CalculationResult() {
        this.mass = 0.0;
        this.velocity = 0.0;
        this.kineticEnergy = 0.0;
    }

    /**
     * Конструктор для створення об'єкта CalculationResult з вказаною масою та швидкістю.
     *
     * @param mass     маса об'єкта
     * @param velocity швидкість об'єкта
     */
    public CalculationResult(double mass, double velocity) {
        this.mass = mass;
        this.velocity = velocity;
        this.kineticEnergy = 0.5 * mass * velocity * velocity;
    }

    /**
     * Метод для відображення результату обчислень.
     */
    public abstract void displayResult();
}
