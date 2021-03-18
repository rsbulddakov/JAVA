package GU.Java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        doTask1();

        doTask2();
    }

    public static void doTask1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("понедельник");
        list.add("февраль");
        list.add("вторник");
        list.add("апрель");
        list.add("среда");
        list.add("июнь");
        list.add("четверг");
        list.add("август");
        list.add("пятница");
        list.add("суббота");
        list.add("февраль");
        list.add("декабрь");
        list.add("январь");
        list.add("февраль");
        list.add("март");
        list.add("апрель");
        list.add("май");
        list.add("июнь");
        list.add("июль");
        list.add("август");
        list.add("сентябрь");
        list.add("среда");
        list.add("ноябрь");
        list.add("декабрь");

        printUniqueInArray(findUniqueInList(list));
        printCountInArray(findUniqueInList(list));
    }

    public static void doTask2(){
        PhoneBook book = new PhoneBook();
        book.add("Петров", "+79111231231");
        book.add("Петров", "+79111231232");
        book.add("Петров", "+79111231233");
        book.add("Петров", "+79111231234");
        book.add("Сидоров", "+79111231231");
        book.add("Иванов", "+79111231231");

        book.get("Петров");
        book.get("Иванов");
        book.get("Сергеев");
    }

    public static HashMap<String, Integer> findUniqueInList(ArrayList<String> arrayList){
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String key : arrayList) {
            int count = countMap.getOrDefault(key, 0);
            countMap.put(key, ++count);
        }
        return countMap;
    }

    public static void printUniqueInArray(HashMap<String, Integer> map){
        System.out.println(map.keySet());
    }

    public static void printCountInArray(HashMap<String, Integer> map){
        map.forEach((key, value) ->{
            System.out.printf("'%s' встречается в массиве %s раз(а)", key, value);
            System.out.println();
        });
    }
}
