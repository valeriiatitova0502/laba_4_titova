package org.example;

import java.util.ArrayList;
import java.util.List;

public class LemonBox implements ComparableFruit {
    private List<Lemon> list;

    public LemonBox(Lemon... lemons) {
        this.list = new ArrayList<>(List.of(lemons));
    }


    public void add(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new Lemon());
        }
    }
    public void moveTo(LemonBox otherBox) {
        if (this == otherBox) {
            return; // Нельзя перемещать лимоны в ту же самую коробку
        }

        otherBox.list.addAll(this.list);
        this.list.clear();
    }

    public float getWeight() {
        float weight = 0;
        for (Lemon item : list) {
            weight += item.getWeight();
        }
        return weight;
    }

    public boolean compare(ComparableFruit otherBox) {
        if (otherBox instanceof LemonBox) {
            LemonBox otherBananaBox = (LemonBox) otherBox;
            return Math.abs(this.getWeight() - otherBananaBox.getWeight()) < 0.0001;
        }
        return false;
    }

    void printBox() {
        if (list.isEmpty()) {
            System.out.println("Коробка  пуста");
        } else {
            for (Lemon b : list) {
                System.out.println(b);
            }
        }
    }
}