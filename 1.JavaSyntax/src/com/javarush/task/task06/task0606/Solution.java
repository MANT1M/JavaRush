package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String chislo = reader.readLine();
        int prChisla;
        char[] strToArray = chislo.toCharArray();
        for (int i = 0; i < strToArray.length; i++) {
            prChisla=Integer.parseInt(String.valueOf(strToArray[i]));
            if (prChisla%2==0){
                even++;
            }
            else odd++;
        }
        System.out.println("Even: "+even+" Odd: "+odd);
    }
}
