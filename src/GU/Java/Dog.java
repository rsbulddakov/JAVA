package GU.Java;

public class Dog extends Animal{
    static int dogCount;

    public Dog() {
        dogCount++;
        this.name = "Безымянный пес";
    }

    public Dog(String name) {
        dogCount++;
        this.name = name;
    }

    @Override
    public void run(int wayLength) {
        if(wayLength > 500){
            System.out.println(this.name + " может пробежать только 500 м." );
        } else {
            System.out.println(this.name + " пробежал " + wayLength + " м.");
        }
    }

    @Override
    public void swim(int wayLength) {
        if(wayLength > 10){
            System.out.println(this.name + " может проплыть только 10 м.");
        } else {
            System.out.println(this.name + " проплыл " + wayLength + " м.");
        }
    }
}
