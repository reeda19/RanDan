import java.util.Scanner;
public class main
{ 
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
    deck.dealCard(center);
    System.out.println("The first card dealt is the "+center.getCard(0).toString());
    System.out.println("The total count for the center is "+center.getTotal());
    int player1_wins=0;
    int player2_wins=0;
    
    //first to 3 wins
    while (player1_wins<3 && player2_wins<3) {
    	playerturn(player1, center);
    	System.out.println("The total count for the center is "+center.getTotal());
    }
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
			deck.dealCard(player1);
			deck.dealCard(player2);
		}
	}
	
	public static void playerturn(Deck player, Deck center) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your move? Select a card (0-7)");
		int num = input.nextInt();
		player.dealCard(center);
	}
}