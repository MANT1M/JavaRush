package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean happy;
        private double money;
        private int agr;
        private String family;

        public Human(String name, int age,boolean happy, int money,int agr, String family){
        this.name=name;
        this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, String family, int age,boolean happy, int money,int agr){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, int money,int agr,int age,boolean happy, String family){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, int age, String family,int money,boolean happy, int agr){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, int age, int agr, double money,String family,boolean happy){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, boolean happy, int age, int agr, double money,String family){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;

        }
        public Human(String name, double money, int age, int agr, String family,boolean happy){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;

        }
        public Human(String name, int agr, double money, int age, String family,boolean happy){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, String family, boolean happy,int agr, double money, int age){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
        public Human(String name, String family, int agr, boolean happy,double money,int age){
            this.name=name;
            this.age=age;
            this.happy=happy;
            this.agr=agr;
            this.money=money;
            this.family=family;
        }
    }
}
