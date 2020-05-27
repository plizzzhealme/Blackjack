package com.company;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final Blackjack game = new Blackjack();

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        int option;
        boolean gameEnded = false;

        while (!gameEnded) {
            printGameMenu();
            option = getInt();

            switch (option) {
                case 1:
                    playRound();
                    break;
                case 2:
                    gameEnded = true;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        }
    }

    private static void playRound() {
        game.deal();

        while (!game.isRoundEnded()) {
            int option;

            printRoundMenu();
            option = getInt();

            switch (option) {
                case 1:
                    game.hit();
                    break;
                case 2:
                    game.makeDealerTurn();
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }

        }
        System.out.println(game);
        System.out.println(game.isWon() ? "You won!" : "You lost!");
    }

    private static void printGameMenu() {
        System.out.println("1 - Deal");
        System.out.println("2 - Quit");
    }

    private static void printRoundMenu() {
        System.out.println(game);
        System.out.println("1 - Hit");
        System.out.println("2 - Stand");
    }

    public static int getInt() {
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter an integer");
        }
        return in.nextInt();
    }
}