package com.javarush.task.task14.task1409;

/* 
Мосты
Требования:
1. Интерфейс Bridge должен быть создан в отдельном файле.
2. Классы WaterBridge и SuspensionBridge должны быть созданы в отдельных файлах.
3. Классы WaterBridge и SuspensionBridge должны реализовывать интерфейс Bridge.
4. Метод getCarsCount() должен возвращать различные значения типа int для различных классов, но всегда фиксированное(константное) значение для разных объектов одного и того же класса.
5. В классе Solution должен быть реализован публичный(public) метод println c одним параметром типа Bridge.
6. Метод println должен выводить на консоль количество машин(результат работы метода getCarsCount) для переданного ему моста(объекта типа Bridge).
7. В интерфейсе Bridge должен быть определен метод int getCarsCount().
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());


    }
    public static void println(Bridge bridge){
        System.out.println(bridge.getCarsCount());
    }

    //add println method here
}

