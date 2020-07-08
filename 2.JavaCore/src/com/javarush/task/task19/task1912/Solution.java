package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //Запоминаем настоящий PrintStream  в специальную переменную
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

        StringBuilder stringBuilder = new StringBuilder(result.replaceAll("te", "??"));

        String reverseString = stringBuilder.toString();

        //выводим ее в консоль
        System.out.println(reverseString);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
