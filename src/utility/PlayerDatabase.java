package utility;

import java.util.ArrayList;
import java.util.StringTokenizer;

import soccer.Player;

public class PlayerDatabase {

	private String authorList = "George Eliot,Graham Greene,Geoffrey Chaucer,Robert Service,Robbie Burns,Rafael Sabatini,Michael Owen,Steven Gerrard,Steve McManaman,Lionel Messi,Cristiano Ronaldo,Wesley Sneijder";

	private ArrayList<Player> players;

	public PlayerDatabase() {
		StringTokenizer authorTokens = new StringTokenizer(authorList, ",");
		players = new ArrayList<>();
		while (authorTokens.hasMoreTokens()) {
			players.add(new Player(authorTokens.nextToken()));
		}
	}

	public Player[] getTeam(int numberOfPlayers) throws PlayerDatabaseException {
		Player[] teamPlayers = new Player[numberOfPlayers];
		for (int i = 0; i < teamPlayers.length; i++) {
			int playerIndex = (int) (Math.random() * players.size());
			try {
				teamPlayers[i] = players.get(playerIndex);
				players.remove(playerIndex);
			} catch (IndexOutOfBoundsException ie) {
				throw new PlayerDatabaseException("Not enough players in the database for the teams requested.");
			}
		}
		return teamPlayers;
	}

}