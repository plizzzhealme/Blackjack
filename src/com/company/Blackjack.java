package com.company;

import java.util.ArrayList;
import java.util.List;


public class Blackjack {
    /**
     * If the player exceeds a sum of 21 the player loses
     */
    public static final int BLACKJACK = 21;

    /**
     * Dealer must hit until the cards total up to 17 points,
     * at 17 points or higher the dealer must stay
     */
    public static final int DEALER_LIMIT = 17;

    /**
     * Deck instance to play with
     */
    private final Deck deck;

    /**
     * Player's cards
     */
    private final List<Card> playerHand;

    /**
     * Dealer's cards
     */
    private final List<Card> dealerHand;

    /**
     * Player's points in his hand
     */
    private int playerPoints;

    /**
     * Dealer's points in his hand
     */
    private int dealerPoints;

    /**
     * Round ends in 3 cases:
     * 1 - Player has a blackjack right after a deal
     * 2 - Player has busts
     * 3 - After dealer's turn
     */
    private boolean roundEnded;

    public Blackjack() {
        deck = new Deck();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    /**
     * Starts new round
     */
    public void deal() {
        roundEnded = false;

        // clear hands from old cards
        playerHand.clear();
        dealerHand.clear();

        // shuffle the deck
        deck.shuffle();

        // 2 cards to player
        playerHand.add(deck.getNextCard());
        playerHand.add(deck.getNextCard());
        playerPoints = countPoints(playerHand);

        // end the round automatically if we have blackjack right after the deal
        if (playerPoints == BLACKJACK) {
            roundEnded = true;
        }

        // 1 card to dealer
        dealerHand.add(deck.getNextCard());
        dealerPoints = countPoints(dealerHand);
    }

    /**
     * Adds one card to the player's hand
     */
    public void hit() {
        // draw a card
        playerHand.add(deck.getNextCard());

        // and recalculate points
        playerPoints = countPoints(playerHand);

        // end the round automatically if we have busts in player's hand
        if (playerPoints > BLACKJACK) {
            roundEnded = true;
        }

        // make dealer turn automatically if we have blackjack in player's hand
        if (playerPoints == BLACKJACK) {
            makeDealerTurn();
        }
    }

    /**
     * Dealer hits until the cards total up to 17 points
     */
    public void makeDealerTurn() {
        if (playerPoints <= BLACKJACK) {
            while (dealerPoints < DEALER_LIMIT) {
                dealerHand.add(deck.getNextCard());
                dealerPoints = countPoints(dealerHand);
            }
        }

        // end the round after dealer's turn
        roundEnded = true;
    }

    /**
     * Counts points in the hand
     * @param hand player's or dealer's cards
     * @return points value
     */
    private int countPoints(List<Card> hand) {
        int points = 0;

        // count with Ace value = 11
        for (Card card : hand) {
            points += card.getRank();
        }

        // If busts, recount with Ace value = 1
        if (points > BLACKJACK) {
            points = 0;

            for (Card card : hand) {
                int rank = card.getRank();

                if (rank == BlackjackCard.ACE_ELEVEN_VALUE) {
                    rank = BlackjackCard.ACE_ONE_VALUE;
                }
                points += rank;
            }
        }
        return points;
    }

    public boolean isRoundEnded() {
        return roundEnded;
    }

    public boolean isWon() {
        if (playerPoints > BLACKJACK) {
            return false;
        }

        return playerPoints > dealerPoints;
    }

    @Override
    public String toString() {
        return String.format("Player: %s %d scores%nDealer: %s %d scores",
                playerHand,
                playerPoints,
                dealerHand,
                dealerPoints);
    }
}