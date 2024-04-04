package Src.ex5;

import Src.ex2_3.CalculationResult;

/**
 * Клас, який представляє команду масштабування результату обчислення.
 */
public class ScaleCommand implements Command {
    private CalculationResult result;
    private double scaleFactor;
    private double inverseScaleFactor;

    /**
     * Конструктор класу ScaleCommand.
     * @param result Результат обчислення, який буде масштабований.
     * @param scaleFactor Коефіцієнт масштабування.
     */
    public ScaleCommand(CalculationResult result, double scaleFactor) {
        this.result = result;
        this.scaleFactor = scaleFactor;
        this.inverseScaleFactor = 1.0 / scaleFactor;
    }

    /**
     * Статичний метод для створення єдиного екземпляру класу.
     * @param result Результат обчислення, який буде масштабований.
     * @param scaleFactor Коефіцієнт масштабування.
     * @return Об'єкт класу ScaleCommand.
     */
    public static ScaleCommand createInstance(CalculationResult result, double scaleFactor) {
        return new ScaleCommand(result, scaleFactor);
    }

    /**
     * Виконує масштабування результату обчислення.
     */
    @Override
    public void execute() {
        // Виконати масштабування
        result.setMass(result.getMass() * scaleFactor);
        result.setVelocity(result.getVelocity() * scaleFactor);
        result.setKineticEnergy(result.getKineticEnergy() * scaleFactor);
    }

    /**
     * Скасовує масштабування результату обчислення.
     */
    @Override
    public void undo() {
        // Скасувати масштабування
        result.setMass(result.getMass() * inverseScaleFactor);
        result.setVelocity(result.getVelocity() * inverseScaleFactor);
        result.setKineticEnergy(result.getKineticEnergy() * inverseScaleFactor);
    }
}
