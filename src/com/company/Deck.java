package com.company;

import java.util.Arrays;
import java.util.Random;

public class Deck {
    private final Card[] cards;

    public Deck() {
        cards = new Card[13*4];
        int i = 0;

        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[i] = new Card(rank, suit);
                i++;
            }
        }

    }

    public void shuffle() {
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