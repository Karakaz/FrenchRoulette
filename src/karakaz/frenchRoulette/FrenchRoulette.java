package karakaz.frenchRoulette;

import java.util.ArrayList;
import java.util.Random;

public class FrenchRoulette {

	private ArrayList<Player> players;
	
	public FrenchRoulette(ArrayList<Player> players) {
		this.players = players;
	}

	public void play(int nrRounds) {
		doAllSpins(nrRounds);
	}
	
	public void printStatistics(){
		players.forEach(Player::printStatistics);
	}

	private void doAllSpins(int nrRounds) {
		new Random().ints(nrRounds, 0, 37).forEach(roll -> players.forEach(player -> player.handleRoll(roll)));
	}
	
}
