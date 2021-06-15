package game;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Player {
	static ArrayList<String> mycoordinates = new ArrayList<String>(); // This holds string 
	//of the coordinates of all the ships. so {4,4} would be "4 4"
	int amountofmyGuesses = 0;
	static Ship cruiser = new Ship();
	static Ship destroyer = new Ship();
	static Ship submarine = new Ship();
	static Ship battleship = new Ship();
	static Ship aircraftcarrier = new Ship();
	static Ship[] myShips = {cruiser,destroyer,submarine,battleship,aircraftcarrier};
	static int boardSize = 10;
	int[][] allguesses = new int[boardSize][boardSize];
	public static void addCoordinates(Ship Ship) {
		for (int[] num : Ship.Mycoordinates) {
			String x = String.valueOf(num[0]);
			String y = String.valueOf(num[1]);
			mycoordinates.add(x+""+y);
		}
	}
	public static Boolean inbounds(int x, int y, int Turn, int size) {
		if (Turn == 1 && x < boardSize && y + size-1 < boardSize ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				String strx = String.valueOf(x);
				String stry = String.valueOf(y+i);
				if (mycoordinates.contains(strx+""+stry)) {
					return false;
				}
			}
			//passed all everything
			return true;
		}
		if (Turn == 0 && y < boardSize && x + size-1 < boardSize ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				String strx = String.valueOf(x);
				String stry = String.valueOf(y+i);
				if (mycoordinates.contains(strx+""+stry)) {
					return false;
				}
			}
			//passed all everything
			return true;
		}
		return false;//failed x or y quick check
	}
	public static int[] getCoords(String Name) {
		System.out.println("Enter for "+Name);
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter an X coordinate for "+Name);
	    int x = myObj.nextInt(); 
	    System.out.println("Enter an Y coordinate for "+Name);
	    int y = myObj.nextInt(); 
	    System.out.println("Enter 1 for Vertical or 0 for Horizontal for the ship");
	    int turn = myObj.nextInt();
	    int[] returnval = {x,y,turn};
	    return returnval;
	}
	public static int[] checkCoords(int size, String name) {
		int[] x; // not in use yet, will mess up my testing.
		while(true){
			x = getCoords(name);
			if (inbounds(x[0],x[1],x[2],size)) {
				break;
			}
			System.out.println("Your inputs dont work");
		}
		return x;
	}
	public void setupMyships() {
		int[] Coords = checkCoords(2,"Cruiser");
		cruiser.setupShip(2,Coords[0],Coords[1],Coords[2],"Cruiser");
		addCoordinates(cruiser);
		Coords = checkCoords(3,"Destroyer");
		destroyer.setupShip(3,Coords[0],Coords[1],Coords[2],"Destroyer");
		addCoordinates(destroyer);
		Coords = checkCoords(3,"Submarine");
		submarine.setupShip(3,Coords[0],Coords[1],Coords[2],"Submarine");
		addCoordinates(submarine);
		Coords = checkCoords(4,"Battleship");
		battleship.setupShip(4,Coords[0],Coords[1],Coords[2],"Battleship");
		addCoordinates(battleship);
		Coords = checkCoords(5,"Aircraftcarrier");
		aircraftcarrier.setupShip(5,Coords[0],Coords[1],Coords[2],"Aircraftcarrier");
		addCoordinates(aircraftcarrier);
	}
  	public int[] guess() {
  		Scanner guess = new Scanner(System.in);
  		int x,y;
  		while (true) {
  			System.out.println("Enter an X coordinate for your guess");
  			x = guess.nextInt();
	    	System.out.println("Enter an Y coordinate for your guess");
	    	y = guess.nextInt();
	    	if (x < boardSize && y < boardSize) {
	    		break;
	    	}
	    	else {
	    		System.out.println("Your guess it out of bounds");
	    	}
	    	if (allguesses[x][y]==0) {
	    		break;
	    	}
	    	else {
	    		System.out.println("You already guesses here");
	    	}
	    	
  		}
  		allguesses[x][y] = 1;
	    int[] return_guess = {x,y};
	    amountofmyGuesses ++;
		return return_guess;
	}
  	public Boolean allShipssunk() {
  		for (Ship ship : myShips) {
  			if (ship.Mycoordinates.isEmpty()==false) {
  				return false;
  			}
  		}
  		return true;
	}
  	public void broadcastHit(int x, int y) {
  		for (Ship ship : myShips) {
  			ship.hit(x,y);
  		}
  	}
  	public void showvals() { // tester, for later
  		for (Ship ship : myShips) {
  			for (int[] num : ship.Mycoordinates) {
  				System.out.println(num[0]+","+num[1]);
  			}	
  		}
  	}
}