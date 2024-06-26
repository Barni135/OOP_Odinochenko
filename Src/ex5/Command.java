package Src.ex5;

/**
 * Інтерфейс команди, яка визначає методи для виконання та скасування команди.
 */
public interface Command {
    /**
     * Виконує команду.
     */
    void execute();

    /**
     * Скасовує виконану команду.
     */
    void undo();
}

