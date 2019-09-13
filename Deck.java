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
    
    public void setCard(int index, Card card) {
    	cards.set(index, card);
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
    
    
    //organizes deck in numerical order
    public void organizeDeck() {
    	boolean organized = false;
    	while (!organized) {
    		organized = true;
    		for(int i = 0; i<cards.size()-1; i++) {
    			if(cards.get(i).rank>cards.get(i+1).rank) {
    				swap(i, i+1);
    				organized = false;
    			}
    		}
    	}
    }
    
    public void swap(int index1, int index2) {
    	Card temp = cards.get(index1);
    	cards.set(index1, cards.get(index2));
    	cards.set(index2, temp);
    }
    }