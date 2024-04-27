package BlackJack.BJ;

import java.util.ArrayList;

import BlackJack.model.Card;
import BlackJack.model.Token;
import BlackJack.model.User;
import BlackJack.service.APIService;

public class App {
	 
    public static void main( String[] args ) {
    	
        APIService apiservice = new APIService();
        
        Token token = apiservice.getToken();
        
        ArrayList<Card> cards = new ArrayList<>();
        
        User dealer = new User();
        User user = new User();
        
        user.setCards(cards);

       
       
        for (int i=0; i<1; i++) {
        	Card card = apiservice.getCard(token.getDeck_id());
            cards.add(card);
        }

        
        /* 
        for (Card c : cards) {
        	if (c.getValue().equals("ACE") || c.getValue().equals("KING") || c.getValue().equals("QUEEN") || c.getValue().equals("JACK")) {
        		total += 10;
        	}
        	else {
        		total += Integer.parseInt(c.getValue());
        	}
        }
        */
        
        System.out.println(token);
        System.out.println(cards);
        System.out.println(user);
    }
}
