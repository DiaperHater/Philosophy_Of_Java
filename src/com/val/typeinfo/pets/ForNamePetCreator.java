package com.val.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();

    private static String[] names = {
            "com.val.typeinfo.pets.Cat",
            "com.val.typeinfo.pets.Cur",
            "com.val.typeinfo.pets.Cymric",
            "com.val.typeinfo.pets.Dog",
            "com.val.typeinfo.pets.EgyptianMau",
            "com.val.typeinfo.pets.Manx",
            "com.val.typeinfo.pets.Pug"
    };

    private static void loader(){
        try{
            for(String className: names){
                types.add( (Class<? extends Pet>) Class.forName(className) );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
}
