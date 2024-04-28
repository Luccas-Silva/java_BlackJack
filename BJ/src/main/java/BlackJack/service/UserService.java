package BlackJack.service;

import java.util.ArrayList;

import BlackJack.model.Card;

public class UserService {
	
	APIService apiservice = new APIService();
	
	public ArrayList<Card> buyCards(String deck_id) {
		ArrayList<Card> cards = new ArrayList<>();
		for (int i=0; i<1; i++) {
			Card card = apiservice.getCard(deck_id);
			cards.add(card);
        }
		return cards;
	}
	
	public int countCards(ArrayList<Card> cards) {
		int total = 0;
		
	    for (Card c : cards) {
	    	if (c.getValue().equals("ACE")) {
	    		total += 1;
	        }
	        else if (c.getValue().equals("KING") || c.getValue().equals("QUEEN") || c.getValue().equals("JACK")) {
	        	total += 10;
	        }
	        else {
	        	total += Integer.parseInt(c.getValue());
	        }
	    }
		return total;
	}

}
