import java.util.Scanner;
public class main
{ 	static Scanner input = new Scanner(System.in);
	public static void main(String [] args)
	{
	Deck player1 = new Deck();
	Deck player2 = new Deck();
    Deck deck = createDeck();
    Deck center = new Deck();
    printDeck(deck);
    deal(deck, player1, player2);
    player1.organizeDeck();
    System.out.println("player one");
    printDeck(player1);
    player2.organizeDeck();
    System.out.println("player two");
    printDeck(player2);
    deck.dealCard(center, 0);
    System.out.println("The first card dealt is the "+center.getCard(0).toString());
    System.out.println("The total count for the center is "+center.getTotal());
    int player1_wins=0;
    int player2_wins=0;
    
    //first to 3 wins
    while (player1_wins<3 && player2_wins<3) {
    	System.out.println("Player 1 turn");
    	playerturn(player1, center, deck);
    	System.out.println("The total count for the center is "+center.getTotal());
    	System.out.println("Player 2 turn");
    	playerturn(player2, center, deck);
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

		
		//Print players cards for viewing
		System.out.println("Your cards are:" );
		printDeck(player);
		System.out.println("What is your move? Select a card (0-6)");
		int num = input.nextInt();
		player.dealCard(center, num);
		deck.dealCard(player,  0);
	
	}
}