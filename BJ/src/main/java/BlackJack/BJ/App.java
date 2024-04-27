package BlackJack.BJ;

import java.util.ArrayList;

import BlackJack.model.Card;
import BlackJack.model.Token;
import BlackJack.service.APIService;

public class App {
	 
    public static void main( String[] args ) {
    	
        APIService apiservice = new APIService();
        
        Token token = apiservice.getToken();
        System.out.println(token);
        
        ArrayList<Card> cards = new ArrayList<>();
        for (int i=0; i<5; i++) {
        	Card card = apiservice.getCard(token.getDeck_id());
            cards.add(card);
        }
        
        for (Card c : cards) {
        	System.out.println(c.getCode());
        }
        
        
    }
}
