package BlackJack.BJ;

import BlackJack.model.Token;
import BlackJack.service.APIService;

public class App {
	 
    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        APIService apiservice = new APIService();
        
        Token token = apiservice.getToken();
        System.out.print(token);
        
    }
}
