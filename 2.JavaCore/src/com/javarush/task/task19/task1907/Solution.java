package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;



public class Solution  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        StringBuilder sb = new StringBuilder (  );
        FileReader fileReader = new FileReader ( reader.readLine () );
        reader.close ();

        while (fileReader.ready()) sb.append ( (char) fileReader.read () );
        fileReader.close ();

        System.out.println (sb.append("\0").toString ().toLowerCase ().split ( "\\bworld\\b" ).length - 1);
    }
    //F:\java\1.txt
}
