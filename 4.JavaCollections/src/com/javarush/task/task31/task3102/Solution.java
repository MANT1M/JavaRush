package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/
public class Solution {
    private static Object FileVisitOption;

    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){

            File files = new File(queue.remove());

            for (File file: files.listFiles()) {
                if(file.isDirectory()){
                    queue.add(file.getAbsolutePath());
                }
                if (file.isFile()){
                    list.add(file.getAbsolutePath());
                }
            }
        }
        return list;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(getFileTree("d:/java/"));
        File folder = new File("d:/java/");
       /* for (File file : folder.listFiles())
        {
            System.out.println(file.getName());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println(file.length());
            System.out.println();
        }
        System.out.println(folder.list().length);*/
    }
}
