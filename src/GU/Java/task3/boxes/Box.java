package GU.Java.task3.boxes;

import GU.Java.task3.fruit.Fruit;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> list;

    public void put(T fruit){
        list.add(fruit);
    }

    public float getWeight(){
        float totalWeight = 0;
        for(int i =0; i < list.size(); i++) {
            totalWeight += list.get(i).getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> box){
        return getWeight() == box.getWeight();
    }

    public void shiftBox(Box<T> box){
        box.list.addAll(this.list);
        list.clear();
    }
}
