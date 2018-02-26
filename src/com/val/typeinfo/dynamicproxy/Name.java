package com.val.typeinfo.dynamicproxy;

public class Name implements Interface {

    String name = "no name";

    Name(){}

    Name(String name){
        this.name = name;
    }

    @Override
    public void setName(String firstName, String lastName) {
        this.name = String.format("%s %s", firstName, lastName);
    }

    @Override
    public String getName() {
        return name;
    }
}
