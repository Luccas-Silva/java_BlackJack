package BlackJack.BJ;

import java.util.Scanner;

import BlackJack.model.Card;
import BlackJack.model.Token;
import BlackJack.model.User;
import BlackJack.service.APIService;
import BlackJack.service.UserService;

public class App {
	 
    public static void main( String[] args ) {
    	Scanner sc = new  Scanner(System.in);
    	
    	// Estabelecendo conexão com a API e obtendo Token
    	APIService apiservice = new APIService();
    	Token token = apiservice.getToken();
        
    	// Criando usuários e serviço
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
        
        System.out.print("	Pressione Enter para começar a jogar");
        String trigger = sc.nextLine();
        System.out.println("");

        do {
            System.out.println("\n\n Nova rodada de Black Jack");
            
        	System.out.println("____________________");
            System.out.println("     ♥️ Dealer ♦️");
            System.out.println("--------------------");
			
            // Criando lista de cards do Dealer
            dealer.setCards(userservice.buyCards(token.getDeck_id()));
            
            System.out.print("  Cards: ");
            for (Card c: dealer.getCards()) { System.out.print(c.getCode()+" "); }
            System.out.println("");
            
            // Obtendo soma dos valores da lista de cards do Dealer
            dealer.setCardsSum(userservice.countCards(dealer.getCards()));
            System.out.println("  CardsSum: "+dealer.getCardsSum());
            
            System.out.println("  TotalWins: ("+dealer.getTotalWins()+"/3)");
            
            // Criando lista de cards do Player
            player.setCards(userservice.buyCards(token.getDeck_id()));
            
            // Inserindo itens na lista de cards do Player
            player.addCards(userservice.buyCards(token.getDeck_id()));
            
            char option;
            do {
            	System.out.println("____________________");
                System.out.println("     ♣️ Player ♠️");
                System.out.println("--------------------");
                
                System.out.print("  Cards: ");
                for (Card c: player.getCards()) { System.out.print(c.getCode()+" ");}
                System.out.println("");
                
                // Obtendo soma dos valores da lista de cards do Player
                player.setCardsSum(userservice.countCards(player.getCards()));
                System.out.println("  CardsSum: "+player.getCardsSum());
                
                System.out.println("  TotalWins: ("+player.getTotalWins()+"/3)");
                
                System.out.println("-------------------------");
                System.out.println("| [1] Hit (Pedir carta) |");
                System.out.println("| [2] Stand (Ficar)     |");
                System.out.println("-------------------------");
                System.out.print(" Selecione uma das opções disponíveis: ");
                option = sc.next().toLowerCase().charAt(0); 
                
                if (option == '1') {
                	// Inserindo itens na lista de cards do Player
                	player.addCards(userservice.buyCards(token.getDeck_id()));
                	// Obtendo soma dos valores da lista de cards do Player
                	player.setCardsSum(userservice.countCards(player.getCards()));
                }
				
			} while (option != '2' && player.getCardsSum() < 21);
            
           if(player.getCardsSum() > 21) {
        	   System.out.println("____________________");
               System.out.println("     ♣️ Player ♠️");
               System.out.println("--------------------");
               
               System.out.print("  Cards: ");
               for (Card c: player.getCards()) { System.out.print(c.getCode()+" ");}
               System.out.println("");
               
               // Obtendo soma dos valores da lista de cards do Player
               player.setCardsSum(userservice.countCards(player.getCards()));
               System.out.println("  CardsSum: "+player.getCardsSum());
               
               System.out.println("  TotalWins: ("+player.getTotalWins()+"/3)");
           }
            
           // IA Dealer
           do {
        	   option = '1';
        	   
        	   if (dealer.getCardsSum() <= 11) {
        		   dealer.addCards(userservice.buyCards(token.getDeck_id())); 
        		   dealer.setCardsSum(userservice.countCards(dealer.getCards()));
        	   }
        	   else {option = '2'; }
        	   
           } while (option != '2' && dealer.getCardsSum() < 21);             
            
            System.out.println("____________________");
            System.out.println("     ♥️ Dealer ♦️");
            System.out.println("--------------------");
            
            System.out.print("  Cards: ");
            for (Card c: dealer.getCards()) { System.out.print(c.getCode()+" ");}
            System.out.println("");
            
            // Obtendo soma dos valores da lista de cards do Dealer
            dealer.setCardsSum(userservice.countCards(dealer.getCards()));
            System.out.println("  CardsSum: "+dealer.getCardsSum());
            
            System.out.println("  TotalWins: ("+dealer.getTotalWins()+"/3)");
          
            if (player.getCardsSum() > 21) {
            	dealer.setTotalWins(dealer.getTotalWins() +1);
            	System.out.println("\n============================");
            	System.out.println("	Você Perdeu!");
            	System.out.print("============================");;
            }
            else if (dealer.getCardsSum() > 21) {
            	player.setTotalWins(player.getTotalWins() +1);
            	System.out.println("\n============================");
            	System.out.println("	Você Ganhou!");
            	System.out.print("============================");
            }
            else if (player.getCardsSum() < dealer.getCardsSum()) {
            	dealer.setTotalWins(dealer.getTotalWins() +1);
            	System.out.println("\n============================");
            	System.out.println("	Você Perdeu!");
            	System.out.print("============================");
            }
            else if (dealer.getCardsSum() < player.getCardsSum()) {
            	player.setTotalWins(player.getTotalWins() +1);
            	System.out.println("\n============================");
            	System.out.println("	Você Ganhou!");
            	System.out.print("============================");
            }
            else {
            	System.out.println("\n============================");
            	System.out.println("	   Empate");
            	System.out.print("============================");
            }
           
		} while (player.getTotalWins() < 3 && dealer.getTotalWins() < 3);
        
        System.out.println("\n\n	   Obrigado por Jogar.");
		System.out.println("  #------------------------------------#");
		System.out.println("  | Nome: Luccas Silva    | RM: 552890 | ");
		System.out.println("  #------------------------------------#");
         
        sc.close();
    }
}
