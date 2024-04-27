package BlackJack.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import BlackJack.model.Card;
import BlackJack.model.Token;

public class APIService {
	
	public Token getToken() {
		Token token = null;
		
		HttpGet request = new HttpGet("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
		
		try (CloseableHttpClient httpClient = 
				HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)){
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				Gson gson = new Gson();
				token = gson.fromJson(result, Token.class);
			}
			
			return token;
			
		} catch (Exception e) {
			System.err.println("Critical Error");
			e.printStackTrace();
			return null;
		}
	}
	
	public Card getCard() {
		return null;
	}

}
