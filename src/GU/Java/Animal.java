package GU.Java;

public abstract class Animal {
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private AnimalCounter animalCounter;

    public String getName() {
        return name;
    }

    public int getAnimalCounter() {
        return animalCounter.getCount();
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance, AnimalCounter animalCounter) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.animalCounter = animalCounter;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCounter = new AnimalCounter();
        animalCounter.increase();
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
                ", animalCounter=" + animalCounter +
                '}';
    }

    public abstract boolean run(int distance);
    public abstract boolean swim(int distance);
}
