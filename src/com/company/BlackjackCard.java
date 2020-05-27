package com.company;

public class BlackjackCard extends Card {
    public static final int ACE_ONE_VALUE = 1;
    public static final int ACE_ELEVEN_VALUE = 11;
    public static final int FACE_VALUE = 10;

    public BlackjackCard(int rank, int suit) {
        super(rank, suit);
    }

    @Override
    public int getRank() {
        int rank = super.getRank();

        if (rank == Card.ACE) {
            return ACE_ELEVEN_VALUE;
        }

        if (rank > Card.TEN) {
            return FACE_VALUE;
        }

        return rank;
    }
}