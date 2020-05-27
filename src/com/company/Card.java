package com.company;

public class Card {
    private final int rank;
    private final int suit;

    // suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;

    // ranks
    public final static int ACE   = 1;
    public final static int DEUCE = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suitToString() + rankToString();
    }

    private String rankToString() {
        switch (rank) {
            case DEUCE:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
                return String.valueOf(rank);
            case TEN:
                return "T";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
            case ACE:
                return "A";
            default:
                return null;
        }
    }

    private String suitToString() {
        switch (suit) {
            case DIAMONDS:
                return "D";
            case CLUBS:
                return "C";
            case HEARTS:
                return "H";
            case SPADES:
                return "S";
            default:
                return null;
        }
    }

    public int getRank() {
        return rank;
    }
}