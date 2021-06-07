package game_ship;

public class Ship {
	  int[][] coords = {{0,0},{0,0},{0,0}};
	  int x;
	  int y;
	  int turn;
	  public Boolean Sunk = false;
	  public void setup(int size, int x, int y, int turn){
	    if (turn == 1) {
	      	System.out.println(x);
	      	System.out.println(y);
	      	for(int i = 0; i < 3; i++){
	        	coords[i][0] = x+i;
	            coords[i][1] = y;
	    	}
	    }
	    else{
	      	for(int i = 0; i < 3; i++){
	        	coords[i][0] = x;
	            coords[i][1] = y+i;
	    	}
	    }
	  
	  }
	  public void hit(int x, int y){
	    	for(int i = 0; i < 3; i++){
	          	if (coords[i][0]==x && coords[i][1] == y){
	           		System.out.println("Hit!");
	              	coords[i][0] = -1;
	            }  	
	    	}
	    	if (coords[0][0]==-1&&coords[0][1]==-1&&coords[0][2]==-1){
	          	System.out.println("Sunk Blup Blub");
	          	Sunk = true;
	        }
	  }
}