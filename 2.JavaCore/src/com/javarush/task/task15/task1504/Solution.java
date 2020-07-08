package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getName();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ", " + getBook().getName() + " is a detective";
            String markTwainOutput = getBook().getName() + " book was written by " + author;

            String output = "output";

            if (this instanceof MarkTwainBook)
                output = markTwainOutput;
            else if (this instanceof AgathaChristieBook)
                output = agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {

        private String name;
        private static String author = "Mark Twain";

        public MarkTwainBook (String name){
            super(author);
            this.name = name;
        }

        public MarkTwainBook getBook() {
            return this;
        }

        public String getName() {
            return this.name;
        }
    }

    public static class AgathaChristieBook extends Book {

        private String name;
        private static String author = "Agatha Christie";

        public AgathaChristieBook (String name){
            super(author);
            this.name = name;
        }

        public AgathaChristieBook getBook() {
            return this;
        }

        public String getName() {
            return this.name;
        }
    }
}

