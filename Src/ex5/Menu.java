package Src.ex5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Src.ex2_3.CalculationResult;

/**
 * Клас, який представляє меню програми.
 */
public class Menu {
    private List<CalculationResult> resultList;
    private Map<String, Command> commands;

    /**
     * Конструктор класу Menu.
     */
    public Menu() {
        this.resultList = new ArrayList<>();
        this.commands = new HashMap<>();
    }

    /**
     * Додає результат обчислення до списку результатів у меню.
     * @param result Результат обчислення.
     */
    public void addResult(CalculationResult result) {
        resultList.add(result);
    }

    /**
     * Повертає список результатів обчислення.
     * @return Список результатів обчислення.
     */
    public List<CalculationResult> getResults() {
        return resultList;
    }

    /**
     * Видаляє результат обчислення з меню за заданим ім'ям файлу.
     * @param fileName Ім'я файлу з результатом обчислення.
     */
    public void deleteResult(String fileName) {
        CalculationResult resultToRemove = null;
        for (CalculationResult result : resultList) {
            if (result.getFileName().equals(fileName)) {
                resultToRemove = result;
                break;
            }
        }
        if (resultToRemove != null) {
            resultList.remove(resultToRemove);
            System.out.println("Результат " + fileName + " успішно видалено з меню.");
        } else {
            System.out.println("Не вдалося знайти результат " + fileName + " для видалення.");
        }
    }

    /**
     * Додає команду до меню за заданим ім'ям.
     * @param commandName Ім'я команди.
     * @param command Об'єкт команди.
     */
    public void setCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Повертає команду за заданим ім'ям.
     * @param commandName Ім'я команди.
     * @return Об'єкт команди або null, якщо команда не знайдена.
     */
    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
