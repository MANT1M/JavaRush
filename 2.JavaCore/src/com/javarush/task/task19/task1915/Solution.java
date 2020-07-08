package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File nFile = new File(reader.readLine());
        FileOutputStream wr = new FileOutputStream(nFile);
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
        System.out.println(result);
        //Возвращаем все как было
        System.setOut(consoleStream);

        StringBuilder stringBuilder = new StringBuilder(result);
        String s = stringBuilder.toString();
        System.out.println(s);
        wr.write(s.getBytes());
        reader.close();
        wr.close();
        // F:\java\2.txt
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

