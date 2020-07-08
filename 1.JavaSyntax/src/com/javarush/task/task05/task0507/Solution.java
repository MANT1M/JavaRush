package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double result=0.0, sredArif=0.0,ink=0.0;
        String s=reader.readLine();

        while (Double.parseDouble(s)!=-1){
            result+=Double.parseDouble(s);
            ink++;
            s=reader.readLine();
        }
        sredArif=result/ink;
        System.out.println(sredArif);

    }
}

