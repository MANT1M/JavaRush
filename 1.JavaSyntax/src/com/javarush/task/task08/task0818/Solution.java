package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Ivanov1",500);
        map.put("Ivanov2",500);
        map.put("Ivanov3",500);
        map.put("Ivanov4",500);
        map.put("Ivanov5",500);
        map.put("Ivanov6",500);
        map.put("Ivanov7",499);
        map.put("Ivanov8",5010);
        map.put("Ivanov9",500);
        map.put("Ivanov10",501);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map)  {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList();
        for (String s:map.keySet()) {

                if(map.get(s)<500){
                list.add(s);}
        }
        for (String s:list) {
            map.remove(s);
        }
        }

    public static void main(String[] args){

        removeItemFromMap(createMap());
    }
}