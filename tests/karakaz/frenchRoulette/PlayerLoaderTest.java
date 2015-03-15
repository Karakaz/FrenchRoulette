package karakaz.frenchRoulette;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerLoaderTest {
	
	@Test
	public void testObjectCreation() throws Exception{
		new PlayerLoader("programInputFiles/players.json");
	}
	
	@Test (expected = FileNotFoundException.class)
	public void testIllegalPlayersPath() throws Exception{
		new PlayerLoader("");
	}
	
	@Test
	public void testLoadAllPlayers() throws Exception{
		PlayerLoader loader = new PlayerLoader("programInputFiles/players.json");
		assertTrue(loader.loadAllPlayers() instanceof ArrayList<?>);
	}
	
}
