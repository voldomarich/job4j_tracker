package ru.job4j.tracker.oop;

public class Battery {

        private int value;

        public Battery(int value) {
            this.value = value;
        }

        public void exchange(Battery another) {
            another.value = this.value + another.value;
            this.value = 0;
        }

        public static void main(String[] args) {
            Battery first = new Battery(34);
            Battery second = new Battery(11);
            System.out.println("first : " + first.value + ". second : " + second.value);
            first.exchange(second);
            System.out.println("first : " + first.value + ". second : " + second.value);

        }
}
