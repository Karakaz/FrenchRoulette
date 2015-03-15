package karakaz.frenchRoulette;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayerLoader {
	
	private JSONObject players;
	
	public PlayerLoader(String playersPath) throws JSONException, IOException{
		players = new JSONObject(readFileToString(playersPath));
	}

	private String readFileToString(String path) throws IOException {
		return new Scanner(new File(path)).useDelimiter("\\A").next();
	}

	public List<Player> loadAllPlayers() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		JSONArray arr = players.getJSONArray("players");
		for (int i = 0; i < arr.length(); i++) {
			playerList.add(new Player(arr.getJSONObject(i)));
		}
		
		return playerList;
	}
	
}
