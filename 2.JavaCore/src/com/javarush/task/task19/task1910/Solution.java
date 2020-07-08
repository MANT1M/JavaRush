package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader ( new InputStreamReader( System.in ) );
        StringBuilder sb=new StringBuilder();
        BufferedReader fileReader =new BufferedReader( new FileReader ( reader.readLine () ));
        BufferedWriter w= new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close ();
        String s;
        while (fileReader.ready()) sb.append ( (char) fileReader.read () );
        s=sb.toString();

        w.write(s.replaceAll("(^)|(\\p{Punct})", ""));
        fileReader.close ();
        w.close();

        // F:\java\1.txt

    }
}
