package org.example;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<Toys> toys = Toys.getListToys();
        Toys.showList(toys, "Список игрушек");

        int[] resultQuiz = Lottery.startQuiz(toys); // активация игры и общий список всех игрушек участвующих в викторине
        int [] numberToys = Toys.findNumberToys(resultQuiz,toys); // общее количество игрушек по каждой категории после сортировки

        int[] findId = Toys.findId(toys); // нахождение всех id из списка


        SmallToys restSmallToys = new SmallToys();
        int res1 = restSmallToys.getRest(toys,numberToys,findId[0]); // получение остатка маленьких игрушек


        MediumToys mediumToys = new MediumToys();
        int res2 = mediumToys.getRest(toys,numberToys,findId[1]);  // получение остатков средних игрушек


        BigToys bigToys = new BigToys();
        int res3 = bigToys.getRest(toys,numberToys,findId[2]); // получение остатков больших игрушек


        List<Toys> newToysList = Toys.geNewtListToys(res1,res2,res3,findId); // новый список с новыми значениями по остаткам
        toys = newToysList; // перезапись старого списка на новые значения.
        Toys.showList(toys,"Список с остатками игрушек");

    }
}
