package GU.Java;


public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if(n > food) return false;
        food -= n;
        return true;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int food){
        this.food += food;
    }

}


