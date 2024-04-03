package Src.ex2_3;

/**
 * Клас, який вирішує проблему, використовуючи фабрику результатів обчислень.
 */
public class ProblemSolver {
    private ResultFactory factory; // Фабрика результатів обчислень

    /**
     * Конструктор для створення об'єкта ProblemSolver з вказаною фабрикою результатів обчислень.
     *
     * @param factory фабрика результатів обчислень
     */
    public ProblemSolver(ResultFactory factory) {
        this.factory = factory;
    }

    /**
     * Розв'язує проблему з вказаною масою та швидкістю, використовуючи фабрику результатів обчислень.
     *
     * @param mass     маса об'єкта
     * @param velocity швидкість об'єкта
     * @return результат обчислень
     */
    public CalculationResult solveProblem(double mass, double velocity) {
        return factory.create(mass, velocity);
    }
}

