package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 задание");
        Integer[] arr1 = {1, 2, 3, 4,5,6};
        String[] arr2 = {"ba", "la", "da","ma", "pa"};
        System.out.println(Arrays.toString(arr1));
        swapElements(arr1, 1,4);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        swapElements(arr2, 2,3);
        System.out.println(Arrays.toString(arr2));

        System.out.println("2 задание");
        List<String> list = convertToList(arr2);
        System.out.println(list);


        System.out.println("3 задание");
        Box<Apple> appleBox2 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange());
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple());
        LemonBox lemonBox = new LemonBox(new Lemon(), new Lemon());

        System.out.println("До перемещения вес коробки был: " + (lemonBox.getWeight() + orangeBox.getWeight() + appleBox1.getWeight() + appleBox2.getWeight()));
        System.out.println("Вес коробки с бананами: " + lemonBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с вторыми яблоками: " + appleBox2.getWeight());

        appleBox1.printBox();
        appleBox2.printBox();
        orangeBox.printBox();
        lemonBox.printBox();




        System.out.println("-------");


        lemonBox.add(7);
        appleBox2.add(2);
        appleBox1.add(4);
        orangeBox.add(5);

        appleBox2.compare(appleBox1);
        appleBox1.compare(orangeBox);
        lemonBox.compare(lemonBox);







        lemonBox.printBox();
        orangeBox.printBox();
        appleBox1.printBox();
        appleBox2.printBox();

        System.out.println("После перемещения и добавления фруктов вес коробки стал :" + (lemonBox.getWeight() + appleBox1.getWeight() + appleBox2.getWeight() + orangeBox.getWeight()));
        System.out.println("Вес коробки с лимонами: " + lemonBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с вторыми яблоками: " + appleBox2.getWeight());
    }


    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static <V> List<V> convertToList(V[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}