package ru.job4j.additional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingMethod {

    public static class Company {

        private String name;

        public Company(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Worker {

        private int age;

        private Company company;

        public Worker(int age, Company company) {
            this.age = age;
            this.company = company;
        }

        public int getAge() {
            return age;
        }

        public Company getCompany() {
            return company;
        }
    }

    public static Map<String, Double> groupAndCount(List<Worker> workers) {
        return workers.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getCompany().getName(),
                        Collectors.averagingDouble(Worker::getAge)
                ));
     }
 }
