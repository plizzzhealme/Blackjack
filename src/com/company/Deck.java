package com.company;

import java.util.Arrays;
import java.util.Random;

public class Deck {
    private int current;
    private final Card[] cards;

    public Deck() {
        cards = new BlackjackCard[52];
        int i = 0;

        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[i] = new BlackjackCard(rank, suit);
                i++;
            }
        }

    }

    public Card getNextCard() {
        Card card = cards[current];
        current++;
        return card;
    }

    public void shuffle() {
        current = 0;
        Random rnd = new Random();

        for (int i = 1; i < cards.length; i++) {
            int j = rnd.nextInt(i);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(cards);
    }
}