package multithreading;

public class FileTask {

    private final String fileName;
    private final TaskCounter counter;

    public FileTask(String fileName, TaskCounter counter) {
        this.fileName = fileName;
        this.counter = counter;
    }

   
    public void process() {
    	
    	long start = System.currentTimeMillis();
    	
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
        
        long end = System.currentTimeMillis();

        System.out.println(Thread.currentThread().getName()
                + " processed " + fileName + " in " + (end - start) + " ms");
    }
}
