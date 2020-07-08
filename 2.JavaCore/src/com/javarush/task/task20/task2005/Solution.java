package com.javarush.task.task20.task2005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

/* 
Очень странные дела
При чтении/записи объектов типа Human возникают странные ошибки.
Разберись в чем дело и исправь их.

Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets равен null.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не равны null.
6. Метод equals должен возвращать true для двух равных объектов типа Human и false для разных.
7. Метод hashCode должен всегда возвращать одно и то же значение для одного и того же объекта типа Human.

*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = new File("1.txt");
            File your_file_name1 = new File("1");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            OutputStream outputStream1 = new FileOutputStream(your_file_name1);
            InputStream inputStream = new FileInputStream(your_file_name);
            InputStream inputStream1 = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human ivanov1 = new Human("Ivanov");
            ivanov1.save(outputStream1);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            Human somePerson1 = new Human();
            somePerson.load(inputStream);
            somePerson.load(inputStream1);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            System.out.println(ivanov1.equals(somePerson1));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            if (this.name != null) {
                printWriter.println("yes");
                printWriter.println(this.name);
                if (assets != null) {

                    for (Asset current : assets)
                        printWriter.println(current.getName());
                }

            } else {
                printWriter.println("no");

            }
            printWriter.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String hasName = reader.readLine();
            String assetName;
            if (hasName.equals("yes")) {
                this.name = reader.readLine();
                while ((assetName = reader.readLine()) != null) {
                    System.out.println(assetName);
                    assets.add(new Asset(assetName));

                }reader.close();


            }reader.close();

        }
    }}
