package Game;
import java.util.ArrayList;
import java.util.Arrays;
public class Player {
	static ArrayList<int[]> Mycoordinatess = new ArrayList<int[]>();
	int myGuesses = 0;
	public static void addCoords(Ship Ship) {
		for (int[] num : Ship.Mycoordinates) {
			Mycoordinatess.add(num);
		}
	}
	public static Boolean inbounds(int x, int y, int Turn, int size) {
		if (Turn == 1 && x < 10) { // checks vertical then confirms x
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				//also to  make sure y is in bounds
				int[] guess_coords = {x,y+i};
				//sets the current coordinations
				if (y+i>10) {
					//Checks for overlap with pre-exisitng coordinations
					//with the new ones
					for (int[] num : Mycoordinatess) {
						if (Arrays.equals(num,guess_coords)) {
							//overlap
							return false;
						}
					}
					//ending this part of the night mare
				}
				else {
					//y is out of bounds
					return false;
				}
			}
			//passed all everything
			return true;
		}
		if (Turn == 0 && y < 10) { // checks vertical then confirms y
			for (int i = 0; i < size-1; i++) { // loops to check if x y is in coords and 
				//also to  make sure y is in bounds
				int[] guess_coords = {x+i,y};
				//sets the current coordinations
				if (x+i>10) {
					//Checks for overlap with pre-exisitng coordinations
					//with the new ones
					for (int[] num : Mycoordinatess) {
						if (Arrays.equals(num,guess_coords)) {
							//overlap
							return false;
						}
					}
					//ending this part of the night mare
				}
				else {
					//x is out of bounds
					return false;
				}
			}
			//passed all everything
			return true;
		}
		return false;//failed x or y quick check
	}
	public static int[] getCoords(int iterator) {
		int[][] x = {{4,3,1},{3,2,1},{9,8,1},{6,5,0},{7,8,0}};
		return x[iterator];
	}
	public static int[] checkCoords(int iterator, int size) {
		int[] x; // not in use yet, will mess up my testing.
		while(true){
			x = getCoords(iterator);
			if (inbounds(x[0],x[1],x[2],size)) {
				break;
			}
			System.out.println("Your inputs dont work");
		}
		return x;
	}
  	public void setupMyship() {
		Ship Cruiser = new Ship();
		int[] Coords = getCoords(0);
		Cruiser.setupShip(2,Coords[0],Coords[1],Coords[2],"Cruiser");
		addCoords(Cruiser);
		Ship Destroyer = new Ship();
		Coords = getCoords(1);
		Destroyer.setupShip(3,Coords[0],Coords[1],Coords[2],"Destroyer");
		addCoords(Destroyer);
		Ship Submarine = new Ship();
		Coords = getCoords(2);
		Submarine.setupShip(3,Coords[0],Coords[1],Coords[2],"Submarine");
		addCoords(Submarine);
		Ship Battleship = new Ship();
		Coords = getCoords(3);
		Battleship.setupShip(4,Coords[0],Coords[1],Coords[2],"Battleship");
		addCoords(Battleship);
		Ship Aircraftcarrier = new Ship();
		Coords = getCoords(4);
		Aircraftcarrier.setupShip(5,Coords[0],Coords[1],Coords[2],"Aircraftcarrier");
		addCoords(Aircraftcarrier);
	} 
	public int[] guess(int I) {
		int[][] x= {{},{},{},{},{},{},{}};
		myGuesses ++;
		return x[I];
	}
	public void printcoords() {
		for (int[] num : Mycoordinatess) {
			System.out.println(num[0]+","+num[1]);
		}
	}
}