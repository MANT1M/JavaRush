package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
if (string.indexOf("\t")==string.lastIndexOf("\t")){
            throw new TooShortStringException();
        }
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result = null;
        if (string==null)
            throw new TooShortStringException();
        int first = string.indexOf("\t");
        if (first==-1)
            throw new TooShortStringException();
        String s1 = string.substring(first+1);
        String[] s = string.split("\t");
        if (s.length<3)
            throw new TooShortStringException();
        result=s[1];
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
