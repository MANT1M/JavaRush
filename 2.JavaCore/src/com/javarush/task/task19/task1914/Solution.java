package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
      /*  //Запоминаем настоящий PrintStream  в специальную переменную
        PrintStream consoleStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Установливаем его как текущй System.out
        System.setOut(stream);
        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();
        //Преобразлвываем записанные в наш ByteArray данные в строкущрщшо
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);
        int x=0;
        StringBuilder stringBuilder = new StringBuilder(result);
        Pattern p1 = Pattern.compile("([0-9]+)|(\\+)|(-)|(\\*)|(=)");
        Matcher m1 = p1.matcher(stringBuilder);
        Pattern p2 = Pattern.compile("([0-9]+)");
        Matcher m2 = p2.matcher(stringBuilder);
        String[] k = result.split(" ");


        switch (Character.toString(stringBuilder.charAt(2))){
            case "+":
                x = Integer.parseInt(k[0]) + Integer.parseInt(k[2]);
                break;
            case "-":
                x = Integer.parseInt(k[0]) - Integer.parseInt(k[2]);
                break;
            case "*":
                x = Integer.parseInt(k[0]) * Integer.parseInt(k[2]);
                break;
            default:
                x = -1;
                break;

        }



        while (m1.find()){

            System.out.print(m1.group()+" ");
        }
        System.out.print(x);*/
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);

        testString.printSomething();
        String string = baos.toString().trim();
        String[] strMas = string.split(" ");
        int x;
        switch (strMas[1]) {
            case "+":
                x = Integer.parseInt(strMas[0]) + Integer.parseInt(strMas[2]);
                break;
            case "-":
                x = Integer.parseInt(strMas[0]) - Integer.parseInt(strMas[2]);
                break;
            case "*":
                x = Integer.parseInt(strMas[0]) * Integer.parseInt(strMas[2]);
                break;
            default:
                x = -1;
                break;
        }

        System.setOut(consoleStream);
        System.out.println(string + " " + x);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

