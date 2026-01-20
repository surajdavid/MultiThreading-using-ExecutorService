package multithreading;

public class TaskCounter {

	private int count = 0;

    // synchronized method to avoid race condition
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
