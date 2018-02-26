package com.val.typeinfo;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {

    public Staff(String... jobTitles){
        add(jobTitles);
    }

    public void add(String jobTitle, Person employee) {
        super.add(new Position(jobTitle, employee));
    }

    public void add(String... jobTitles){
        for(String title: jobTitles){
            super.add(new Position(title));
        }
    }

    public boolean positionAvailable(String title){
        for (Position p: this){
            if(p.getJobTitle().equals(title) &&
                    p.getEmployee() == Person.NULL){
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String jobTitle, Person hire){
        for (Position p : this){
            if(p.getJobTitle().equals(jobTitle) &&
                    p.getEmployee() == Person.NULL){
                p.setEmployee(hire);
                return;
            }
        }
    }

}
