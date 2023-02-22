package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Toys {
    private int id;
    private String name;
    private int weight;

    public Toys(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    protected Toys() {
    }

    public static List<Toys> getListToys(){
        List<Toys> list = new ArrayList<>();
        list.add(new SmallToys(1, "Зайчики", 30, 50));
        list.add(new MediumToys(2, "Мишки", 60, 25));
        list.add(new BigToys(3, "Слоны", 100, 10));
        return list;
    }
    public static List<Toys> getListToys(int res1, int res2, int res3, int[] findId){

        List<Toys> newToysList = new ArrayList<>();
        newToysList.add(new SmallToys(findId[0], "Зайчики", 30, res1));
        newToysList.add(new MediumToys(findId[1], "Мишки", 60, res2));
        newToysList.add(new BigToys(findId[2], "Слоны", 100, res3));
        return newToysList;
    }

    public int getId() {
        return id;
    }
    public static int[] findId(List<Toys> list){
        int size = list.size();
        int[] findId = new int[size];
        int i = 0;
        for (Toys toy : list) {
            int id = toy.getId(); // получаем id каждого объекта
            findId[i]=id;
            i++;

        }
        return findId;
    }

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public static void showList(List<Toys> list, String msq){
        System.out.println(msq);
        for (Toys toy : list
        ) {
            System.out.println(toy);

        }
    }
    /*
    метод получения количества игрушек по категориям
     */
    public static int[] findNumberToys(int[] arr){
        Arrays.sort(arr);
        int[] res = new int[3];
        int count =1;
        int index = 0;
        int el = arr[0];
        for (int i = 1; i<= arr.length-1;i++) {
            if (el != arr[i]) {
                res[index] = count;
                count = 1;
                index++;
                el = arr[i];
            } else {
                count++;

            }
            if (i == arr.length - 1) {
                res[index] = count;
            }

        }
        return res;
    }

/*
метод получения остатков игрушек
 */
//public static int getRest(List<Toys> list, int[] res, int id, ){
//    int rest = 0;
//    for (Toys toy : list) {
//        if (toy instanceof  && toy.getId() == id) {
//            Objects objects = (SmallToys) toy;
//            rest = objects.getVolume() - res[id-1];
//            objects.setVolume(rest);
//            break; // выходим из цикла, когда найден нужный объект
//        }
//    }
//    return rest;
//}


    @Override
    public String toString() {
        return "id:" + id + " Название:" + name + " Вес:"+ weight + "гр.";
    }

    public abstract int getRest(List<Toys> list, int[] res, int id);
}
