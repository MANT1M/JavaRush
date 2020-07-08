package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
        String nameFil1 = bfrd.readLine();
        String nameFil2 = bfrd.readLine();
        bfrd.close();

        BufferedReader bufRead = new BufferedReader(new FileReader(nameFil1));
        BufferedWriter bufWrite = new BufferedWriter(new FileWriter(nameFil2));

        StringBuilder str = new StringBuilder();
        while (bufRead.ready()) //пока есть непрочитанные байты в потоке ввода
        {

            str.append(bufRead.readLine());
            //int data = bufRead.read(); //читаем один символ (char будет расширен до int)
            //str = str + (char)data;

        }
        bufRead.close();
        String str1 = str.toString();
        String d;
        System.out.println(str1);
        d=str1.replaceAll("\\.", "!");
        //str1.replaceAll("[.]", "!");


        bufWrite.write(d);

        bufWrite.close();
    }
}