package GU.Java;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //задание 3
        doTask3();
        //задание 4
        doTask4();
    }
    public static void doTask3(){

    }

    public static void doTask4(){
        AnimalGroup groupOne = new AnimalGroup();
        groupOne.add(
                new Cat("", 10, 20),
                new Cat("", 100, 200),
                new Dog("", 140, 2000)
        );

        for(int i = 0; i < groupOne.getAnimals().length; i++){
            System.out.println(groupOne.getAnimals()[i]);
            System.out.println("Run :" + groupOne.getAnimals()[i].run(160));
            System.out.println("Swim :" + groupOne.getAnimals()[i].swim(130));
        }

        System.out.println("Total animals :" + groupOne.getAnimalCount());
    }
}
