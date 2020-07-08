package com.javarush.task.task16.task1616;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();

        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;
        Date konec = new Date();

        public void run() {

                //add your code here - добавьте код тут
                int i = 1;
                try {
                    while (!isInterrupted()) {
                        seconds++;
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException e) {
                    System.out.println(seconds);
                }
            }
        }
}



