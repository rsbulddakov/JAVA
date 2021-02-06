package GU.Java;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        doTask1();

        doTask2();
    }

    public static void doTask1() {
        int restart = 1;
        do {
            StartGame1();
            System.out.println("Сыграем еще раз? 1 - Да / 0 - Нет");
            Scanner sc = new Scanner(System.in);
            restart = sc.nextInt();
        } while (restart == 1);
    }

    public static boolean StartGame1(){
        Random rand = new Random();
        int x = rand.nextInt(10);
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Программа загадала число!");
        while(count < 3){
            System.out.println("Введите Ваш вариант:");
            int y = sc.nextInt();
            if(count == 2 && x != y){
                System.out.println("Вы проиграли! Загаданное число - " + x);
                return false;
            }
            if(x > y){
                System.out.println("Загаданое число больше " + y);
            } else if(x < y) {
                System.out.println("Загаданое число меньше " + y);
            } else {
                System.out.println("Вы угадали!");
                return true;
            }
            count++;
        }
        return false;
    }

    public static void doTask2() {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
        };
        boolean win = false;
        Scanner sc = new Scanner(System.in);
        String systemVariant = words[new Random().nextInt(words.length)];
        System.out.println("Игра началась! Введите слово:");
        String userVariant = sc.next().toLowerCase();
        do {
            if(userVariant.equals(systemVariant)){
                win = true;
            } else {
                int cicle = Math.min(userVariant.length(), systemVariant.length());
                for (int i = 0; i < 15; i++){
                    if(i < cicle && userVariant.charAt(i) == systemVariant.charAt(i)){
                        System.out.print(userVariant.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
                System.out.println("Введите слово:");
                userVariant = sc.next().toLowerCase();
            }
        } while (!win);
        System.out.println("Вы угадали!");
    }
}
