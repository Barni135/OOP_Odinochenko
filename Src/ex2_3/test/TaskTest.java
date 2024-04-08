package Src.ex2_3.test;

import static org.junit.Assert.*;
import org.junit.Test;

import Src.ex6.AverageTask;
import Src.ex6.MaxTask;
import Src.ex6.MinTask;
import Src.ex6.WorkerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskTest {

    @Test
    public void testMinTask() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(20.0);
        numbers.add(5.0);
        
        MinTask minTask = new MinTask(numbers);
        minTask.run();

        // Перевірка, чи правильно знайдено мінімальне значення
        assertEquals(5.0, minTask.getMin(), 0.01);
    }

    @Test
    public void testMaxTask() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(20.0);
        numbers.add(5.0);
        
        MaxTask maxTask = new MaxTask(numbers);
        maxTask.run();

        // Перевірка, чи правильно знайдено максимальне значення
        assertEquals(20.0, maxTask.getMax(), 0.01);
    }

    @Test
    public void testAverageTask() {
        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(20.0);
        numbers.add(5.0);
        
        AverageTask averageTask = new AverageTask(numbers);
        averageTask.run();

        // Перевірка, чи правильно знайдено середнє значення
        assertEquals(11.666, averageTask.getAverage(), 0.01);
    }

    @Test
    public void testWorkerThread() throws InterruptedException {
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        List<Double> numbers = new ArrayList<>();
        numbers.add(10.0);
        numbers.add(20.0);
        numbers.add(5.0);

        taskQueue.add(new MinTask(numbers));
        taskQueue.add(new MaxTask(numbers));
        taskQueue.add(new AverageTask(numbers));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new WorkerThread(taskQueue));
        
        // Чекаємо, поки всі завдання не будуть виконані
        Thread.sleep(1000);

        // Перевірка, чи всі завдання виконані
        assertEquals(0, taskQueue.size());

        executorService.shutdown();
    }
}
