package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileProcessor {

    public static void processFiles(String[] files) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        TaskCounter counter = new TaskCounter();
        
        

        for (String file : files) {
            executorService.submit(
            		
            		()-> new FileTask(file, counter).process()
            		
            		);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All files processed.");
        System.out.println("Total files processed: " + counter.getCount());
    }
}

