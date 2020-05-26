package com.company;

public class BlackjackCard extends Card {
    private final int scores;

    public BlackjackCard(int rank, int suit) {
        super(rank, suit);
        scores = Math.min(rank, 10);
    }

    public int getScores() {
        return scores;
    }
}