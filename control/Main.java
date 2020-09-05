package control;

import model.*;
import java.util.*;
import java.lang.*;
import it.unibas.utilita.Console;

public class Main {
    public static void main (String[] args){
        new Main().exe();
    }

    private void exe () {
        while (true) {
            Hand hand = mock();
            System.out.println("\n" + hand);
            handEvaluate(hand);
            System.out.println("-----------CONTINUE? [y/n]-----------");
            char n = readChar();
            if (n == 'n') {
                break;
            }
        }
    }

    private void handEvaluate (Hand h) {
        if (h.isStraightFlush()) {
            System.out.println("-= Straight Flush !!! =-");
        }
        else if (h.isQuad()) {
            System.out.println("-= Quad =-");
        }
        else if (h.isFlush()) {
            System.out.println("-= Flush =-");
        }
        else if (h.isFull()) {
            System.out.println("-= Full House =-");
        }
        else if (h.isStraight()) {
            System.out.println("-= Straight =-");
        }
        else if (h.isTriple()) {
            System.out.println("-= Triple =-");
        }
        else if (h.isPairDouble()) {
            System.out.println("-= Double pair =-");
        }
        else if (h.isPair()) {
            System.out.println("-= Pair =-");
        }
        else {
            System.out.println("-= NULL =-");
        }
    }

    private Hand mock () {

        Hand hand = new Hand();
        Card c1 = new Card(randRank(), randSuit());
        Card c2 = new Card(randRank(), randSuit());
        Card c3 = new Card(randRank(), randSuit());
        Card c4 = new Card(randRank(), randSuit());
        Card c5 = new Card(randRank(), randSuit());

        hand.addCard(c1);
        hand.addCard(c2);
        hand.addCard(c3);
        hand.addCard(c4);
        hand.addCard(c5);

        return hand;
    }

    private int randRank() {
        Random rand = new Random();
        int rank = rand.nextInt(13) + 1;
        return rank;
    }

    private String randSuit () {
        Random rand = new Random();
        int suit = rand.nextInt(3) + 1;
        if (suit == 1) {
            return Consts.SUIT_CLUB;
        }
        else if (suit == 2) {
            return Consts.SUIT_HEART;
        }
        else if (suit == 3) {
            return Consts.SUIT_SPADES;
        }
        else {
            return Consts.SUIT_DIAMOND;
        }
    }

    private char readChar () {
        char c = Console.leggiCarattere();
        while (c != 'n' && c != 'y') {
            System.out.println("ERROR! Retry: ");
            c = Console.leggiCarattere();
        }
        return c;
    }
}