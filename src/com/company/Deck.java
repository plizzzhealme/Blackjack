package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private int current;
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>(52);

        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards.add(new BlackjackCard(rank, suit));
            }
        }
    }

    public Card getNextCard() {
        return cards.get(current++);
    }

    public void shuffle() {
        current = 0;
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}