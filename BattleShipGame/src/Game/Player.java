package Game;
import java.util.*;
import java.util.Scanner;
public class Player {
	static Hashtable<int[], Boolean> Mycoordinatess = new Hashtable<int[], Boolean>();
	int myGuesses = 0;
	Ship Cruiser = new Ship();
	Ship Destroyer = new Ship();
	Ship Submarine = new Ship();
	Ship Battleship = new Ship();
	Ship Aircraftcarrier = new Ship();
	public static void addCoords(Ship Ship) {
		for (int[] num : Ship.Mycoordinates) {
			Mycoordinatess.put(num,true);
		}
	}
	public static Boolean inbounds(int x, int y, int Turn, int size) {
		if (Turn == 1 && x < 10 && y + size-1 < 10 ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				//also to  make sure y is in bounds
				int[] guess_coords = {x,y+i};
				if (Mycoordinatess.get(guess_coords)!=null) {
					return false;
				}
			}
			//passed all everything
			return true;
		}
		if (Turn == 0 && y < 10 && x + size-1 < 10 ) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				//also to  make sure y is in bounds
				int[] guess_coords = {x+i,y};
				if (Mycoordinatess.get(guess_coords)!=null) {
					return false;
				}
			}
			//passed all everything
			return true;
		}
		return false;//failed x or y quick check
	}
	public static int[] getCoords() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter an X coordinate");
	    int x = myObj.nextInt(); 
	    System.out.println("Enter an Y coordinate");
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
	public static int[] checkCoords(int size) {
		int[] x; // not in use yet, will mess up my testing.
		while(true){
			x = getCoords();
			if (inbounds(x[0],x[1],x[2],size)) {
				break;
			}
			System.out.println("Your inputs dont work");
		}
		return x;
	}
	public void setupMyships() {
		int[] Coords = checkCoords(2);
		Cruiser.setupShip(2,Coords[0],Coords[1],Coords[2],"Cruiser");
		addCoords(Cruiser);
		Coords = checkCoords(3);
		Destroyer.setupShip(3,Coords[0],Coords[1],Coords[2],"Destroyer");
		addCoords(Destroyer);
		Coords = checkCoords(3);
		Submarine.setupShip(3,Coords[0],Coords[1],Coords[2],"Submarine");
		addCoords(Submarine);
		Coords = checkCoords(4);
		Battleship.setupShip(4,Coords[0],Coords[1],Coords[2],"Battleship");
		addCoords(Battleship);
		Coords = checkCoords(5);
		Aircraftcarrier.setupShip(5,Coords[0],Coords[1],Coords[2],"Aircraftcarrier");
		addCoords(Aircraftcarrier);
	}
  	public int[] guess(int I) {
		//not in use
		int[][] x= {{},{},{},{},{},{},{}};
		myGuesses ++;
		return x[I];
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