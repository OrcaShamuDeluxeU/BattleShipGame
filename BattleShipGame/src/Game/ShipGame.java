package Game;

public class ShipGame {
	public void run() {
		Player Player1 = new Player();
		Player Player2 = new Player();
		System.out.println("Setup your ships, Player 1");
		Player1.setupMyships();
		System.out.println("Setup your ships, Player 2");
		Player2.setupMyships();
		String Current_player = "Player1";
		while (true) {
			if (Current_player == "Player1"){
				int[] myguess = Player1.guess();
				Player2.broadcastHit(myguess[0], myguess[1]);
				if (Player2.allShipssunk()) {
					System.out.println("You won Player 1!");
					System.out.println("It took you "+Player1.myGuesses+ " guesses. Congrats!");
					break;
				}
				Current_player = "Player2";
			}
			else {
				Current_player = "Player1";
				int[] myguess = Player2.guess();
				Player1.broadcastHit(myguess[0], myguess[1]);
				if (Player1.allShipssunk()) {
					System.out.println("You won Player 2!");
					System.out.println("It took you "+Player2.myGuesses+ " guesses. Congrats!");
					break;
				}
			}
		}
	}
}
