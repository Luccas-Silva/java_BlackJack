package BlackJack.BJ;

import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.model.Card;
import BlackJack.model.Token;
import BlackJack.model.User;
import BlackJack.service.APIService;
import BlackJack.service.UserService;

public class App {
	 
    public static void main( String[] args ) {
    	Scanner sc = new  Scanner(System.in);
    	
    	APIService apiservice = new APIService();
        
    	Token token = apiservice.getToken();
          
    	UserService userservice = new UserService();
        
    	User dealer = new User();
    	User player = new User();
        
    	System.out.println(" \n====================================================");
    	System.out.println(""
    			+ "  ____  _            _           _            _     \r\n"
        		+ " |  _ \\| |          | |         | |          | |    \r\n"
        		+ " | |_) | | __ _  ___| | __      | | __ _  ___| | __ \r\n"
        		+ " |  _ <| |/ _` |/ __| |/ /  _   | |/ _` |/ __| |/ / \r\n"
        		+ " | |_) | | (_| | (__|   <  | |__| | (_| | (__|   <  \r\n"
        		+ " |____/|_|\\__,_|\\___|_|\\_\\  \\____/ \\__,_|\\___|_|\\_\\ \r\n"
        		+ "");
        System.out.println("====================================================\n");
        
        player.setCards(userservice.buyCards(token.getDeck_id()));
        player.addCards(userservice.buyCards(token.getDeck_id()));
        player.addCards(userservice.buyCards(token.getDeck_id()));
        
        System.out.println("____________________");
        System.out.println("     ♠️ Player ♠️");
        System.out.println("--------------------");
        System.out.print("  Cards: ");
        for (Card c: player.getCards()) { System.out.print(c.getCode()+" ");}
        System.out.println("");
        player.setCardsSum(userservice.countCards(player.getCards()));
        System.out.println("  CardsSum: "+player.getCardsSum());
        player.setTotalWins(1);
        System.out.println("  TotalWins: ("+player.getTotalWins()+"/3)");
        System.out.print("____________________");
        
        
        sc.close();
        
    }
}
