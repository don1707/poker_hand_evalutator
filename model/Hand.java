package model;

import java.util.*;

public class Hand {
    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand () {
        return hand;
    }

    public void addCard (Card c) {
        this.hand.add(c);
    }

    public boolean isPair () { // 2 cards eq
        int n = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((i != j) && (hand.get(i).getRank() == hand.get(j).getRank())) {
                    n ++;
                }
            }
        }
        if (n == 2) {
            return true;
        }
        return false;
    }

    public boolean isPairDouble () { // 2 cards eq + 2 cards eq
        int n = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((i != j) && (hand.get(i).getRank() == hand.get(j).getRank())) {
                    n ++;
                }
            }
        }
        if (n == 4) {
            return true;
        }
        return false;
    }

    public boolean isTriple () { // 3 cards eq
        int n = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((i != j) && (hand.get(i).getRank() == hand.get(j).getRank())) {
                    n ++;
                }
            }
        }
        if (n == 6) {
            return true;
        }
        return false;
    }

    public boolean isStraight () {  // rank, rank+1, rank+2, rank+3, rank+4
        int n = 0;
        Collections.sort(hand, new Comparator<Card>(){
            public int compare (Card c1, Card c2) {
                return Integer.valueOf(c1.getRank()).compareTo(c2.getRank());
            }
        });
        for (int i = 0; i < hand.size()-1; i++) {
            if (hand.get(i).getRank() == hand.get(i+1).getRank()-1) {
                n++;
            }
        }
        if (n == 4) {
            return true;
        }
        return false;
    }

    public boolean isFull () { // 3 cards eq and 2 eq
        if (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(3).getRank() == hand.get(4).getRank()) {
            if (hand.get(1).getRank() != hand.get(2).getRank() && hand.get(2).getRank() == hand.get(3).getRank()) {
                return true;
            }
        }
        if (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(3).getRank() == hand.get(4).getRank()) {
            if (hand.get(1).getRank() == hand.get(2).getRank() && hand.get(2).getRank() != hand.get(3).getRank()) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlush () {
        int n = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((i != j) && (hand.get(i).getSuit().equals(hand.get(j).getSuit()))) {
                    n ++;
                }
            }
        }
        if (n == 20) {
            return true;
        }
        return false;
    }

    public boolean isQuad () {
        int n = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((i != j) && (hand.get(i).getRank() == hand.get(j).getRank())) {
                    n ++;
                }
            }
        }
        if (n == 12) {
            return true;
        }
        return false;
    }

    public boolean isStraightFlush () {
        int n = 0;
        for (int i = 0; i < hand.size()-1; i++) {
            if (hand.get(i).getRank() == hand.get(i+1).getRank()-1) {
                n++;
            }
        }
        for (int y = 0; y < hand.size(); y++) {
            for (int j = 0; j < hand.size(); j++) {
                if ((y != j) && (hand.get(y).getSuit().equals(hand.get(j).getSuit()))) {
                    n ++;
                }
            }
        }
        if (n == 22) {
            return true;
        }
        return false;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        /*for (Card c : hand) {
            sb.append().append(c).append("\n");
        }*/
        for (int i = 0; i < hand.size(); i++) {
            sb.append("Card n." + (i+1) + ": ").append(hand.get(i)).append("\n");
        }
        return sb.toString();
    }
}