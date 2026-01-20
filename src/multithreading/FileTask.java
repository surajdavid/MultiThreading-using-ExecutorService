package multithreading;

public class FileTask implements Runnable {

    private final String fileName;
    private final TaskCounter counter;

    public FileTask(String fileName, TaskCounter counter) {
        this.fileName = fileName;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " started processing " + fileName);

        try {
            // simulate file processing time
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        counter.increment();

        System.out.println(Thread.currentThread().getName()
                + " finished processing " + fileName);
    }
}
