package GU.Java;

import GU.Java.task3.boxes.Box;
import GU.Java.task3.fruit.Apple;
import GU.Java.task3.fruit.Orange;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        doTask1();
        doTask2();
        doTask3();
    }

    public static void doTask1(){
        Object[] array = new Object[]{
                "A", "B", "C", "D", "E", "F"
        };
        replaceArrayElements(array, "A", "D");
        printArray(array);
    }

    public static void doTask2(){
        Object[] array = new Object[]{
                "A", "B", "C", "D", "E", "F"
        };
        var list = convertToList(array);
        System.out.println(list);
    }

    public static void doTask3(){
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        orangeBox.compare(appleBox);
    }

    public static void replaceArrayElements(Object[] array, Object firstElement, Object secondElement){

        int firstIndex = Arrays.asList(array).indexOf(firstElement);
        int secondIndex = Arrays.asList(array).indexOf(secondElement);

        Object tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    public static ArrayList convertToList(Object[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void printArray(Object[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
