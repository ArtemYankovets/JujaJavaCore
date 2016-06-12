package ua.com.juja.io;

import java.io.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/27/14
 * Time: 8:47 PM
 */
public class ReaderWriterDemo {
    private static String srcPath = "week10\\tmp\\text.txt";
    private static String dstPath = "week10\\tmp\\copy_text.txt";

    public static void main(String[] args) throws IOException {
//        System.out.println(readFromString());
//        System.out.println(readFromFile());
//        System.out.println(readFromFileByLines());

        copyFromFileToFileWithReaderAndWriter(srcPath, dstPath);
        String line = "";

        while (!line.equals("\\q")) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            line = reader.readLine();
            System.out.println("User entered " + line);
        }

    }

    private static void copyFromFileToFileWithReaderAndWriter(String source, String dest) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.append(line + " {writer}");
            writer.newLine();
            writer.flush();
        }
//        writer.flush();
        writer.close();
    }

    private static String readFromFileByLines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        StringBuilder text = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            text.append(line).append("\n");
        }
        reader.close();
        return text.toString();

    }

    private static String readFromFile() throws IOException {
        FileReader fileReader = new FileReader(srcPath);
        char[] buffer = new char[32];
        StringBuilder text = new StringBuilder();
        while (fileReader.read(buffer) != -1) {
            System.out.println(Arrays.toString(buffer));
            text.append(buffer);
            buffer = new char[32];
        }
        return text.toString();
    }

    private static String readFromString() throws IOException {
        Reader reader = new StringReader("Джуджа");
        char[] chars = new char[100];
        reader.read(chars);
        System.out.println(Arrays.toString(chars));
        return new String(chars);
    }
}