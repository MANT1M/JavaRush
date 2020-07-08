package com.javarush.task.task19.task1906;

/* 
Четные символы
F:/java/1.txt
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader r = new FileReader(reader.readLine());
        FileWriter w = new FileWriter(reader.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (r.ready()){
            System.out.println(arrayList.add(r.read()));

            }


        for (int i=1; i<arrayList.size(); i=i+2){
            w.write((char)(int)arrayList.get(i));
            System.out.println(arrayList.get(i) + "  Итог:"+ i);
        }
        r.close();
        reader.close();
    w.close();
//F:\java\1.txt

    }


    }

