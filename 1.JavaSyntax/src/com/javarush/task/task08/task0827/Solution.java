package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(isDateOdd("MAY 1 2013"));
        Date date =new Date("MAY 1 2013");
        System.out.println(date);
    }

    public static boolean isDateOdd(String date) throws Exception {
        SimpleDateFormat dateFormate = new SimpleDateFormat("MMMM dd yyyy",Locale.ENGLISH);
        Date parsingDate = dateFormate.parse(date);
        Calendar calendar=new GregorianCalendar();

        calendar.setTime(parsingDate);
        if(calendar.get(Calendar.DAY_OF_YEAR)%2==0){
            return false;
        }
        //System.out.println(date1);

        return true;
    }
}
