package game_ship;

public class Player {
	  public int[] getCoordinates(String Shipname){
		  int x, y, turn;
		  while (true){
		      System.out.println("Input in an int for " + Shipname +"(use the keys on the top of your comupter doofus) with in the barriers: x");
			  x = myObj.nextInt();
		      System.out.println("Input in an int for " + Shipname +"(use the keys on the top of your comupter doofus) with in the barriers: y");
		      y = myObj.nextInt();
		      System.out.println("Input 1 for sideways and 2 for Vertical for your "+Shipname);
		      turn = myObj.nextInt();
		      if (Inbounds(8,x,y,turn,3)){
		        break;
		      }
		    }
//		  myObj.close();
		  int[] vals = {x,y,turn};
		  return vals;
	  }
}
