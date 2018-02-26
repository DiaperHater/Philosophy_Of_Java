package com.val.typeinfo;

public class Position {
    String jobTitle;
    Person employee;

    public Position(String jobTitle, Person employee){
        this.jobTitle = jobTitle;
        if(employee == null){
            this.employee = Person.NULL;
        }
    }

    public Position(String jobTitle){
        this.jobTitle = jobTitle;
        employee = Person.NULL;
    }

    public String getJobTitle(){return jobTitle;}

    public void setJobTitle(String newTitle){
        jobTitle = newTitle;
    }

    public Person getEmployee(){return employee;}

    public void setEmployee(Person newEmployee){
        employee = newEmployee;
        if(newEmployee == null){
            employee = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return String.format("Position: %s Employee: %s\n",
                jobTitle, employee);
    }
}
