package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.

Требования:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что некоторые из них могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Solution)) return false;
        if (this == o) return true;
        Solution solution1 = (Solution) o;



        return Double.compare(solution1.aDouble, aDouble) == 0 && anInt == solution1.anInt && (
                date != null ? date.equals(solution1.date) : solution1.date == null) && (solution != null
                ? solution.equals(solution1.solution) : solution1.solution == null) && (string != null
                ? string.equals(solution1.string) : solution1.string == null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }

    public static void main(String[] args) {

    }
}
