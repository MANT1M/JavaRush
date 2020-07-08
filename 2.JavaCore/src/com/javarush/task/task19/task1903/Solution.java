package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
Требования:
1. Класс Solution должен содержать public static поле countries типа Map<String, String>.
2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");}
    public static void main(String[] args) {
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(new IncomeData() {
            @Override
            public String getCountryCode() {
                return "RU";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 2565;
            }

        });
        System.out.println(incomeDataAdapter.getName());
        System.out.println(incomeDataAdapter.getPhoneNumber());
        System.out.println(incomeDataAdapter.getCompanyName());
        System.out.println(incomeDataAdapter.getCountryName());
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private final IncomeData data;
        IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        @Override
        public String getName() {
            return this.data.getContactLastName()+", "+this.data.getContactFirstName();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getPhoneNumber() {
            String pNumber = this.data.getPhoneNumber()+"";
            StringBuilder nulls = new StringBuilder();
            if (pNumber.length()<10){
                for (int i = 0;i<(10-pNumber.length());i++){
                    nulls.append("0");
                }
            }
            pNumber = nulls + pNumber;
            String firstPart = pNumber.substring(0, 3);
            String secondPart = pNumber.substring(3, 6);
            String thirdPart = pNumber.substring(6, 8);
            String fourthPart = pNumber.substring(8);
            return "+" + this.data.getCountryPhoneCode() + "(" + firstPart + ")" + secondPart + "-"
                    + thirdPart + "-" + fourthPart;
        }






    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}