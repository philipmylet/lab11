import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Scanner;


public class Blackjack 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double gamesPlayed = 0;
		double playerWins = 0;
		int dealerWins = 0;
		int ties = 0;
		int noMenu = 0;
		int justMenu = 0;
		//Hi
		DecimalFormat df = new DecimalFormat("0.0");
	
		int gameNumber = 1;
		int gameOver = 0;
		int myHand = 0;
		
		P1Random rng = new P1Random();
		
		int myValue1;
		
		System.out.println("START GAME " + "#" + gameNumber);
		System.out.println("");
		
		boolean keepExecution = true;
		boolean test = true;
		boolean stillPlaying = true;
		
		while(keepExecution)
		{
			if(justMenu != 1)
			{
				int myNumber = rng.nextInt(13) + 1;
				
				switch (myNumber)
				{
				case 1:
					myHand = myHand + 1;
					String myNumberIsAnAce = "ACE!";
					System.out.println("Your card is a " + myNumberIsAnAce);
					System.out.println("Your hand is: " + (myHand));
					break;
				case 11:
					myHand = myHand + 10;
					String myNumberIsAJack = "JACK!";
					System.out.println("Your card is a " + myNumberIsAJack);
					System.out.println("Your hand is: " + (myHand));
					break;
				case 12:
					myHand = myHand + 10;
					String myNumberIsAQueen = "QUEEN!";
					System.out.println("Your card is a " + myNumberIsAQueen);
					System.out.println("Your hand is: " + (myHand));
					break;
				case 13:
					myHand = myHand + 10;
					String myNumberIsAKing = "KING!";
					System.out.println("Your card is a " + myNumberIsAKing);
					System.out.println("Your hand is: " + (myHand));
					break;
				default:
					myHand = myHand + myNumber;
					System.out.println("Your card is a " + myNumber + "!");
					System.out.println("Your hand is: " + (myHand));
				}
				
				if (myHand == 21)
				{
					System.out.println("");
					System.out.println("BLACKJACK! You win!");
					System.out.println("");
					playerWins++;
					gameOver = 1;
					noMenu = 1;
					stillPlaying = false;
				}
				
				else if (myHand > 21)
				{
					System.out.println("");
					System.out.println("You exceeded 21! You lose.");
					System.out.println("");
					dealerWins++;
					gameOver = 1;
					noMenu = 1;
					stillPlaying = false;
				}
		
			}
			
			if(noMenu != 1)
			{
				System.out.println("1. Get another card");
				System.out.println("2. Hold hand");
				System.out.println("3. Print statistics");
				System.out.println("4. Exit");
				System.out.println("");
				justMenu = 0;
			}
			
			while(stillPlaying)
			{
				System.out.println("Choose an option: ");
				int userChoice = input.nextInt();
				
				if (userChoice == 1)
				{
					
				}
				
				else if (userChoice == 2)
				{
					myValue1 = rng.nextInt(11) + 16;
					
					System.out.println("Dealer's hand: " + myValue1);
					System.out.println("Your hand is: " + myHand);
					
					if ((myHand > myValue1) && (myValue1 <= 21) || (myValue1 > 21))
					{
						System.out.println("");
						System.out.println("You win!");
						System.out.println("");
						playerWins++;
						gameOver = 1;
						noMenu = 1;
						stillPlaying = false;
					}
					
					else if(myHand == myValue1)
					{
						System.out.println("");
						System.out.println("It's a tie! No one wins!");
						System.out.println("");
						ties++;
						gameOver = 1;
						noMenu = 1;
						stillPlaying = false;
					}
					
					else 
					{
						System.out.println("");
						System.out.println("Dealer wins!");
						System.out.println("");
						dealerWins++;
						gameOver = 1;
						noMenu = 1;
						stillPlaying = false;
					}
				}
				
				else if (userChoice == 3)
				{	
					double playerPercentage = playerWins/gamesPlayed;
					playerPercentage = playerWins / gamesPlayed;
					int playerWins1 = (int) playerWins;
					int gamesPlayed1 = (int) gamesPlayed;
					System.out.println("Number of Player wins: " + playerWins1);
					System.out.println("Number of Dealer wins: " + dealerWins);
					System.out.println("Number of tie games: " + ties);
					System.out.println("Total # of games played is: " + gamesPlayed1);
					System.out.println("Percentage of Player wins: " + df.format((playerPercentage*100)) + "%");
					justMenu = 1;
				}
				
				else if (userChoice == 4)
				{
					keepExecution = false;
					gameOver = 2;
				}
				
				else
				{
					System.out.println("Invalid input!\n" + 
							"Please enter an integer value between 1 and 4.");
					justMenu = 1;
					noMenu = 0;
				}
				break;
			}
			
			
			
			switch (gameOver)
			{
			case 1:
				System.out.println("START GAME " + "#" + (gameNumber = gameNumber + 1));
				System.out.println("");
				myHand = 0;
				gameOver = 0;
				gamesPlayed++;
				test = true;
				stillPlaying = true;
				noMenu = 0;
				
				break;
			case 2:
				break;
			}
			
		}
		
		
	}	
}
