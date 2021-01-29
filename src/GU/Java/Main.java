package GU.Java;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Ex2
        byte b = 1;
        short s = 12;
        int i = 123;
        long l = 1234;
        float f = 1.2345f;
        double d = 1.23456789;
        char c = 'A';
        boolean boo = true;

        System.out.println(simpleCalculate(2, 4, 6,7));
        System.out.println(isInRange(10, 11));
        System.out.println(isInRange(10, 10));
        System.out.println(isInRange(10, 9));
        System.out.println(isInRange(8, 1));
        printIsPositive(1);
        printIsPositive(0);
        printIsPositive(-1);
        System.out.println(isNegative(1));
        System.out.println(isNegative(0));
        System.out.println(isNegative(-1));
        printHelloName("Name");
        isYearLeap(1900);
        isYearLeap(2020);
        isYearLeap(1600);
        isYearLeap(1989);
        isYearLeap(2004);
    }
    //Ex3
    public static float simpleCalculate(float a, float b, float c, float d){
        return a * (b + (c / d));
    }
    //Ex4
    public static boolean isInRange(int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }
    //Ex5
    public static void printIsPositive(int a){
        if(a < 0)
            System.out.println("Число " + a + " отрицательное");
        else
            System.out.println("Число " + a + " положительное");
    }
    //Ex6
    public static boolean isNegative(int a){
        return a < 0;
    }
    //Ex7
    public static void printHelloName(String name){
        System.out.println("Привет, " + name + "!");
    }
    //Ex8
    public static void isYearLeap(int year){
        if(year%4==0 && year%100 !=0 || year%400==0)
            System.out.println(year + " - високосный год");
        else
            System.out.println(year + " - не високосный год");
    }
}
