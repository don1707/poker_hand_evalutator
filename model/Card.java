package model;

public class Card {
    private int rank;
    private String suit;

    public Card (int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public int getRank () {
        return rank;
    }
    public String getSuit () {
        return suit;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (rank == 1){
            sb.append(Consts.RANK_ACE).append(" " + suit).append("\n");
        } else if (rank == 11) {
            sb.append(Consts.RANK_JACK).append(" " + suit).append("\n");
        } else if (rank == 12) {
            sb.append(Consts.RANK_QUEEN).append(" " + suit).append("\n");
        } else if (rank == 13) {
            sb.append(Consts.RANK_KING).append(" " + suit).append("\n");
        } else{
            sb.append(rank).append(" " + suit).append("\n");
        }
        return sb.toString();
    }

}