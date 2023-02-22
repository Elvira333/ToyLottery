package org.example;

import java.util.List;

public class SmallToys extends Toys{
    private int volume;

    public SmallToys(){

    }
    public SmallToys(int id, String name, int weight, int volume) {
        super(id, name, weight);
        this.volume=volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return super.toString() + " " + volume + " шт.";
    }



    public int getRest(List<Toys> list, int[] res, int id) {
        int rest = 0;
        for (Toys toy : list) {
            if (toy instanceof SmallToys && toy.getId() == id) {
                SmallToys smallToys = (SmallToys) toy;
                rest = smallToys.getVolume() - res[id - 1];
                smallToys.setVolume(rest);
                break; // выходим из цикла, когда найден нужный объект
            }
        }
        return rest;
    }
}
