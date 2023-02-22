package org.example;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<Toys> toys = Toys.getListToys();
        Toys.showList(toys, "Список игрушек");

        try {
            int[] resultQuiz = Lottery.startQuiz(toys); // активация игры и общий список всех игрушек участвующих в викторине
            int [] numberToys = Toys.findNumberToys(resultQuiz,toys); // общее количество игрушек по каждой категории после сортировки
            int[] findId = Toys.findId(toys); // нахождение всех id из списка
            int [] totalBalance = Toys.totalBalance(toys,numberToys,findId);
            List<Toys> newToysList = Toys.geNewtListToys(totalBalance,findId); // новый список с новыми значениями по остаткам
            toys = newToysList; // перезапись старого списка на новые значения.
            Toys.showList(toys,"Список с остатками игрушек");
        }
        catch (Exception e) {
            System.out.println("Попробуйте ещё раз: " + e.getMessage());
        }
    }
}
