package com.company;

public class BlackjackCard extends Card {
    private final int scores;

    public BlackjackCard(String rank, String suit, int scores) {
        super(rank, suit);
        this.scores = scores;
    }

    public int getScores() {
        return scores;
    }
}
