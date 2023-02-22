package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

    public static List<Toys> geNewtListToys(int[] res, int[] findId){

        List<Toys> newToysList = new ArrayList<>();
        newToysList.add(new SmallToys(findId[0], "Зайчики", 30, res[0]));
        newToysList.add(new MediumToys(findId[1], "Мишки", 60, res[1]));
        newToysList.add(new BigToys(findId[2], "Слоны", 100, res[2]));
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
    public static int[] findNumberToys(int[] arr, List<Toys> list) throws IOException {
        Arrays.sort(arr);
        int size = list.size();
        int[] res = new int[size]; // тут лежат id
        int count =1;
        int index = 0;
        int el = arr[0];
        for (int i =1; i<= arr.length-1;i++) {

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
    public static int[] totalBalance(List<Toys>list, int [] numberToys, int[]findId){
        int [] res = new int[3];
        SmallToys restSmallToys = new SmallToys();
        int res1 = restSmallToys.getRest(list,numberToys,findId[0]); // получение остатка маленьких игрушек
        res[0] = res1;

        MediumToys mediumToys = new MediumToys();
        int res2 = mediumToys.getRest(list,numberToys,findId[1]);  // получение остатков средних игрушек
        res[1] = res2;

        BigToys bigToys = new BigToys();
        int res3 = bigToys.getRest(list,numberToys,findId[2]); // получение остатков больших игрушек
        res[2] = res3;
        return res;
    }

    /*
    метод записи в файл призовых игрушек
     */
    public static void writerFile(int[] arr) throws IOException {
        File file = getFile();
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw);

        for(int i= 0 ; i<arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    writer.write("Выдача приза: Зайчик!\n");
                    break;
                case 2:
                    writer.write("Выдача приза: Мишка!\n");
                    break;
                case 3:
                    writer.write( "Выдача приза: Слон!\n");
                    break;

            }
        }
        writer.close();
    }
    /*
    метод создания файла
    */
    public static File getFile(){
        File file = new File("prizeToys.txt");
        try {
            boolean result = file.createNewFile();
            if (result) {
                System.out.println("Файл успешно создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
        return file;
    }

    @Override
    public String toString() {
        return "id:" + id + " Название:" + name + " Вес:"+ weight + "гр.";
    }
    public String toString(int id){
        return name + "\n";

    }
}
