package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileWriter fos = new FileWriter(reader.readLine());
        reader.close();
        String number = "";
        // пока в нашем входном потоке есть данные, читаем
        // когда в потоке не останется данных, будет возвращено значение -1
        while (fis.available() > 0) {
            // объявляем переменную и присваиваем ей первое значение, которое у нас пришло
            // в нашем примере это 3 и делаем явный кастинг к char
            char ch =(char) fis.read();
            // проверяем является ли пробелом, нет, тогда number присваиваем 3
            // обрати внимание, что тут не числами, а со строками работаем пока
            if (ch != ' ') {
                number = number + ch;
                // по такому же принципу в цикле происходит проверка дальше
                // следующий элемент у нас ‘.’
                // заходим в if, тоже не равно пробелу, удовлетворяет условию
                // в number у нас помнишь, уже записано 3, присваиваем '3' + '.' (конкатенация строк)
                // дальше по такому же принципу к "3." + '1' и т.д.


                // если встретили пробел, переходим в блок else
            } else {

                // тут будем с конца читать
                    // number, в нашем примере 3.1415 и он пока строка, оборачиваем в Double
                    // теперь мы имеет Double, который с помощью метода Math.round () округляем  до 3.0
                    // делаем явный кастинг к int, который помогает нам отбросить дробную часть, получаем 3
                    //  затем полученное число переводим снова к строке (методом toString) и записываем
                    // инициируем number пустым значением, и можно читать следующую строку :)
                fos.write(Integer.toString((int) Math.round(Double.parseDouble(number))));
                number = "";
                fos.write(ch);
            }
        }
        if(number.length() != 0) {
            fos.write(Integer.toString((int) Math.round(Double.parseDouble(number))));
            number = "";
        }
        fis.close();
        fos.close();


    }
}
