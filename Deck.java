import java.util.ArrayList;
import java.lang.Math;
public class Deck
{ 
    ArrayList<Card> cards = new ArrayList<Card>();
	public Deck()
	{
    }
	
	
    public void addCard(Card card){
    cards.add(card);
    }
    
    
    public Card getCard(int index) {
    	return cards.get(index);
    }
    
    
    public int getLength() {
    	return cards.size();
    }
    
    
    public void shuffle() {
    	for(int i = 0; i< (int) (Math.random()*10+104); i++) {
    		int index = (int) (Math.random()*52);
    		cards.add(cards.get(index));
    		cards.remove(index);
    	}
    }
    
    //Removes 0th card from deck and adds it the inputed hand
    public void dealCard(Deck hand) {
    	hand.addCard(cards.get(0));
    	cards.remove(0);
    }
    }