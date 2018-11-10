import java.io.*;

public class Files {
    public static void writeToFile(String json, String path) throws IOException {
        // Saving data
        FileWriter writer = new FileWriter(path);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public static String readFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String json = reader.readLine();
        return json;
    }
}
