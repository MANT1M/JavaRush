package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] massiv= new int[15];
        int chet=0,nechet=0;
        for (int i = 0; i <massiv.length ; i++) {
            massiv[i]= Integer.parseInt(reader.readLine());
        if (i%2==0)
            chet=chet+massiv[i];
        else nechet+=massiv[i];

        }
        if (chet>nechet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
