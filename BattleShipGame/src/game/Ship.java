package game;
import java.util.ArrayList;
public class Ship {
	ArrayList<int[]> Mycoordinates = new ArrayList<int[]>();
	String Myname;
	public void setupShip(int size, int x, int y,int Turn,String name) {
		Myname = name;
		if (Turn == 1) {
			for (int i = 0; i < size; i ++) {
				int[] coordinates = {x,y+i};
				Mycoordinates.add(coordinates);
			}
		}
		else {
			for (int i = 0; i < size; i ++) {
				int[] coordinates = {x+i,y};
				Mycoordinates.add(coordinates);
			}
		}
	}
	public Boolean hit(int x,int y) {
		int iterate = 0;
		
		for (int[] num : Mycoordinates) {
	        if (num[0] == x && num[1] == y) {
	        	System.out.println("You hit "+Myname+" Ouch!");
	        	Mycoordinates.remove(iterate);
	        	if (Mycoordinates.isEmpty()) {
	    			System.out.println("You sunk "+Myname+" Blub bulp!");
	    		}
	        	return true;
	        }
	        iterate++;
	    }
		return false;
	}
}
