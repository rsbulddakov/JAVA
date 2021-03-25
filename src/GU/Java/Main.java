package GU.Java;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here
        doTask1();
        doTask2();
        doTask3();
        doTask4();
    }

    public static void doTask1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(System.out::println);
    }

    public static void doTask2(){
        Set<String> set = Set.of("New York", "London", "Rome", "Paris", "Tokio");
        Consumer<String> cons = System.out::println;
        forItem(set, cons);
    }

    public static void doTask3(){
        doubleUp(12, () -> 3);
    }

    public static void doTask4(){
        System.out.println(findAllChars("ababacavadab", 'a').get());
    }

    public static void forItem(Set<String> set, Consumer<String> cons){
        set.forEach(cons);
    }

    public static int doubleUp(int i, Supplier<Integer> supp){
        return i * supp.get();
    }

    public static Optional<String> findAllChars(String target, char toFind){
        String result = "";
        for (char ch : target.toCharArray()){
            if(ch == toFind)  result+=ch;
        }
        return Optional.of(result);
    }
}
