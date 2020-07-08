package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        File file1 = new File(filename1);
        File file2 = new File(filename2);

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);


        byte[] buffer1 = new byte[fileInputStream1.available()];
        byte[] buffer2 = new byte[fileInputStream2.available()];


        while (fileInputStream1.available()>0){
            fileInputStream1.read(buffer1);
        }
        while (fileInputStream2.available()>0){
            fileInputStream2.read(buffer2);
        }
        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        byte[] buffer3 = new byte[buffer1.length+buffer2.length];
        for (int i=0;i<buffer2.length;i++){
            buffer3[i]=buffer2[i];
            System.out.println("+buffer2 "+buffer3[i]);
        }
        for (int i=0;i<buffer1.length;i++){
            buffer3[buffer2.length+i]=buffer1[i];
            System.out.println("+buffer1 "+ buffer3[buffer2.length+i]);
        }
        System.out.println(new File(".").getAbsolutePath());

        fileOutputStream1.write(buffer3);
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream1.close();
        //F:\java\1\1.txt
        //F:\java\1\2.txt
        //F:\java\1\3.txt
        //F:\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1819\

    }
}
