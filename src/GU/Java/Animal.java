package GU.Java;

public class Animal {
    public String name;
    static int count;

    public Animal() {
        count++;
        this.name = "Безымянное животное";
    }
    public Animal(String name) {
        count++;
        this.name = name;
    }

    public void run(int wayLength){
        System.out.println(this.name + " пробежал " + wayLength + " м.");
    }
    public void swim(int wayLength){
        System.out.println(this.name + " проплыл " + wayLength + " м.");
    }
}
