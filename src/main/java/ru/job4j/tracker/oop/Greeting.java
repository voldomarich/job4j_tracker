package ru.job4j.tracker.oop;

import java.util.Scanner;
import java.util.Random;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите Ваш вопрос");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Да");
        } else if (answer == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
        System.out.println(name + ", рад Вас видеть!");
    }
}
