package BlackJack.model;

import java.util.ArrayList;

public class User {
	
	private ArrayList<Card> cards;
	private Integer cardsSum;
	private Integer totalWins = 0;
	
	// Construtores
	public User() {

	}
	public User(ArrayList<Card> cards, Integer cardsSum, Integer totalWins) {
		this.cards = cards;
		this.cardsSum = cardsSum;
		this.totalWins = totalWins;
	}
	
	// Getters e Setters
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public void addCards(ArrayList<Card> card) {
		this.cards.addAll(card);
	}
	
	public Integer getCardsSum() {
		return cardsSum;
	}
	public void setCardsSum(Integer cardsSum) {
		this.cardsSum = cardsSum;
	}
	
	public Integer getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(Integer totalWins) {
		this.totalWins = totalWins;
	}
	
	// Print dos Dados
	@Override
	public String toString() {
		return "User ["
				+ "\n Cards: " + cards
				+ "\n Cards Sum: " + cardsSum
				+ "\n Total Wins: " + totalWins
				+ "\n]";
	}
}
