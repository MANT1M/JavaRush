package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap=new HashMap<>();

        while (true){
            String idString = reader.readLine();
            if (idString.isEmpty()) {
                break;}
            int id=Integer.parseInt(idString);
            String name = reader.readLine();

            if (name.isEmpty()) {
                hashMap.put("",id);
                break;
            }

            hashMap.put(name,id);

        }
        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
