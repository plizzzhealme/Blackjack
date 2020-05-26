package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Deck deck;
    private int playerScores;
    private int dealerScores;
    private final List<Card> playerCards;
    private final List<Card> dealerCards;

    public Game() {
        deck = new Deck();
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    public void startNewGame() {
        playerScores = 0;
        dealerScores = 0;
        playerCards.clear();
        dealerCards.clear();

        deck.shuffle();
        drawCard();
        drawCard();
    }

    public void drawCard() {
        Card card;

        card = deck.getNextCard();
        playerScores += card.getRank();
        playerCards.add(card);
    }

    public void makeDealerTurns() {
        Card card;

        while (dealerScores < playerScores) {
            card = deck.getNextCard();
            dealerScores += card.getRank();
            dealerCards.add(card);
        }
    }

    @Override
    public String toString() {
        return String.format("Player: %s %d scores%nDealer: %s %d scores",
                playerCards,
                playerScores,
                dealerCards,
                dealerScores);
    }
}
