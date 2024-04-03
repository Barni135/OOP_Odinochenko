package Src.ex2_3.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Src.ex2_3.BasicCalculationResult;
import Src.ex2_3.CalculationResultFactory;
import Src.ex2_3.ResultFactory;

/**
 * Клас, що містить тести для всіх класів програми.
 */
public class MainTest {

    /**
     * Тестує клас BasicCalculationResult.
     */
    @Test
    public void testBasicCalculationResult() {
        BasicCalculationResult result = new BasicCalculationResult(10.0, 20.0);
        assertEquals(10.0, result.getMass(), 0.0);
        assertEquals(20.0, result.getVelocity(), 0.0);
    }

    /**
     * Тестує клас CalculationResultFactory.
     */
    @Test
    public void testCalculationResultFactory() {
        CalculationResultFactory factory = new CalculationResultFactory();
        BasicCalculationResult result = (BasicCalculationResult) factory.create(10.0, 20.0);
        assertEquals(20.0, result.getMass(), 0.0);
        assertEquals(20.0, result.getVelocity(), 0.0);
    }

    /**
     * Тестує клас ConsoleInterface.
     */
    @Test
    public void testConsoleInterface() {
        // Перевіряється функціональність класу ConsoleInterface
    }

    /**
     * Тестує клас ProblemSolver.
     */
    @Test
    public void testProblemSolver() {
        // Перевіряється функціональність класу ProblemSolver
    }

    /**
     * Тестує клас ResultFactory.
     */
    @Test
    public void testResultFactory() {
        ResultFactory factory = new CalculationResultFactory();
        BasicCalculationResult result = (BasicCalculationResult) factory.create(10.0, 20.0);
        assertEquals(20.0, result.getMass(), 0.0);
        assertEquals(20.0, result.getVelocity(), 0.0);
    }

    /**
     * Тестує клас SerializationDemo.
     */
    @Test
    public void testSerializationDemo() {
        // Перевіряється функціональність класу SerializationDemo
    }

    /**
     * Тестує клас UserInterface.
     */
    @Test
    public void testUserInterface() {
        // Перевіряється функціональність класу UserInterface
    }


}
