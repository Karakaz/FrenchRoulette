package karakaz.frenchRoulette;

import org.json.JSONObject;

public class Player {
	
	private String firstName;
	private String lastName;
	private Strategy strategy;
	private int bankroll;
	
	public Player(JSONObject player) {
		firstName = player.getString("firstName");
		lastName = player.getString("lastName");
		strategy = parseStrategy(player);
		bankroll = player.getInt("bankroll");
	}
	
	private Strategy parseStrategy(JSONObject player) {
		String str = player.getString("strategy");
		Strategy strategy = Strategy.valueOf(str);
		if(str.equals("number")){
			strategy.setBettingNumber(player.getInt("bettingNumber"));
		}
		return strategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public int getBankroll() {
		return bankroll;
	}
}
