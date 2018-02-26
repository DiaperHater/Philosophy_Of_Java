package com.val.typeinfo.pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {

    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();

    private static final List<Class<? extends Pet>> availableTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Cur.class,
                    Cymric.class,
                    EgyptianMau.class,
                    Manx.class,
                    Pug.class
            ));

    private static void loader(){
        try{
            for(Class<? extends Pet> c: availableTypes){
                types.add(c);
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
