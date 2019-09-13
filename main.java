public class main
{ 
	public static void main(String [] args)
	{
    Deck deck = createDeck();
    printDeck(deck);
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
}