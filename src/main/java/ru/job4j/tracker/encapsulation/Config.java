package ru.job4j.tracker.encapsulation;

public class Config {

        private String name;
        private int position;
        private String properties;

        public Config(String name) {
           this.properties = name;
        }

        public void print() {
        System.out.println(this.position);
        System.out.println(this.properties);
        System.out.println(this.name);
        }

        private String search(String key) {
            return key;
        }

        public String getProperty(String key) {
            return search(key);
        }
    }
