package GU.Java;

public abstract class Animal {
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;

    public String getName() {
        return name;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxSwimDistance=" + maxSwimDistance +
                '}';
    }

    public abstract boolean run(int distance);
    public abstract boolean swim(int distance);
}
