import java.util.ArrayList;
import java.util.Scanner;
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
    
    public void swap(int index1, int index2) {
    	Card temp = cards.get(index1);
    	cards.set(index1, cards.get(index2));
    	cards.set(index2, temp);
    }
    
    public int getTotal() {
    	int total = 0;
    	for(int i = 0; i<cards.size(); i++) {
    		Card card = cards.get(i);
    		if(card.rank==14) {
    			Scanner input = new Scanner (System.in);
    			System.out.println("11 or 1?");
    			int num = input.nextInt();
    			if(num==11) {
    				total+=11;
    			}
    			else if (num==1) {
    				total+=1;
    			}
    		}
    		else if(card.rank>10) {
    			total+=10;
    		}
    		else {
    			total+=card.rank;
    		}
    	}
       	while(total>=52) {
    		total-=52;
    	}
    	return total;
    }
    
    //returns array list as opposed to string so indices are easier to see
    public ArrayList toArrayList() {
    	return cards;
    }
    }