package GU.Java;

public class Main {
    public static void main(String[] args) {
        AnimalGroup groupOne = new AnimalGroup();
        groupOne.add(
                new Cat(10),
                new Cat(200),
                new Dog(50, 150)
        );


        for (int i = 0; i < groupOne.getAnimals().length; i++) {
            System.out.println(groupOne.getAnimals()[i]);
            System.out.println("Run: " + groupOne.getAnimals()[i].run(160));
            System.out.println("Swim: " + groupOne.getAnimals()[i].swim(30));
        }

        System.out.println("Total one animals: " + groupOne.getAnimalCount());

        AnimalGroup groupTwo = new AnimalGroup();
        groupTwo.add(
                new Cat(200),
                new Dog(50, 150)
        );

        System.out.println("Total two animals: " + groupTwo.getAnimalCount());
    }
}
