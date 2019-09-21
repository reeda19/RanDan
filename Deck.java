import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Deck
{ 
    ArrayList<Card> cards = new ArrayList<Card>();
	public Deck()
	{
    }
	
	// adds a card to the deck
    public void addCard(Card card){
    cards.add(card);
    }
    
    // getCard : int -> Card
    // accesses the card at a certain index
    public Card getCard(int index) {
    	return cards.get(index);
    }
    
    // changes Card at a certain index to inputted Card
    public void setCard(int index, Card card) {
    	cards.set(index, card);
    }
    
    // Returns amount of Cards in Deck
    public int getLength() {
    	return cards.size();
    }
    
    // Shuffles deck by randomly selecting a card and putting it to the 
    // top of the deck, and repeating this a random number of times
    public void shuffle() {
    	for(int i = 0; i< (int) (Math.random()*10+104); i++) {
    		int index = (int) (Math.random()*52);
    		cards.add(cards.get(index));
    		cards.remove(index);
    	}
    }
    
    //Removes 0th card from deck and adds it the inputed hand
    public void dealCard(Deck hand, int index) {
    	hand.addCard(cards.get(index));
    	cards.remove(index);
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
    
    // swaps the Cards at the two indices given
    public void swap(int index1, int index2) {
    	Card temp = cards.get(index1);
    	cards.set(index1, cards.get(index2));
    	cards.set(index2, temp);
    }
    
    
    //returns array list as opposed to string so indices are easier to see
    public ArrayList toArrayList() {
    	return cards;
    }
    
    public int findCard(int rank) {
    	for(int i = 0; i< cards.size(); i++) {
    		if(cards.get(i).rank==rank) {
    			return i;
    		}
    	}
    	return -1;
    }
    }