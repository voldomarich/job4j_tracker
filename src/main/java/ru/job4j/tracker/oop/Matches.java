package ru.job4j.tracker.oop;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches == 3) {
                System.out.println("Игра завершена.");
                turn = false;
            } else if (matches == 1) {
                System.out.println("Танчики загружаются ... ");
            } else if (matches == 2) {
                System.out.println("Супер Марио загружается ... ");
            } else {
                System.out.println("Такой игры нет.");
            }
            System.out.println();
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
