package multithreading;

public class Main {
	public static void main(String[] args) {

        String[] files = {
                "file1.txt",
                "file2.txt",
                "file3.txt",
                "file4.txt",
                "file5.txt"
        };

        FileProcessor.processFiles(files);
    }

}
