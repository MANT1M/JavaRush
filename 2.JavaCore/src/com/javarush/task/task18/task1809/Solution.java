package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Считываем имена файлов
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) {
            //noinspection ResultOfMethodCallIgnored
            fileInputStream.read(buffer);
        }
        // Записываем в обратном порядке
        byte[] buffer2 = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            buffer2[i] = buffer[buffer.length - 1 - i];
        }
        fileOutputStream2.write(buffer2);
        fileInputStream.close();

        fileOutputStream2.close();
    }
}