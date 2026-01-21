package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileProcessor {

    public static void processFiles(String[] files) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        TaskCounter counter = new TaskCounter();

        for (String file : files) {
            executorService.submit(new FileTask(file, counter));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // wait for all tasks to finish
        }
        

        System.out.println("All files processed.");
        System.out.println("Total files processed: " + counter.getCount());
    }
}

