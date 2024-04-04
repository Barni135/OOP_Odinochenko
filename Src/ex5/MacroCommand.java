package Src.ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який представляє макрокоманду, що складається з декількох окремих команд.
 */
public class MacroCommand implements Command {
    private List<Command> commands;

    /**
     * Конструктор класу MacroCommand.
     */
    public MacroCommand() {
        this.commands = new ArrayList<>();
    }

    /**
     * Додає команду до макрокоманди.
     * @param command Додавана команда.
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Видаляє команду з макрокоманди.
     * @param command Видаляєма команда.
     */
    public void removeCommand(Command command) {
        commands.remove(command);
    }

    /**
     * Виконує всі команди макрокоманди.
     */
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    /**
     * Скасовує виконані команди макрокоманди в зворотньому порядку.
     */
    @Override
    public void undo() {
        // Виконуємо скасування команд у зворотньому порядку
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
