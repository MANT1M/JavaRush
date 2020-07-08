package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
       /* BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            int x = Integer.parseInt(read.readLine());
            list.add(x);        // запись чисел в лист
        }*/
        final Random random = new Random();
        List <Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(10); //Integer.parseInt()
            list.add(x);

        }

        int count = 1;
        int result = 1;
        for (int i = 0; i < list.size()-1; i++)
            if (list.get(i+1).equals(list.get(i))) {
                System.out.print(i);
                count++;
                if (count >result)
                    result = count;
            }
            else
                count = 1;

        System.out.println(result);
    }
}