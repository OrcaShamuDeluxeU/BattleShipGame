package Game;
import java.util.*;
import java.util.Hashtable;
public class Testing {
	public static void main(String[] args) {
		//Player p1 = new Player();
		//p1.setupMyships();
		//p1.showvals();
		int[] x = {4,4};
		int[] y = {4,4};
		Hashtable<int[], Boolean> Mycoordinatess = new Hashtable<int[], Boolean>();
		Mycoordinatess.put(y, true);
		if (Mycoordinatess.get(x)==null) {
			System.out.println("You sunkBlub bulp!");
		}
	}
}
