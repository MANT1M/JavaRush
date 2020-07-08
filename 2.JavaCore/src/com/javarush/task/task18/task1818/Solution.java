package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();

        File file2 = new File(name2);
        File file3 = new File(name3);
        File file1 = new File(name1);

        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);

        byte[] buffer2 = new byte[fileInputStream2.available()];
        byte[] buffer3 = new byte[fileInputStream3.available()];
        byte[] buffer1 = new byte[buffer2.length+buffer3.length];
        while (fileInputStream2.available()>0){
            fileInputStream2.read(buffer2);
        }
        while (fileInputStream3.available()>0){
            fileInputStream3.read(buffer3);
        }


            for (int i=0;i<buffer2.length;i++){
                buffer1[i]=buffer2[i];
            }
        for (int i=0;i<buffer3.length;i++){
            buffer1[buffer2.length+i]=buffer3[i];
        }
        fileOutputStream1.write(buffer1);
        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream1.close();
        //F:\java\1\1.txt
        //F:\java\1\2.txt
        //F:\java\1\3.txt


    }
}
