package BlackJack.model;

public class Card {

	private String code;
    private String value;
	private String suit;
   	private Integer remaining;
   	
	public Card() {
	}
	public Card(String code, String value, String suit, Integer remaining) {
		this.code = code;
		this.value = value;
		this.suit = suit;
		this.remaining = remaining;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	
	@Override
	public String toString() {
		return "Card ["
				+ "\n Code: " + code 
				+ "\n Value: " + value 
				+ "\n Suit: " + suit 
				+ "\n Remaining: " + remaining 
				+ "\n]";
	}
  
}