package ru.job4j.tracker.pojo;

import java.util.Date;

public class Student {

    private String name;
    private String group;
    private Date created;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getGroup() {

        return group;
    }

    public void setGroup(String group) {

        this.group = group;
    }

    public Date getCreated() {

        return created;
    }

    public void setCreated(Date created) {

        this.created = created;
    }
}

    class College {
        public static void main(String[] args) {
            Student student = new Student();
            student.setName("Petr Petrovich Ivanov");
            student.setCreated(new Date());
            student.setGroup("103A");

            System.out.println(student.getName() + " has been studying since " + student.getCreated() + " in the group №" + student.getGroup());
        }
    }

