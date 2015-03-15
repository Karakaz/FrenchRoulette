package karakaz.frenchRoulette;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class FrenchRouletteTest {

	FrenchRoulette roulette;
	
	@Before
	public void setUp() throws Exception{
		roulette = new FrenchRoulette(new PlayerLoader("programInputFiles/players.json").loadAllPlayers());
	}

	@Test
	public void testRollBounds(){
		final int ROLL_AMOUNT = 10000;
		new Random().ints(ROLL_AMOUNT, 0, 37).forEach(n -> {
			if(n < 0 || n > 36){
				fail("Roll was out of legal boulds(0-36) : " + n);
			}
		});
	}
	
	@Test
	public void testPlayOneRound() {
		roulette.play(1);
		roulette.printStatistics();
	}
	
	@Test
	public void testPlay1000Rounds() {
		roulette.play(1000);
		roulette.printStatistics();
	}

}
