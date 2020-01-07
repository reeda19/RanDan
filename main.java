// TODO
// Better AI 
// make more robust
// GUI?
// Add comments



import java.util.Scanner;
import java.lang.Math.*; 
public class main
{ 	static Scanner input = new Scanner(System.in);
	static int centerCount = 0;
	static Deck player1 = new Deck();
	static Deck cpu = new Deck();
    static Deck deck = createDeck();
    static Deck center = new Deck();
	public static void main(String [] args)
	{
    deal();
    deck.dealCard(center, 0);
    System.out.println("The first card dealt is the "+center.getCard(0).toString());
    addCenterCount(center.getCard(0));
    int player1_wins=0;
    int cpu_wins=0;
    
    // first to 3 wins
    while (player1_wins<3 && cpu_wins<3) {
    	System.out.println("Player 1 turn");
    	playerturn();
    	if(centerCount==0){
    		player1_wins++;
    		System.out.println("Player 1 got a point!");
    		System.out.println("It is now " +player1_wins + " to " +cpu_wins);
    	}
    	System.out.println("CPU turn");
    	CPUTurn();
    	if(centerCount==0){
    		cpu_wins++;
    		System.out.println("CPU got a point!");
    		System.out.println("It is now "+player1_wins + " to " +cpu_wins);
    	}
    }
	input.close();
    }
	
	
	// printDeck : Deck -> Console Output
	// Prints the cards in the deck, in order
	public static void printDeck(Deck deck) {
		for(int i = 0; i<deck.getLength(); i++) {
	    	System.out.println(deck.getCard(i));
	    }
	}
	
	
	// createDeck : Deck -> Deck
	//Creates and shuffles a standard 52 card deck
	public static Deck createDeck() {
		Deck deck = new Deck();
	    String [] suits = {"hearts", "clubs", "diamonds", "spades"};
	    for(int i = 2; i<=14; i++){
	        for(int j = 0; j<suits.length; j++){
	            Card temp = new Card(i, suits[j]);
	            deck.addCard(temp);
	        }
	    }
	    deck.shuffle();
	    return deck;
	}
	
	// deal : Deck Deck Deck -> Deck Deck
	// deals 7 cards from the deck to 2 players
	public static void deal() {
		for(int i = 0; i<7; i++) {
			deck.dealCard(player1, 0);
			deck.dealCard(cpu, 0);
		}
	}
	
	// playerturn : Deck Deck Deck -> Deck
	// Executes a player's turn, allowing them to choose a card to place in the deck
	
	public static void playerturn() {
		player1.organizeDeck();
		
    	System.out.println("The total count for the center is "+ centerCount);
		
		//Print players cards for viewing
		System.out.println("Your cards are:" );
		System.out.println(player1.toArrayList());
		System.out.println("What is your move? Select a card (0-6)");
		int num = input.nextInt();
		player1.dealCard(center, num);
		addCenterCount(center.getCard(center.getLength()-1));
		deck.dealCard(player1,  0);
		
	}
	
	// addCenterCount : Card -> int
	// Adds card value to the total count in the center
	public static void addCenterCount(Card card) {
		if(card.rank==14) {
			System.out.println("11 or 1?");
			int num = input.nextInt();
			if(num==11) {
				centerCount+=11;
			}
			else if (num==1) {
				centerCount+=1;
			}
			}
		else if(card.rank>10) {
			centerCount+=10;
		}
		else {
			centerCount+=card.rank;
		}
		while(centerCount>=52) {
    		centerCount-=52;
    	}
	}
	
	public static void CPUTurn() {
		int amountUntilWin = 52-centerCount;
		int amountUntil40 = 40-centerCount;
		int tensDigit = (int)Math.floor(centerCount/10);
		
		
		switch(tensDigit) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			break;
		
		
		}
		
		/*
		//if there is less than 11 points till 52
		if(amountUntilWin <= 11) {
			
			//If there is a card that can win the game, play that card
			if(cpu.findCard(amountUntilWin)!=-1) {
			CPUGo(cpu.findCard(amountUntilWin));
			}
			else {
				CPUGo(cpu.getLength()-1);
				}
		}
		
		//If there is a card that puts opposing player at 40, play that card
		else if(amountUntil40 <= 11 && cpu.findCard(amountUntil40)!=-1) {
			CPUGo(cpu.findCard(amountUntil40));
			//If this fails, go to highest ranking card (default)
		}
		
		
		
		//Play highest ranking card if all else fails
		else {
			CPUGo(cpu.getLength()-1);
			}

		*/
	}
	
	public static void CPUGo (int index) {
		cpu.dealCard(center, index);
		addCenterCount(center.getCard(center.getLength()-1));
		deck.dealCard(cpu, 0);
	}
}