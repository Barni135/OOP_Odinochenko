package Src.ex2_3;

/**
 * Абстрактний клас, що представляє результат обчислень.
 */
public abstract class CalculationResult {
    protected double mass;
    protected double velocity;
    protected double kineticEnergy;

    /**
     * Конструктор з параметрами.
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
     * Повертає масу об'єкта.
     *
     * @return маса об'єкта
     */
    public double getMass() {
        return mass;
    }

    /**
     * Повертає швидкість об'єкта.
     *
     * @return швидкість об'єкта
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Повертає кінетичну енергію об'єкта.
     *
     * @return кінетична енергія об'єкта
     */
    public double getKineticEnergy() {
        return kineticEnergy;
    }

    public abstract void displayResult();
}
