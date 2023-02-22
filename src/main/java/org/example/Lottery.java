package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

    /*
    метод генерации случайных чисел с % соотношением
     */
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
   public static int[] startQuiz(List<Toys>list){
       Scanner scanner = new Scanner(System.in);
       System.out.println("Хотите начать лотерею? Введите 'да' или 'нет'");
       String choose = scanner.next().toLowerCase();

       final String YES = "да";
       final String NO = "нет";
       int[] result = getArrayGifts(list, 10); // массив для викторины на 10 человек

       // реализаци игры
       if (choose.equals(YES)) {
           Lottery.distributionGifts(result);
       } else if (choose.equals(NO)) {
           System.out.println("До встречи!");
       } else {
           System.out.println("Некорректный ввод, попробуйте ещё раз");
       }
       scanner.close();
       return result;
   }
    /*
метод получения массива подарков для раздачи в лотерее
*/
    public static int[] getArrayGifts(List<Toys> list, int size){
        int [] prizes = new int[size];
        for(int i = 0;i<prizes.length;i++)
        {
            prizes[i] = generateNumber();
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
}
