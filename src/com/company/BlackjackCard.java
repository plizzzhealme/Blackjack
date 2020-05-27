package com.company;

public class BlackjackCard extends Card {
    public BlackjackCard(int rank, int suit) {
        super(rank, suit);
    }

    @Override
    public int getRank() {
        int rank = super.getRank();

        if (rank == Card.ACE) {
            return 11;
        }

        if (rank > Card.TEN) {
            return 10;
        }

        return rank;
    }
}