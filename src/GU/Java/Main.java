package GU.Java;

public class Main {
    public static void main(String[] args) {
        doTask5();
        doTask6();
    }

    public static void doTask5() {
        Cat[] cats = new Cat[10];
        Plate commonPlate = new Plate(300);
        for(int i = 0; i < cats.length; i++){
            cats[i] = new Cat("Кот", i);
            cats[i].setAppetite((i + 1) * 10);
        }

        for(int i = 0; i < cats.length; i++){
            cats[i].eat(commonPlate);
            System.out.println(cats[i].toString());
        }

        commonPlate.info();
    }

    public static void doTask6() {
        Plate commonPlate = new Plate(300);
        commonPlate.info();
        commonPlate.addFood(100);
        commonPlate.info();
    }
}
