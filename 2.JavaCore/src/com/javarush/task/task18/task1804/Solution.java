package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            list.add(data);
        }
        inputStream.close();

        int a = 0;
        int b = 0;
        int d = 0;

        Collections.sort(list); //сортировка списка

        for (int i = 0; i < list.size() - 1; i++) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                int c = iterator.next();
                d++;
                if (d > i) {
                    if (list.get(i) == c) {
                        b++;
                        a++;
                        if (b > 1) {
                            iterator.remove();
                        }
                    }
                }
            }
            list2.add(a);
            a = 0;
            b = 0;
            d = 0;
        }

        int min = list2.get(0);

        for (int i = 1; i < list2.size(); i++) {
            if (min > list2.get(i)) {
                min = list2.get(i);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (min == list2.get(i)) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}




