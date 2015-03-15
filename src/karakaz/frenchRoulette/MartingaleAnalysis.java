package karakaz.frenchRoulette;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class MartingaleAnalysis {

	private static ArrayList<Player> players;
	
	public static void main(String[] args) {
		initializePlayers();
		doXSpinsYTimes(100000, 100);
	}
	
	private static void doXSpinsYTimes(int nrSpins, int iterations) {
		FrenchRoulette roulette;
		int[] collectedBankrollPeaks = new int[players.size()];
		int[] collectedBankrollPeakIndexes = new int[players.size()];
		for (int i = 0; i < iterations; i++) {
			initializePlayers();
			roulette = new FrenchRoulette(players);
			roulette.play(nrSpins);
			
			for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
				collectedBankrollPeaks[playerIndex] += players.get(playerIndex).getBankrollPeak();
				collectedBankrollPeakIndexes[playerIndex] += players.get(playerIndex).getBankrollPeakIndex();
			}
		}
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			System.out.printf("Initial bankroll: %d\tbet amount: %d\tpeakwinnings: %d,\tapproximately %d spins into the game\n", 
							  p.getInitialBankroll(),
							  p.getDefaultBetAmount(),
							  collectedBankrollPeaks[i] / iterations - p.getInitialBankroll(),
							  collectedBankrollPeakIndexes[i] / iterations);
		}
	}
	
	public static void initializePlayers(){
		players = new ArrayList<Player>(); 
		for (int bankroll = 100; bankroll <= 1000000; bankroll *= 10) {
			for (int betAmount = 1; betAmount <= 100; betAmount *= 10) {
				players.add(new Player(betAmount, bankroll));
			}
		}
	}
	
}
