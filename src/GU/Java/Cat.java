package GU.Java;

public class Cat extends Animal{
    public Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

    @Override
    public boolean run(int distance) {
        return distance <= getMaxRunDistance();
    }

    @Override
    public boolean swim(int wayLength) {
        System.out.println("Cats cannot swim...");
        return false;
    }
}
