package com.contest.puzzle2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardSuit {

	public static void main(String[] args) {
		CardSuit cards = new CardSuit();
		List<Card> deck = cards.generate();
		cards.print(deck); //our job over
		
		//**Extras**//
		
		//let's shuffle the deck
		Collections.shuffle(deck);
		cards.print(deck);
		
		//Check if 3-Diamond exists in the deck
		Card cardToSearch = new Card("Diamond","3");
		System.out.println(deck.contains(cardToSearch)); //this will always return false unless you override equals method
		
		//Check the position of 7-Heart
		cardToSearch = new Card("Club","A");
		System.out.println(deck.indexOf(cardToSearch)+1);  //+1 as index starts from 0
	}

	/**
	 * Prints each card in order
	 * @param deck
	 */
	private void print(List<Card> deck) {
		System.out.println(deck);
		
	}

	/**
	 * Creates a deck of card
	 * @return
	 */
	private List<Card> generate() {
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] suits = {"Club","Heart","Spade","Diamond"};
		
		List<Card> deck = new ArrayList<Card>();
		
		for(String suit:suits) {
			for(String rank:ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
		
		return deck;
	}
	
}
