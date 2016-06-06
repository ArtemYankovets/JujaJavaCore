package ua.com.juja.lab45;

import java.io.*;

public class ByteFilter {
    public static void filter(InputStream src, OutputStream dst, int bufferSize, byte filterCriteria) throws IOException {
        /*BODY*/

        byte[] buffer = new byte[bufferSize];

        while (src.read(buffer) != -1) {
            int startPos = 0;
            int len = 0;
            boolean isCalc = false;
            for (int i = 0; i < buffer.length; i++) {
                if ((buffer[i] != filterCriteria) && (!isCalc)) {
                    startPos = i;
                    len = 1;
                    isCalc = true;
                } else if ((buffer[i] != filterCriteria) && (isCalc)) {
                    len++;
                }

                if (((buffer[i] == filterCriteria) && (isCalc)) || ((i == buffer.length-1) && (isCalc))) {
                    dst.write(buffer, startPos, len);
                    isCalc = false;
                    len = 0;
                }
            }
            buffer = new byte[bufferSize];
        }

    }

}