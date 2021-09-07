package ru.job4j.tracker.encapsulation;

public class Config {
        String name;

        private int position;

        private String properties;

        public void print() {
        System.out.println(this.position);
        System.out.println(this.properties);
        }

        public void config(String name) {
           this.properties = name;
        }

        private String search(String key) {
        return key;
        }

        private String getProperty(String key) {
            return search(key);
        }
    }
