package com.val.typeinfo;

import com.val.util.Null;

public class Person {
    public String firstName;
    public String lastName;
    public String address;

    public Person(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String toString(){
        return "Person: "+firstName+" "+lastName+" "+address;
    }

    public static class NullPerson
        extends Person implements Null{

        public NullPerson() {
            super("none", "none", "none");
        }
    }

    public static final Person NULL = new NullPerson();

}
