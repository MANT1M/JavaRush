package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        StringBuilder stringBuilder = new StringBuilder(result);
        Pattern p1 = Pattern.compile("[0-9]+");
        Matcher m1 = p1.matcher(stringBuilder);
        while (m1.find()){

            System.out.print(m1.group());
        }
        /*String reverseString = stringBuilder.toString();

        //выводим ее в консоль
        System.out.println(reverseString);*/
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
