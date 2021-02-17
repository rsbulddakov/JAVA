package GU.Java;

public class Cat extends Animal{
    static int catCount;

    public Cat() {
        catCount++;
        this.name = "Безымянный кот";
    }

    public Cat(String name) {
        catCount++;
        this.name = name;
    }

    @Override
    public void run(int wayLength) {
        if(wayLength > 200){
            System.out.println(this.name + " может пробежать только 200 м.");
        } else {
            System.out.println(this.name + " пробежал " + wayLength + " м.");
        }
    }

    @Override
    public void swim(int wayLength) {
        System.out.println(this.name + " не умеет плавать" );
    }
}
