package GU.Java;

public class Dog extends Animal {
    private static int dogCount;

    public Dog(int maxSwimDistance, int maxRunDistance) {
        super("Doggy", maxRunDistance, maxSwimDistance);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public boolean swim(int distance) {
        return distance <= getMaxSwimDistance();
    }

    @Override
    public boolean run(int distance) {
        return distance <= getMaxRunDistance();
    }
}
