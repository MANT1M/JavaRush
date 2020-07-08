package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> stroki = new ArrayList<>();
        //ArrayList<String> stroki2 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            stroki.add(reader.readLine());
            //stroki2.add(stroki.get(i));
            //System.out.println(stroki.get(i).length());

        }
        String samKorotkii=stroki.get(0);
        //int inDlin=0,
        int inKorot=0;
        boolean prov=false;
        int li = stroki.size();
        for (int i = 0; i < li - 1; i++) {
            if (stroki.get(i).length() > stroki.get(i + 1).length()) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}

