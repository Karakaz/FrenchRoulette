package karakaz.frenchRoulette;

public enum Strategy {
	odd, even, red, black, number, martingale, jamesBond;
	
	int bettingNumber;
	
	public void setBettingNumber(int bettingNumber){
		this.bettingNumber = bettingNumber;
	}
	
	public int getBettingNumber(){
		return bettingNumber;
	}
}
