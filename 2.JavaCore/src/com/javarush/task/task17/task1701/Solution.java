package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task17.task1701.Solution.Note.addNote;
import static com.javarush.task.task17.task1701.Solution.Note.notes;
import static com.javarush.task.task17.task1701.Solution.Note.removeNote;

/* 
Заметки
*/

public class Solution {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class NoteThread extends Thread
    {
        @Override
        public void run() {
            for (int index = 0; index < 1000; index++) {
                addNote(String.valueOf(this.getName()+"-Note"+index));
                removeNote(this.getName());


            }
        }
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<String>();

        public static void addNote(String note){
            notes.add(0, note);
        }
        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            }
        }
    }
}
