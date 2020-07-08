package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* 
Задача по алгоритмам Ӏ Java Syntax: 8 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String word : array) {

            System.out.println(word);
        }
    }
    String wors1;
    public static void sort(String[] array) {
        //напишите тут ваш код
        String stroka1=null;
        boolean sortArray=true;
        while (sortArray){
            sortArray=false;
        for (int i = 0; i <array.length-1 ; i++) {

            if (isGreaterThan(array[i], array[i+1])) {

                stroka1 = array[i];
                array[i] = array[i+1];
                array[i+1] = stroka1;
                sortArray=true;

            }

        }


        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
