package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей,
данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла,
парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("d:\\1.txt"));
        PersonScanner adapter = new PersonScannerAdapter(s);
        System.out.println(adapter.read());
        adapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() {
            if (fileScanner.hasNext()) {
                String[] inputArray = fileScanner.nextLine().split(" ");
                Date birthDate = (new GregorianCalendar(Integer.parseInt(inputArray[5]),
                        Integer.parseInt(inputArray[4]) - 1, Integer.parseInt(inputArray[3]))).getTime();
                return new Person(inputArray[1], inputArray[2], inputArray[0], birthDate);
            }
            return null;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}



