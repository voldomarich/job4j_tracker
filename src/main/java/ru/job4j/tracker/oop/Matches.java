package ru.job4j.tracker.oop;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок, " : "Второй игрок, ";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            for (int i = 1; i < 4; i++) {
                    matches = 11 - i;
                }
                turn = !turn;
            }
            if (!turn) {
                System.out.println("Выиграл первый игрок");
            } else {
                System.out.println("Выиграл второй игрок");
            }
        }
    }
