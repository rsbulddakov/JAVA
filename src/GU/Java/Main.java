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
        Dog d1 = new Dog();
        Dog d2 = new Dog("Барбос");

        Cat c1 = new Cat();
        Cat c2 = new Cat("Барсик");

        c1.swim(10);
        c2.swim(100);

        d1.swim(10);
        d2.swim(100);

        c1.run(20);
        c2.run(500);

        d1.run(20);
        d2.run(600);
    }

    public static void doTask4(){
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal a3 = new Animal("Слон");
        Animal a4 = new Animal();
        Animal a5 = new Animal("Жираф");

        Dog d1 = new Dog();
        Dog d2 = new Dog("Барбос");
        Dog d3 = new Dog();
        Dog d4 = new Dog("Бим");
        Dog d5 = new Dog();

        Cat c1 = new Cat();
        Cat c2 = new Cat("Барсик");
        Cat c3 = new Cat();
        Cat c4 = new Cat("Леопольд");
        Cat c5 = new Cat();

        System.out.println("Всего создано животных: " + Animal.count);
        System.out.println("Всего создано собак: " + Dog.dogCount);
        System.out.println("Всего создано котов: " + Cat.catCount);
    }
}
