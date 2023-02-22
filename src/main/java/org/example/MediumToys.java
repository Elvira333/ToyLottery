package org.example;

import java.util.List;

public class MediumToys extends Toys{
    private int volume;

    public MediumToys(){

    }
    public MediumToys(int id, String name, int weight, int volume) {
        super(id, name, weight);
        this.volume = volume;
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
            if (toy instanceof MediumToys && toy.getId() == id) {
                MediumToys mediumToys = (MediumToys) toy;
                rest = mediumToys.getVolume() - res[id - 1];
                mediumToys.setVolume(rest);
                break; // выходим из цикла, когда найден нужный объект
            }
        }
        return rest;
    }
}
