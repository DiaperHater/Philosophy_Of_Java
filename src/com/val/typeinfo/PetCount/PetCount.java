package com.val.typeinfo.PetCount;

import com.val.typeinfo.pets.LiteralPetCreator;
import com.val.typeinfo.pets.Pet;
import com.val.typeinfo.pets.PetCreator;

public class PetCount {

    public static void countPets(PetCreator creator){
        PetCounterMap counter = new PetCounterMap();
        for(Pet pet: creator.arrayList(20)){
            counter.count(pet.getName());
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new LiteralPetCreator());
    }
}
