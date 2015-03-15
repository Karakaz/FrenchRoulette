package karakaz.frenchRoulette;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class FrenchRoulette {

	ArrayList<Player> players;
	
	public FrenchRoulette(ArrayList<Player> players) {
		this.players = players;
	}

	public void play(int nrRounds) {
		doAllSpins(nrRounds);
		players.forEach(Player::printStatistics);
	}

	private void doAllSpins(int nrRounds) {
		new Random().ints(nrRounds, 0, 37).forEach(roll -> {players.forEach(player -> player.handleRoll(roll)); System.out.println(roll);});
	}
	
}
