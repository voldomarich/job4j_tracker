package ru.job4j.tracker.pojo;

import java.util.Date;

public class College {
        public static void main(String[] args) {
            Student student = new Student();
            student.setName("Petr Petrovich Ivanov");
            student.setCreated(new Date());
            student.setGroup("103A");

            System.out.println(student.getName() + " has been studying since " + student.getCreated() + " in the group №" + student.getGroup());
        }
}
