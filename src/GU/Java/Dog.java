package GU.Java;

public class Dog extends Animal{
    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
    }

    @Override
    public boolean run(int distance) {
        return distance <= getMaxRunDistance();
    }

    @Override
    public boolean swim(int distance) {
        return distance <= getMaxSwimDistance();
    }
}
