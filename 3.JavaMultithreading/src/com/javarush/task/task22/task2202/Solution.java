package com.javarush.task.task22.task2202;

import java.util.ArrayList;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));

        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString(null));

    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int count = 0;
        int index = string.indexOf(" ");
        //int index2 = string.in
        int index2 = 0;
        char[] a = string.toCharArray();
        for(int i=0; i < a.length; i++)
        {
            if(String.valueOf(a[i]).equals(" "))
            {
                count++;
            }
            if(count == 4)
            {
                index2 = i;
            }
        }
        if (count < 4) {
            throw new TooShortStringException();
        }
        string = string.substring(index+1, index2+1);
        return string;
    }
    public static class TooShortStringException  extends RuntimeException{
    }
}
