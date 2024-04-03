package Src.ex2_3.test;


import Src.ex2_3.ConsoleInterface;
import Src.ex2_3.CalculationResultFactory;
import Src.ex2_3.ResultFactory;
import Src.ex2_3.UserInterface;

/**
 * Клас для тестування.
 */
public class Test {
    public static void main(String[] args) {
        ResultFactory factory = new CalculationResultFactory();
        UserInterface ui = new UserInterface(factory);

        // Приклад використання
        ui.performCalculationAndDisplayResult(10.0, 20.0);

        // Викликаємо метод main класу ConsoleInterface
        ConsoleInterface.main(args);
    }
}


