package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {




    public static void main(String[] args) throws IOException {

        //BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file_1 = new FileInputStream(args[0]);

        HashMap<Character, Integer> values = new HashMap<>();
        ArrayList<Character> symbols = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        //writing in map
        while (file_1.available() > 0) {
            char data = (char) file_1.read();
            if (values.containsKey(data))
                values.replace(data, values.get(data) + 1);
            else
                values.put(data, 1);
        }

        //adding to arrays
        for (Map.Entry<Character, Integer> item : values.entrySet()){
            symbols.add(item.getKey());
            counts.add(item.getValue());
        }

        //sort
        for(int i = 0; i < symbols.size()-1; i++){
            for (int j = i + 1; j < symbols.size(); j++){
                if ((int)symbols.get(i) > (int)symbols.get(j)){

                    int k = (int)symbols.get(i);
                    symbols.add(i, symbols.get(j));
                    symbols.remove(i+1);
                    symbols.add(j, (char) k);
                    symbols.remove(j+1);

                    int s = counts.get(i);
                    counts.add(i, counts.get(j));
                    counts.remove(i+1);
                    counts.add(j, s);
                    counts.remove(j+1);
                }
            }
        }

        //output after sort
        for(int i = 0; i < symbols.size(); i++){
            System.out.println((int)symbols.get(i) + " " + counts.get(i));
        }

        file_1.close();

    }
}
