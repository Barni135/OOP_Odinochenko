package Src.ex2_3;

/**
 * Підклас класу CalculationResult, що представляє базовий результат обчислень.
 */
public class BasicCalculationResult extends CalculationResult {

    /**
     * Конструктор з параметрами.
     *
     * @param mass     маса об'єкта
     * @param velocity швидкість об'єкта
     */
    public BasicCalculationResult(double mass, double velocity) {
        super(mass, velocity);
    }

    @Override
    public void displayResult() {
        // TODO: Implement displayResult method
        System.out.println("Mass: " + mass);
        System.out.println("Velocity: " + velocity);
        System.out.println("Kinetic Energy: " + kineticEnergy);
    }
}
