package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
         ArrayList<String> stroki = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            stroki.add(reader.readLine());

        }
        String samDlinnii=stroki.get(0),samKorotkii=stroki.get(0);
        int inDlin=0,inKorot=0;
        for (int i = 0; i <stroki.size() ; i++) {
            if (samDlinnii.length()<stroki.get(i).length()){
                samDlinnii=stroki.get(i);
                inDlin=i;
            }
            if (samKorotkii.length()>stroki.get(i).length()){
                samKorotkii=stroki.get(i);
                inKorot=i;
            }
        }
        if(inDlin<inKorot)
            System.out.println(stroki.get(inDlin));
        else System.out.println(stroki.get(inKorot));



    }
}
