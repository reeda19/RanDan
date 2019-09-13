public class main
{ 
	public static void main(String [] args)
	{
    Deck deck = new Deck()
    String [] suits = {"hearts", "clubs", "diamonds", "spades"};
    for(int i = 2; i<=14; i++){
        for(int j = 0; j<suits.length; j++){
            Card temp = new Card(i, suits[j]);
            deck.addCard(temp);
        }
    }
    }
}