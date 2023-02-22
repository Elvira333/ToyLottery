package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Toys> toys = new ArrayList<>();
        toys.add(new SmallToys(1,"Зайчики", 30,50));
        toys.add(new MediumToys(2, "Мишки", 60,25));
        toys.add(new BigToys(3,"Слоны", 100, 10));

        System.out.println("Список игрушек:");
        for (Toys toy: toys
             ) {
            System.out.println(toy);

        }
        for (Toys toy : toys) {
            if (toy instanceof SmallToys) {
                SmallToys smallToy = (SmallToys) toy;
                int volume = smallToy.getVolume();
                System.out.println("Объем зайчика: " + volume);
            }
        }



        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите начать лотерею? Введите 'да' или 'нет'");
        String choose = scanner.next().toLowerCase();

        final String YES = "да";
        final String NO = "нет";
        int[] result = Toys.getArrayGifts(toys,10); // массив для викторины на 10 человек



        System.out.println(Arrays.toString(result));

        //Toys.deletingIssuedGifts(result);
        if(choose.equals(YES)) {
            Toys.distributionGifts(result);
        }
        else if(choose.equals(NO)){
            System.out.println("До встречи!");
        }
        else
            {
                System.out.println("Некорректный ввод, попробуйте ещё раз");
            }
        scanner.close();
        }

    }
