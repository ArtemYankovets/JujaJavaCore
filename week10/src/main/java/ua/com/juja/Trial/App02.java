package ua.com.juja.Trial;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class App02 {
    public static void main(String[] args) throws IOException {

//        URL url = new URL("http://dom2.ru");
//        InputStream src = url.openConnection().getInputStream();
//        OutputStream dest = url.openConnection().getOutputStream();

        InputStream src = new URL("http://dom2.ru").openStream();

//        OutputStream dst = new FileOutputStream("d:/tmp/GOOGLE.txt");
        copy(src, System.out);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        byte[] buff = new byte[64 * 1024];
        while (true) {
            int count = src.read(buff);
            if (count != -1) {
                dst.write(buff, 0, count);
            } else {
                return;
            }
        }
    }
}
