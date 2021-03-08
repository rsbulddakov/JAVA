package GU.Java;


public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }
    public void eat(Plate p) {
        if(p.decreaseFood(appetite)){
            setFull(true);
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isFull=" + isFull +
                '}';
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}

