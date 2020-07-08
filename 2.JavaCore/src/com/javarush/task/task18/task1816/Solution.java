package com.javarush.task.task18.task1816;

/* 
Английские буквы
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        int charCount = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];

        if (fileInputStream.available() > 0) {
            //noinspection ResultOfMethodCallIgnored
            fileInputStream.read(buffer);
        }

        for (byte aBuffer : buffer) {
            if ((aBuffer > 64 && aBuffer < 91) || (aBuffer > 96 && aBuffer < 123)) {
                charCount++;
            }
        }

        System.out.print(charCount);
    }
}
