package Src.ex2_3.test;

import static org.junit.Assert.*;
import org.junit.Test;

import Src.ex2_3.CalculationResult;
import Src.ex5.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що містить тести для класів MacroCommand та Menu.
 */
@SuppressWarnings("unused")
public class CommandTest {

    /**
     * Тестує клас MacroCommand.
     */
    @Test
    public void testMacroCommand() {
        // Створення двох фіктивних команд
        MockCommand command1 = new MockCommand();
        MockCommand command2 = new MockCommand();

        // Створення макрокоманди та додавання до неї команд
        MacroCommand macroCommand = new MacroCommand();
        macroCommand.addCommand(command1);
        macroCommand.addCommand(command2);

        // Виклик методу execute макрокоманди
        macroCommand.execute();

        // Перевірка, що метод execute викликався на кожній окремій команді
        assertTrue(command1.isExecuted());
        assertTrue(command2.isExecuted());

        // Виклик методу undo макрокоманди
        macroCommand.undo();

        // Перевірка, що метод undo викликався на кожній окремій команді
        assertTrue(command1.isUndone());
        assertTrue(command2.isUndone());
    }

    /**
     * Тестує клас Menu.
     */
    @Test
    public void testMenu() {
        // Створення меню
        Menu menu = new Menu();

        // Створення фіктивного результату обчислення
        CalculationResult result = new CalculationResult(0, 0) {
            @Override
            public double getMass() {
                return 10.0;
            }

            @Override
            public double getVelocity() {
                return 20.0;
            }

            @Override
            public double getKineticEnergy() {
                return 0.0;
            }

            @Override
            public String getFileName() {
                return "test_result";
            }

            @Override
            public void displayResult() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'displayResult'");
            }

            @Override
            public void normalize() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'normalize'");
            }

            @Override
            public void sort() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'sort'");
            }
        };

        // Додавання результату до меню
        menu.addResult(result);

        // Перевірка, чи був результат доданий до меню
        List<CalculationResult> resultList = menu.getResults();
        assertEquals(1, resultList.size());
        assertEquals(result, resultList.get(0));

        // Видалення результату з меню
        menu.deleteResult("test_result");

        // Перевірка, чи був результат видалений з меню
        resultList = menu.getResults();
        assertEquals(0, resultList.size());
    }

    /**
     * Фіктивний клас для тестування макрокоманди.
     */
    private static class MockCommand implements Command {
        private boolean executed;
        private boolean undone;

        @Override
        public void execute() {
            executed = true;
        }

        @Override
        public void undo() {
            undone = true;
        }

        public boolean isExecuted() {
            return executed;
        }

        public boolean isUndone() {
            return undone;
        }
    }
}
