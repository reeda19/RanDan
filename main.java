//TODO
//Add working functionality for aces
//Begin cpu




import java.util.Scanner;
public class main
{ 	static Scanner input = new Scanner(System.in);
	public static void main(String [] args)
	{
	Deck player1 = new Deck();
	Deck player2 = new Deck();
    Deck deck = createDeck();
    Deck center = new Deck();
    deal(deck, player1, player2);
    deck.dealCard(center, 0);
    System.out.println("The first card dealt is the "+center.getCard(0).toString());
    int player1_wins=0;
    int player2_wins=0;
    
    //first to 3 wins
    while (player1_wins<3 && player2_wins<3) {
    	System.out.println("Player 1 turn");
    	playerturn(player1, center, deck);
    	if(center.getTotal()==0){
    		player1_wins++;
    		System.out.println("Player 1 got a point!");
    		System.out.println("It is now "+player1_wins + " to " +player2_wins);
    	}
    	System.out.println("Player 2 turn");
    	playerturn(player2, center, deck);
    	if(center.getTotal()==0){
    		player2_wins++;
    		System.out.println("Player 2 got a point!");
    		System.out.println("It is now "+player1_wins + " to " +player2_wins);
    	}
    }
	input.close();
    }
	
	
	
	//Prints the cards in the deck, in order
	public static void printDeck(Deck deck) {
		for(int i = 0; i<deck.getLength(); i++) {
	    	System.out.println(deck.getCard(i));
	    }
	}
	
	
	
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
	
	public static void deal(Deck deck, Deck player1, Deck player2) {
		for(int i = 0; i<7; i++) {
			deck.dealCard(player1, 0);
			deck.dealCard(player2, 0);
		}
	}
	
	public static void playerturn(Deck player, Deck center, Deck deck) {
		player.organizeDeck();
		
    	System.out.println("The total count for the center is "+center.getTotal());
		
		//Print players cards for viewing
		System.out.println("Your cards are:" );
		System.out.println(player.toArrayList());
		System.out.println("What is your move? Select a card (0-6)");
		int num = input.nextInt();
		player.dealCard(center, num);
		deck.dealCard(player,  0);
		
	}
}