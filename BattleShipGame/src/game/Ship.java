package game;
import java.util.ArrayList;
public class Ship {
	ArrayList<int[]> Mycoordinates = new ArrayList<int[]>();
	String Myname;
	public Ship(int size, int x, int y,int orientation,String name) {
		Myname = name;
		for (int i = 0; i < size; i ++) {
			int[] coordinates = new int[2]; 
			if (orientation == 1) {
				coordinates[0] = x;
				coordinates[1] = y+i;
			} else {
				coordinates[0] = y;
				coordinates[1] = x+i;
			}
			Mycoordinates.add(coordinates);
		}
	}
	public Boolean getHit(int x,int y) {
		for (int i = 0; i < Mycoordinates.size(); i++) {
			int[] Coordinate = Mycoordinates.get(i);
	        if (Coordinate[0] == x && Coordinate[1] == y) {
	        	System.out.println("You hit "+Myname+" Ouch!");
	        	Mycoordinates.remove(i);
	        	if (Mycoordinates.isEmpty()) {
	    			System.out.println("You sunk "+Myname+" Blub bulp!");
	    		}
	        	return true;
	        }
	    }
		return false;
	}
}
