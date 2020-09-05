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

    public boolean isPair () { // 2 equal cards
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

    public boolean isPairDouble () { // 2 equal cards + 2 equal cards
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

    public boolean isTriple () { // 3 equal cards
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

    public boolean isStraight () {  // 5 cards sequential rank
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

    public boolean isFull () { // 3 equal cards rank + 2 equal cards rank
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

    public boolean isFlush () { // 4 cards same suit
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

    public boolean isQuad () { // 4 cards same rank
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

    public boolean isStraightFlush () { // 5 cards sequential rank and same suit
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