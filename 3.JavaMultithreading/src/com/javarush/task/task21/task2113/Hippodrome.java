package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome(List<Horse> horses){
        this.horses=horses;
    }
    Horse horseW = null;
    public void run() throws Exception{
        for (int i = 0; i < 100; i++) {
            move();
            print();

            Thread.sleep(200);

        }
    }
    public void move(){
        for (Horse horse:horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse:horses) {
            horse.print(); }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
    }

    public Horse getWinner(){
        double samDlDist=0;

        for (Horse horse:horses) {
            if (horse.distance>samDlDist){
                horseW=horse;
                samDlDist=horse.distance;
            }
        }

        return horseW;
    }
    public void printWinner(){
        Horse horse = getWinner();
        System.out.println("Winner is "+horse.getName()+"!");
    }
    public static void main(String[] args) throws Exception {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Lili", 3, 0);
        Horse horse2 = new Horse("Mona", 3, 0);
        Horse horse3 = new Horse("Heli", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        Thread.sleep(1000);
        game.getWinner();
        game.printWinner();
    }
}
