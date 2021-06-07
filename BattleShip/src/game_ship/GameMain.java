package game_ship;
import java.util.Scanner;

public class GameMain {
  public boolean Inbounds(int size, int x, int y, int turn, int shipsize){
    //Checks if the ship is inbounds
    if (turn == 1 && x+shipsize-1 < size && y < size || turn == 2 && x < size && y+shipsize-1 < size){
       for (int i = 0; i < 9; i ++){
         int [] test = {x,y};
         //Checks if the ship is in the coordinates.
         if (test == allcoords1[i]){
           return false;
         }
       }
       return true;
       }
    return false;
  
  }

  public void Creategame(int size){	
    System.out.println("Player 1 your turn");
    //player 1
  	Ship Submarine1 = new Ship();
  	int[] Inputs = getCoordinates("Submarine");
  	System.out.println("Here");
    Submarine1.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    //Finally sets the coordinates for the ship, then appends them to allcoords.
    allcoords1[0] = Submarine1.coords[0];
    allcoords1[1] = Submarine1.coords[1];
    allcoords1[2] = Submarine1.coords[2];
    Ship BattleShip1 = new Ship();
    Inputs = getCoordinates("BattleShip");
    BattleShip1.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    allcoords1[3] = BattleShip1.coords[0];
    allcoords1[4] = BattleShip1.coords[1];
    allcoords1[5] = BattleShip1.coords[2];
    Ship Dingy1 = new Ship();
    Inputs = getCoordinates("Dingy");
    Dingy1.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    allcoords1[6] = Dingy1.coords[0];
    allcoords1[7] = Dingy1.coords[1];
    allcoords1[8] = Dingy1.coords[2];
    
    System.out.println("Player 2 your turn");
  	Ship Submarine2 = new Ship();
  	Inputs = getCoordinates("Submarine");
    Submarine2.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    //Finally sets the coordinates for the ship, then appends them to allcoords.
    allcoords1[0] = Submarine2.coords[0];
    allcoords1[1] = Submarine2.coords[1];
    allcoords1[2] = Submarine2.coords[2];
    Ship BattleShip2 = new Ship();
    Inputs = getCoordinates("BattleShip");
    BattleShip2.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    allcoords1[3] = BattleShip2.coords[0];
    allcoords1[4] = BattleShip2.coords[1];
    allcoords1[5] = BattleShip2.coords[2];
    Ship Dingy2 = new Ship();
    Inputs = getCoordinates("Dingy");
    Dingy2.setup(size,Inputs[0],Inputs[1],Inputs[2]);
    allcoords1[6] = Dingy2.coords[0];
    allcoords1[7] = Dingy2.coords[1];
    allcoords1[8] = Dingy2.coords[2];
    
    System.out.println("Input x and ys to hit enemies");
    System.out.println("Sink all ships");
    for(int i=0; i > 9; i++){
      System.out.println(allcoords1[i][0]);
      System.out.println(allcoords1[i][1]);
      System.out.println(allcoords2[i][0]);
      System.out.println(allcoords2[i][1]);
    }
    String player = "Player1";
    int player1guess = 0;
    int player2guess = 0;
    int guessx;
    int guessy;
    while (true){
      System.out.println("Hey "+player+ " your turn idiot, input x and y");
      System.out.println("Input x");
	  guessx = myObj.nextInt();
      System.out.println("Input y");
	  guessy = myObj.nextInt();
      if (player=="player1"){
        Dingy2.hit(guessx,guessy);
        Submarine2.hit(guessx,guessy);
        BattleShip2.hit(guessx,guessy);
        for(int i=0; i > 9; i++){
          int[] test = {guessx,guessy};
          if (allcoords2[i] == test){
            allcoords2[i][0] = -1;
            allcoords2[i][1] = -1;
        	}
          else {
        	player1guess +=1;
          }
        }
        for(int i=0; i > 9; i++){
          int[] test = {-1,-1};
          if (allcoords2[i] != test){
            break;
          }
          if (i == 8){
            System.out.println("Player1 won");
            return;
          }
        }
      }
      
      if (player=="player2"){
        Dingy1.hit(guessx,guessy);
        Submarine1.hit(guessx,guessy);
        BattleShip1.hit(guessx,guessy);
        for(int i=0; i > 9; i++){
          int[] test = {guessx,guessy};
          if (allcoords1[i] == test){
            allcoords1[i][0] = -1;
            allcoords1[i][1] = -1;
        	}
          else {
          	player1guess +=1;
            }
        }
        for(int i=0; i > 9; i++){
          int[] test = {-1,-1};
          if (allcoords1[i] != test){
            break;
          }
          if (i == 8){
            System.out.println("Player2 won");
            return;
          }
        }
      if (player == "player1"){
        player = "player2";
      }
      else;
        player = "player1";
      } 
    }
  }
}
