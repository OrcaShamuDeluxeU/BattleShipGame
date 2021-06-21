package game;

public class ShipGame {
	static Player player1 = new Player();
	static Player player2 = new Player();
	int[] Coords;
	public static void setup() {
		System.out.println("Setup your ships, Player 1");
		player1.setupMyships();
		System.out.println("Setup your ships, Player 2");
		player2.setupMyships();
	}

	
	public void run() {
		String Current_player = "Player1";
		while (true) {
			if (Current_player == "Player1"){
				int[] myguess = player1.guess();
				player2.broadcastHit(myguess[0], myguess[1]);
				if (player2.allShipssunk()) {
					System.out.println("You won Player 1!");
					System.out.println("It took you "+player1.amountofmyGuesses+ " guesses. Congrats!");
					break;
				}
				Current_player = "Player2";
			}
			else {
				Current_player = "Player1";
				int[] myguess = player2.guess();
				player1.broadcastHit(myguess[0], myguess[1]);
				if (player1.allShipssunk()) {
					System.out.println("You won Player 2!");
					System.out.println("It took you "+player2.amountofmyGuesses+ " guesses. Congrats!");
					break;
				}
			}
		}
	}
}
