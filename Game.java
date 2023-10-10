package tp2reing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	
	

	public Game() {
		
	}
	public void Roll(int roll) {
		System.out.println(Player.get_players().get(Player.get_currentPlayer()) + " is the current player");
		System.out.println("They have rolled a " + roll);
		Player.Placeplayer(roll);
	}


}