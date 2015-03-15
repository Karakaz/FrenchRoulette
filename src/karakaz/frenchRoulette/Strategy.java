package karakaz.frenchRoulette;

public enum Strategy {
	odd(1), even(1), red(1), black(1), number(35), martingale(1), jamesBond(35);
	
	private int bettingNumber;
	private int payout;
	
	private Strategy(int payout){
		this.payout = payout;
	}
	
	public void setBettingNumber(int bettingNumber){
		this.bettingNumber = bettingNumber;
	}
	
	public int getBettingNumber(){
		return bettingNumber;
	}

	public int getPayoutRatio(){
		return payout;
	}
	
	public boolean didIWin(int roll) {
		switch(this){
		case odd: return roll % 2 == 1;
		case even: return roll % 2 == 0 && roll != 0;
		case red: return isRed(roll);
		case black: return !isRed(roll);
		case number: return roll == getBettingNumber();
		case martingale: return roll % 2 == 1;
		case jamesBond: return roll == 17;
		default:
			throw new RuntimeException("Unhandled strategy");
		}
	}

	private boolean isRed(int roll) {
		switch(roll){
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
		case 12:
		case 14:
		case 16:
		case 18:
		case 19:
		case 21:
		case 23:
		case 25:
		case 27:
		case 30:
		case 32:
		case 34:
		case 36:
			return true;
		default:
			return false;
		}
	}
}
