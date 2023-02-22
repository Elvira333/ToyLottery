package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Toys {
    private long id;
    private String name;
    private int weight;

    public Toys(long id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public static int generateNumber() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (number < 60) {
            return 1;
        } else if (number < 90) {
            return 2;
        } else {
            return 3;
        }
    }
    /*
    метод получения массива подарков для раздачи в лотерее
    */
    public static int[] getArrayGifts(List<Toys> list, int size){
        int [] prizes = new int[size];
        for(int i = 0;i<prizes.length;i++)
        {
            prizes[i] = Toys.generateNumber();
        }
        return prizes;
    }
    /*
    метод раздачи подарков для каждого игрока
     */
    public static void distributionGifts(int[] array) {
        for(int i = 0;i < array.length;i++){
            System.out.printf("Игрок %d!", (i+1));
            switch (array[i]) {
                case 1:
                    System.out.println("Поздравляем, вы выйграли Зайчика!");
                    break;
                case 2:
                    System.out.println("Поздравляем, вы выйграли Мишку!");
                    break;
                case 3:
                    System.out.println("Поздравляем, вы выйграли Слона!");
                    break;
            }
        }
    }
    /*
    метод получения количества игрушек по категориям
     */
    public static int[] deletingIssuedGifts(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
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
            } else{
                count++;

            }
            if(i==arr.length-1)
            {
                res[index] = count;
            }

        }
        System.out.print(Arrays.toString(res));
        return res;
    }


    @Override
    public String toString() {
        return "id:" + id + " Название:" + name + " Вес:"+ weight + "гр.";
    }

}
