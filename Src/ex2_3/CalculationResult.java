package Src.ex2_3;

/**
 * Абстрактний клас, що представляє результат обчислень.
 */
public abstract class CalculationResult {
    protected double mass;
    protected double velocity;
    protected double kineticEnergy;
    protected double previousMass;
    protected double previousVelocity;
    protected double previousKineticEnergy;
    private String fileName;

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
        this.previousMass = mass;
        this.previousVelocity = velocity;
        this.previousKineticEnergy = kineticEnergy;
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

    /**
     * Збереження поточного стану для можливості скасування.
     */
    public void saveState() {
        previousMass = mass;
        previousVelocity = velocity;
        previousKineticEnergy = kineticEnergy;
    }

    /**
     * Відновлення попереднього стану після скасування.
     */
    public void restoreState() {
        mass = previousMass;
        velocity = previousVelocity;
        kineticEnergy = previousKineticEnergy;
    }

    /**
     * Масштабування результату.
     *
     * @param scaleFactor множник масштабу
     */
    public void scale(double scaleFactor) {
        mass *= scaleFactor;
        velocity *= scaleFactor;
        kineticEnergy = 0.5 * mass * velocity * velocity;
    }

    /**
     * Інтерполяція результату.
     */
    public void interpolate() {
        // Реалізуйте інтерполяцію відповідно до вашого контексту
    }

    /**
     * Відображення результату.
     */
    public abstract void displayResult();

    public void setMass(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMass'");
    }

    public void setVelocity(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVelocity'");
    }

    public void setKineticEnergy(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setKineticEnergy'");
    }

    public abstract void normalize();

    public abstract void sort();

    public void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    public String getFileName() {
        // Повернення імені файлу, пов'язаного з цим результатом обчислення
        return fileName;
    }
}
    
