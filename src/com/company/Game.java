package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Deck deck;
    private int playerScores;
    private int dealerScores;
    private final List<Card> playerHand;
    private final List<Card> dealerHand;

    public Game() {
        deck = new Deck();
        System.out.println(deck);
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    public void startNewRound() {
        playerHand.clear();
        dealerHand.clear();

        deck.shuffle();

        playerHand.add(deck.getNextCard());
        playerHand.add(deck.getNextCard());
        playerScores = calcScores(playerHand);

        dealerHand.add(deck.getNextCard());
        dealerScores = calcScores(dealerHand);

    }

    public void drawCard() {
        Card card;

        card = deck.getNextCard();
        playerScores += card.getRank();
        playerHand.add(card);
    }

    public void makeDealerTurns() {
        if (playerScores <= 21) {
            while (dealerScores < playerScores) {
                dealerHand.add(deck.getNextCard());
                dealerScores = calcScores(dealerHand);
            }
        }
    }

    private int calcScores(List<Card> hand) {
        int scores = 0;

        for (Card card : hand) {
            scores += card.getRank();
        }

        if (scores > 21) {
            scores = 0;

            for (Card card : hand) {
                int rank = card.getRank();

                if (rank == 11) {
                    rank = 1;
                }
                scores += rank;
            }
        }
        return scores;
    }

    @Override
    public String toString() {
        return String.format("Player: %s %d scores%nDealer: %s %d scores",
                playerHand,
                playerScores,
                dealerHand,
                dealerScores);
    }
}