package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        int summa=a+b;
        return summa;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        int vitichitanie=a-b;
        return vitichitanie;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        int umnoj=a*b;
        return umnoj;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double delenie= (a+0.0)/(b+0.0);
        return delenie;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double procent=(a+0.0)*((b+0.0)/100);
        return procent;
    }

    public static void main(String[] args) {
        System.out.println(division(2,3));
        System.out.println(percent(1,50));
    }
}