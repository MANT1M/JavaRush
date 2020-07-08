package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {


    private static final TreeSet<Integer> countList = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            System.out.print(data + " ");
            countList.add(data);
        }
        System.out.println();
        //32 49 51 52 53 56
        for (int i : countList) {
            System.out.print(i + " ");
        }

        reader.close();
        inputStream.close();


    }
}
