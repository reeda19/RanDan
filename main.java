// TODO
// Begin cpu
// GUI?
// Add comments



import java.util.Scanner;
public class main
{ 	static Scanner input = new Scanner(System.in);
	static int centerCount = 0;
	public static void main(String [] args)
	{
	Deck player1 = new Deck();
	Deck player2 = new Deck();
    Deck deck = createDeck();
    Deck center = new Deck();
    deal(deck, player1, player2);
    deck.dealCard(center, 0);
    System.out.println("The first card dealt is the "+center.getCard(0).toString());
    addCenterCount(center.getCard(0));
    int player1_wins=0;
    int player2_wins=0;
    
    // first to 3 wins
    while (player1_wins<3 && player2_wins<3) {
    	System.out.println("Player 1 turn");
    	playerturn(player1, center, deck);
    	if(centerCount==0){
    		player1_wins++;
    		System.out.println("Player 1 got a point!");
    		System.out.println("It is now "+player1_wins + " to " +player2_wins);
    	}
    	System.out.println("Player 2 turn");
    	playerturn(player2, center, deck);
    	if(centerCount==0){
    		player2_wins++;
    		System.out.println("Player 2 got a point!");
    		System.out.println("It is now "+player1_wins + " to " +player2_wins);
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
	public static void deal(Deck deck, Deck player1, Deck player2) {
		for(int i = 0; i<7; i++) {
			deck.dealCard(player1, 0);
			deck.dealCard(player2, 0);
		}
	}
	
	// playerturn : Deck Deck Deck -> Deck
	// Executes a player's turn, allowing them to choose a card to place in the deck
	
	public static void playerturn(Deck player, Deck center, Deck deck) {
		player.organizeDeck();
		
    	System.out.println("The total count for the center is "+ centerCount);
		
		//Print players cards for viewing
		System.out.println("Your cards are:" );
		System.out.println(player.toArrayList());
		System.out.println("What is your move? Select a card (0-6)");
		int num = input.nextInt();
		player.dealCard(center, num);
		addCenterCount(center.getCard(center.getLength()-1));
		deck.dealCard(player,  0);
		
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
}