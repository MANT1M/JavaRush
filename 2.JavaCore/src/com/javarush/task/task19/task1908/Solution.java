package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
        StringBuilder sb = new StringBuilder (  );
        StringBuilder sb1 = new StringBuilder (  );

        BufferedReader fileReader =new  BufferedReader(new FileReader ( reader.readLine () ));
        BufferedWriter w = new BufferedWriter( new FileWriter(reader.readLine()));
        while (fileReader.ready()) sb.append ( (char) fileReader.read () );
        Pattern p = Pattern.compile("(^[0-9]+\\s)|(\\s[0-9]+\\s)|(\\s[0-9]+$|(//Punct))");
        Matcher m = p.matcher(sb);
        while (m.find()){
            sb1.append(m.group());
        }
        Pattern p1 = Pattern.compile("[0-9]+");
        Matcher m1 = p1.matcher(sb1);
        while (m1.find()){
            w.write(m1.group()+" ");
            System.out.print(m1.group()+" ");
        }
        reader.close ();
        w.close();
        fileReader.close ();
//F:\java\1.txt    1 slovo1 23 45, ,4r, 45





    }
}
