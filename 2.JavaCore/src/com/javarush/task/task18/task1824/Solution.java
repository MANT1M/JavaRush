package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean a=true;
        while(a){
            String s = reader.readLine();

            try {

                FileInputStream fis = new FileInputStream(s);
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(s);
                a=false;
                reader.close();

            }
        }

    }
}
