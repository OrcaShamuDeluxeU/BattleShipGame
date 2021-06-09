package Game;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Player {
	static ArrayList<String> Mycoordinatess = new ArrayList<String>();
	int[][] allguesses = {{0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0},
						  {0,0,0,0,0,0,0,0,0,0}};
	int myGuesses = 0;
	Ship Cruiser = new Ship();
	Ship Destroyer = new Ship();
	Ship Submarine = new Ship();
	Ship Battleship = new Ship();
	Ship Aircraftcarrier = new Ship();
	public static void addCoords(Ship Ship) {
		for (int[] num : Ship.Mycoordinates) {
			String x = String.valueOf(num[0]);
			String y = String.valueOf(num[1]);
			Mycoordinatess.add(x+""+y);
		}
	}
	public static Boolean inbounds(int x, int y, int Turn, int size) {
		if (Turn == 1 && x < 10 && y + size-1 < 10 ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				String strx = String.valueOf(x);
				String stry = String.valueOf(y+i);
				if (Mycoordinatess.contains(strx+""+stry)) {
					return false;
				}
			}
			//passed all everything
			return true;
		}
		if (Turn == 0 && y < 10 && x + size-1 < 10 ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				String strx = String.valueOf(x);
				String stry = String.valueOf(y+i);
				if (Mycoordinatess.contains(strx+""+stry)) {
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
	    //int turn = 0;
	    //if (turnstr == "Vertical") {
	    	//turn = 1;
	    //}
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
		Cruiser.setupShip(2,Coords[0],Coords[1],Coords[2],"Cruiser");
		addCoords(Cruiser);
		Coords = checkCoords(3,"Destroyer");
		Destroyer.setupShip(3,Coords[0],Coords[1],Coords[2],"Destroyer");
		addCoords(Destroyer);
		Coords = checkCoords(3,"Submarine");
		Submarine.setupShip(3,Coords[0],Coords[1],Coords[2],"Submarine");
		addCoords(Submarine);
		Coords = checkCoords(4,"Battleship");
		Battleship.setupShip(4,Coords[0],Coords[1],Coords[2],"Battleship");
		addCoords(Battleship);
		Coords = checkCoords(5,"Aircraftcarrier");
		Aircraftcarrier.setupShip(5,Coords[0],Coords[1],Coords[2],"Aircraftcarrier");
		addCoords(Aircraftcarrier);
	}
  	public int[] guess() {
  		Scanner guess = new Scanner(System.in);
  		int x,y;
  		while (true) {
  			System.out.println("Enter an X coordinate for your guess");
  			x = guess.nextInt();
	    	System.out.println("Enter an Y coordinate for your guess");
	    	y = guess.nextInt();
	    	if (x < 10 && y < 10) {
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
		myGuesses ++;
		return return_guess;
	}
  	public Boolean allShipssunk() {
		if (Cruiser.Mycoordinates.isEmpty()&&Destroyer.Mycoordinates.isEmpty()&&Submarine.Mycoordinates.isEmpty()&&Battleship.Mycoordinates.isEmpty()&&Aircraftcarrier.Mycoordinates.isEmpty()) {
			return true;
		}
  		return false;
	}
  	public void broadcastHit(int x, int y) {
  		Cruiser.hit(x,y);
  		Destroyer.hit(x,y);
  		Submarine.hit(x,y);
  		Battleship.hit(x,y);
  		Aircraftcarrier.hit(x,y);
  	}
  	public void showvals() {
  		System.out.println("Cruiser Coords");
  		for (int[] num : Cruiser.Mycoordinates) {
  			System.out.println(num[0]+","+num[1]);
  		}
  		System.out.println("Destroyer Coords");
  		for (int[] num : Destroyer.Mycoordinates) {
  			System.out.println(num[0]+","+num[1]);
  		}
  		System.out.println("Submarine Coords");
  		for (int[] num : Submarine.Mycoordinates) {
  			System.out.println(num[0]+","+num[1]);
  		}
  		System.out.println("Battleship Coords");
  		for (int[] num : Battleship.Mycoordinates) {
  			System.out.println(num[0]+","+num[1]);
  		}
  		System.out.println("Aircraftcarrier Coords");
  		for (int[] num : Aircraftcarrier.Mycoordinates) {
  			System.out.println(num[0]+","+num[1]);
  		}
  	}
}