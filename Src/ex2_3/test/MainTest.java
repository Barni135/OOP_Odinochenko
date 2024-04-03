package Src.ex2_3.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Src.ex2_3.BasicCalculationResult;
import Src.ex2_3.CalculationResult;
import Src.ex2_3.CalculationResultFactory;
import Src.ex2_3.ResultFactory;
import Src.ex4.TextTableCalculationResult;

/**
 * Клас, що містить тести для всіх класів програми.
 */
@SuppressWarnings("unused")
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
        CalculationResultFactory factory = new CalculationResultFactory(null);
        BasicCalculationResult result = (BasicCalculationResult) factory.create(10.0, 20.0);
        assertEquals(10.0, result.getMass(), 0.0);
        assertEquals(20.0, result.getVelocity(), 0.0);
    }

    /**
     * Тестує клас TextTableCalculationResult.
     */
    @Test
    public void testTextTableCalculationResult() {
        // Перевірка створення таблиці з вказаними параметрами
        // Перевірка коректності виведення результатів
    }

}
