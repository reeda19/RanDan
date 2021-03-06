//A card has a rank (1-14) and a suit (hearts, spades, diamonds, clubs)
public class Card
{ 
    int rank;
    String suit;
	public Card(int rank, String suit)
	{
    this.rank = rank;
    this.suit = suit;
    }
	
	// toString : Card -> String
	// Converts Card into a readable String statement
	public String toString() {
		String rankString="";
		if(rank > 10 || rank == 1) {
			switch(rank) {
				case 1:
					rankString = "ace";
					break;
				case 11:
					rankString = "jack";
					break;
				case 12:
					rankString = "queen";
					break;
				case 13:
					rankString = "king";
					break;

			}
		}
		else {
			rankString=Integer.toString(rank);
		}
		return rankString+" of "+suit;
		}
	}
    