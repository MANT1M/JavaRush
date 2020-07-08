package com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.

D:\Java\1.txt
Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу


        try {
            File your_file_name = new File("1.txt");
            File your_file_name1 = new File("1");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            OutputStream outputStream1 = new FileOutputStream(your_file_name1);
            InputStream inputStream = new FileInputStream(your_file_name);
            InputStream inputStream1 = new FileInputStream(your_file_name1);
            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            Human ivanov1 = new Human("Ivanov");
            ivanov.save(outputStream);
            ivanov1.save(outputStream1);
            outputStream.flush();
            outputStream.close();
            Human somePerson = new Human();
            somePerson.load(inputStream1);
            inputStream.close();
            System.out.println(ivanov1.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

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

        public Human() {
        }

        public Human(String name, Asset... assets) {

            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }


        }

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

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isName = this.name != null ? "yes" : "no";
            String isAsset = this.assets.size() > 0 ? "yes" : "no";


            if(isName.equals("yes")){
                writer.println(this.name);
            }
            writer.println(isAsset);
            if(isAsset.equals("yes")){

                for (Asset aseets : assets){

                    writer.println(aseets.getName());
                    writer.println(aseets.getPrice());

                }

            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isPresentName = reader.readLine();
            if (isPresentName!=null){
                this.name = isPresentName;
            }

            //implement this method - реализуйте этот метод

            String temp = reader.readLine();
            if (temp.equals("yes")) {

                    while (reader.ready()) {
                        assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine())));
                    }

            }


            /*

            String line = reader.readLine();

            //если список не пустой - считываем все


                while (line!=null) {
                    //System.out.println(line +"Отрабатывает");
                    //Т.к. в цифрах не может быть символа "_", разделяющий символ "_" будет последний
                    //Соответственно всё что между началом строки и последним "_", это имя имущества
                    String name = line.substring(0, line.lastIndexOf('_'));
                    //Ну и всё остальное это price
                    double price = Double.parseDouble(line.substring(line.lastIndexOf('_') + 1));
                    this.assets.add(new Asset(name, price));
                    line=reader.readLine();
                }
               // if(assets.isEmpty())
               // if(line.equals("yes")){}
            // Вызов Exception для "Oops, something wrong with save/load method" в случае если assets пустой. Как один из вариантов решения





*/
            reader.close();
        }
    }
}
