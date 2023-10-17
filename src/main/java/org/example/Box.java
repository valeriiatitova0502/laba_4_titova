package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<L extends Fruit> {
    private List<L> list;

    public Box(L... items) {
        this.list = new ArrayList<>(Arrays.asList(items));
    }

    public void add(int count) {
        for (int i = 0; i < count; i++) {
            try {
                list.add((L) list.get(0).getClass().getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void moveTo(Box<L> otherBox) {
        if (this == otherBox) {
            return; // Нельзя перемещать фрукты в ту же самую коробку
        }

        if (list.isEmpty()) {
            System.out.println("Нельзя переместить пустую коробку");
            return;
        }

        if (!otherBox.list.isEmpty() && !list.get(0).getClass().equals(otherBox.list.get(0).getClass())) {
            System.out.println("Нельзя переместить фрукты разных видов");
            return;
        }

        otherBox.list.addAll(this.list);
        this.list.clear();
    }

    float getWeight() {
        float weight = 0;
        if (list.isEmpty()) {
            return 0;
        }
        else {
            for (L l : list) {
                weight += l.getWeight();
            }
            return weight;
        }
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }


    void printBox() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        }
        else{
            for (L l : list) {
                System.out.println(l);
            }
        }
    }
}