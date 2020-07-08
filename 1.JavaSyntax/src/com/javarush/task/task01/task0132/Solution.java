package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String s=null;
        int sumChisel=0;
        s=""+ number;
        char[] strToArray = s.toCharArray();
        for (int i = 0; i < strToArray.length; i++) {
            sumChisel=sumChisel+Integer.parseInt(String.valueOf(strToArray[i]));
        }
        return sumChisel;

    }
}