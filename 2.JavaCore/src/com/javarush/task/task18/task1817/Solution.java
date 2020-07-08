package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int charCount;
        int spaceCount = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];

        if (fileInputStream.available() > 0) {
            //noinspection ResultOfMethodCallIgnored
            fileInputStream.read(buffer);
        }

        charCount = buffer.length;

        for (byte aBuffer : buffer) {
            if (aBuffer == 32) {
                spaceCount++;
            }
        }

        double x = ((double) spaceCount / (double) charCount) * 100;
        System.out.println(String.format("%.2f", x));
        fileInputStream.close();

    }

}