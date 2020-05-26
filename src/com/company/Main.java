package com.company;

import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    private static final Game game = new Game();

    public static void main(String[] args) {
        boolean workFlag = true;
        int option;

        while (workFlag) {
            printMainMenu();
            option = getInt();

            switch (option) {
                case 1:
                    playGame();
                    break;
                case 2:
                    workFlag = false;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        }
    }

    private static void playGame() {
        game.startNewGame();
        int option;
        boolean gameEnded = false;

        while (!gameEnded) {
            printGameMenu();
            option = getInt();


            switch (option) {
                case 1:
                    game.drawCard();
                    break;
                case 2:
                    game.makeDealerTurns();
                    gameEnded = true;
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }

        }
        System.out.println(game);
    }

    private static void printMainMenu() {
        System.out.println("Pick an option");
        System.out.println("1 - Start new game");
        System.out.println("2 - Quit");
    }

    private static void printGameMenu() {
        System.out.println(game);
        System.out.println("1 - One more card");
        System.out.println("2 - Enough");
    }

    public static int getInt() {
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Enter an integer");
        }
        return in.nextInt();
    }
}
