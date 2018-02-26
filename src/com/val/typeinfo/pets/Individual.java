package com.val.typeinfo.pets;

public class Individual {
    private static int counter;
    private static final int id;
    private String name;

    static {
        counter = 0;
        id = counter++;
    }

    public Individual(){name = getClass().getSimpleName();};
    public Individual(String name){this.name = name;}

    public String getName(){return name;}

    @Override
    public String toString() {
        return name + " id: " + id;
    }
}
