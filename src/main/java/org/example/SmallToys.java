package org.example;

public class SmallToys extends Toys{
    private int volume;

    public SmallToys(long id, String name, int weight, int volume) {
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
}
