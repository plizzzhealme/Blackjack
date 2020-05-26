package com.company;

public class BlackjackCard extends Card {
    public BlackjackCard(int rank, int suit) {
        super(rank, suit);
    }

    public int getRank() {
        return Math.min(super.getRank(), 10);
    }
}