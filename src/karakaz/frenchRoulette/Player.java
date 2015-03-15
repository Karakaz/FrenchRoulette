package karakaz.frenchRoulette;

import org.json.JSONObject;

public class Player {
	
	private String firstName;
	private String lastName;
	private Strategy strategy;
	private int bankroll;
	
	private int bankrollAtBeginning;
	private int betAmount;
	private int defaultBetAmount;
	private int bankrollPeak;
	private int bankrollPeakIndex;
	private int rollIndex;
	
	public Player(JSONObject player) {
		firstName = player.getString("firstName");
		lastName = player.getString("lastName");
		strategy = parseStrategy(player);
		bankroll = player.getInt("bankroll");
		bankrollPeak = bankrollAtBeginning = bankroll;
		betAmount = defaultBetAmount = 5;
	}
	
	public Player(int betAmount, int bankroll){
		this.betAmount = defaultBetAmount = betAmount;
		strategy = Strategy.martingale;
		this.bankroll = bankroll;
		bankrollPeak = bankrollAtBeginning = bankroll;
	}
	
	private Strategy parseStrategy(JSONObject player) {
		String str = player.getString("strategy");
		Strategy strategy = Strategy.valueOf(str);
		if(str.equals("number")){
			strategy.setBettingNumber(player.getInt("bettingNumber"));
		}
		return strategy;
	}

	public void handleRoll(int roll){
		rollIndex++;
		if(bankroll <= 0){
			return;
		} else if(betAmount > bankroll){
			betAmount = bankroll;
		}
		
		if(strategy.didIWin(roll)){
			bankroll += betAmount * strategy.getPayoutRatio();
		} else{
			bankroll -= betAmount;
		}
		
		if(strategy == Strategy.martingale){
			if(strategy.didIWin(roll)){
				betAmount = defaultBetAmount;
			} else{
				betAmount *= 2;
			}
		}
		if(bankrollPeak < bankroll){
			bankrollPeak = bankroll;
			bankrollPeakIndex = rollIndex;
		}
	}
	
	public int getBankrollPeak(){
		return bankrollPeak;
	}
	
	public int getBankrollPeakIndex(){
		return bankrollPeakIndex;
	}
	
	public int getInitialBankroll() {
		return bankrollAtBeginning;
	}
	
	public int getDefaultBetAmount(){
		return defaultBetAmount;
	}
	
	public void printStatistics(){
		System.out.printf("Player:\t\t%s %s\n", firstName, lastName);
		System.out.printf("Strategy:\t%s\n", strategy);
		System.out.printf("Bankroll:\tstarted with: %d\tcurrent: %d\tpeak: %d\n\n", bankrollAtBeginning, bankroll, bankrollPeak);
	}
	
}
