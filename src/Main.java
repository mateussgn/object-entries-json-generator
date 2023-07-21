import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String fileName = "subjectEntriesMock.json";
        _createFile(fileName);
        _writeFile(fileName);
    }

    private static void _createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void _writeFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("[\n");
            for (int i = 0; i < 1000; i++) {
                if (i == (1000 - 1)) {
                    fileWriter.write("{\"name\": \"Subject" + i + "\"}\n");
                } else {
                    fileWriter.write("{\"name\": \"Subject" + i + "\"},\n");
                }
            }
            fileWriter.write("]");
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}