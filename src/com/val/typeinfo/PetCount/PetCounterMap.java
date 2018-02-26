package com.val.typeinfo.PetCount;

import com.val.typeinfo.pets.Pet;

import java.util.HashMap;

public class PetCounterMap extends HashMap<String, Integer> {
    public void count(String type){
        Integer amount = get(type);

        if(amount == null){
            put(type, 1);
        }else{
            put(type, amount+1 );
        }
    }
}
