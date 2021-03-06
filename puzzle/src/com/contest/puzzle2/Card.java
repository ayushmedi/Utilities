package com.contest.puzzle2;

public class Card {
	private String suit;
	private String rank;
	
	
	public Card(String suit, String rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {   //note... it will be useful for printing the card -- these can be auto generated in eclipse
		//return "Card [suit=" + suit + ", rank=" + rank + "]";
		return rank+"-"+suit;
	}

	@Override
	public int hashCode() { //these can be auto generated in eclipse
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {  //these can be auto generated in eclipse
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	
}
