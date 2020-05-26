package com.company;

public class Game {
    //TODO add game methods, now is just for deck tests

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
