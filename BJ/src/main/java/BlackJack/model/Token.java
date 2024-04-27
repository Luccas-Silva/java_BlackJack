package BlackJack.model;

public class Token {
	
	private Boolean success;
	private String deck_id;
	private Integer remaining;
	private Boolean shuffled;
		
	public Token() {
	}
	public Token(Boolean success, String deck_id, Integer remaining, Boolean shuffled) {
		this.success = success;
		this.deck_id = deck_id;
		this.remaining = remaining;
		this.shuffled = shuffled;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public String getDeck_id() {
		return deck_id;
	}
	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}
	
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	
	public Boolean getShuffled() {
		return shuffled;
	}
	public void setShuffled(Boolean shuffled) {
		this.shuffled = shuffled;
	}
	
	@Override
	public String toString() {
		return "Token ["
				+ "\n Success: " + success 
				+ "\n Deck_id: " + deck_id 
				+ "\n Remaining: " + remaining 
				+ "\n Shuffled: "+ shuffled 
				+ "\n]";
	}
	
}