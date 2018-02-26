package com.val.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random random = new Random();

    public abstract List<Class<? extends Pet>> getTypes();


    public Pet randomPet(){
        int n = random.nextInt(getTypes().size());
        Pet result = null;

        try {
            result = getTypes().get(n).newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];

        for (int i = 0; i < size; i++){
            result[i] = randomPet();
        }

        return result;
    }

    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
