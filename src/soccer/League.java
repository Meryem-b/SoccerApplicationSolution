package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

public class League {
	public static void main(String[] args) {
		League theLeague = new League();
		try {
		Team[] theTeams = theLeague.createTeams("The Robins,The Crows,TheS wallows,The Owls", 11);
		Game[] theGames = theLeague.createGames(theTeams);

		System.out.println(theLeague.getLeagueAnnouncement(theGames));
		for (Game currGame : theGames) {
			currGame.playGame();
			System.out.println(currGame.getDescription());
		}
		theLeague.showBestTeam(theTeams);
		theLeague.showBestPlayers(theTeams);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
//		Player player1 = new Player();
//		player1.playerName = "George Eliot";
//
//		Player player2 = new Player();
//		player2.playerName = "Graham Greene";
//
//		Player player3 = new Player();
//		player3.playerName = "Geoffrey Chaucer";
//
//		Player[] thePlayers = { player1, player2, player3 };
//		Team team1 = new Team();
//		team1.teamName = "The Greens";
//		team1.playerArray = thePlayers;

		// player1.playerName = "Robert Service";
		/*
		 * for (Player thePlayer : team1.playerArray) {
		 * System.out.println(thePlayer.playerName); }
		 */

//		Team team2 = new Team();
//		team2.teamName = "The Reds";
//		team2.playerArray = new Player[3];
//		team2.playerArray[0] = new Player();
//		team2.playerArray[0].playerName = "Robert Service";
//		team2.playerArray[1] = new Player();
//		team2.playerArray[1].playerName = "Robbie Burns";
//		team2.playerArray[2] = new Player();
//		team2.playerArray[2].playerName = "Rafael Sabatini";

		/*
		 * for (Player thePlayer : team2.playerArray) {
		 * System.out.println(thePlayer.playerName); }
		 */

		/*
		 * Game currGame = new Game(); currGame.homeTeam = team1; currGame.awayTeam =
		 * team2;
		 */

//		Goal goal1 = new Goal();
//		goal1.thePlayer = currGame.homeTeam.playerArray[2];
//		goal1.theTeam = currGame.homeTeam;
//		goal1.theTime = 55;
//
//		Goal[] theGoals = { goal1 };
//		currGame.goals = theGoals;

		// System.out.println("Goal scored after " + currGame.goals[0].theTime + " mins
		// by "
		// + currGame.goals[0].thePlayer.playerName + " of " +
		// currGame.goals[0].theTeam.teamName);

//		Game currGame = theGames[0];
//		// currGame.playGame(3);
//		currGame.playGame();

		/*
		 * for (Player thePlayer : team2.playerArray) { if
		 * (thePlayer.playerName.matches(".*Sab.*")) {
		 * //thePlayer.playerName.split(" "); System.out.println("Found " +
		 * thePlayer.playerName); System.out.println("Last name is " +
		 * thePlayer.playerName.split(" ")[1]); } } StringBuilder familyNameFirst = new
		 * StringBuilder(); for (Player thePlayer : team1.playerArray) { String name[] =
		 * thePlayer.playerName.split(" "); familyNameFirst.append(name[1]);
		 * familyNameFirst.append(", "); familyNameFirst.append(name[0]);
		 * System.out.println(familyNameFirst); familyNameFirst.delete(0,
		 * familyNameFirst.length()); }
		 */
		// System.out.println(currGame.getDescription());

		

	}

	public Team[] createTeams(String teamNames, int teamSize) throws PlayerDatabaseException {
		PlayerDatabase playerDB = new PlayerDatabase();
		StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ", ");
		Team[] theTeams = new Team[teamNameTokens.countTokens()];
		for (int i = 0; i < theTeams.length; i++) {
			theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
		}

//		Player player1 = new Player("George Eliot");
//		// player1.setPlayerName("George Eliot");
//		Player player2 = new Player("Graham Greene");
//		// player2.setPlayerName("Graham Greene");
//		Player player3 = new Player("Geoffrey Chaucer");
//		// player3.setPlayerName("Geoffrey Chaucer");
//		Player[] thePlayers = { player1, player2, player3 };
		// Team team1 = new Team("The Greens", playerDB.getTeam(3));
		// team1.setTeamName("The Greens");
		// team1.setPlayerArray(thePlayers);

		// Team team2 = new Team("The Reds", playerDB.getTeam(3));
//		team2.setTeamName("The Reds");
//		team2.setPlayerArray(new Player[3]);
//		team2.getPlayerArray()[0] = new Player("Robert Service");
//		// team2.getPlayerArray()[0].setPlayerName("Robert Service");
//		team2.getPlayerArray()[1] = new Player("Robbie Burns");
//		// team2.getPlayerArray()[1].setPlayerName("Robbie Burns");
//		team2.getPlayerArray()[2] = new Player("Rafael Sabatini");
//		// team2.getPlayerArray()[2].setPlayerName("Rafael Sabatini");
		// Team[] theTeams = { team1, team2 };
		return theTeams;
	}

	public Game[] createGames(Team[] theTeams) {
		int daysBetweenGames = 0;
		ArrayList<Game> theGames = new ArrayList<Game>();
		for (Team homeTeam : theTeams) {
			for (Team awayTeam : theTeams) {
				if (homeTeam != awayTeam) {
					daysBetweenGames += 7;
					theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
				}
			}
		}
//		Game theGame = new Game(theTeams[0], theTeams[1]);
//		Game theGame2 = new Game(theTeams[1], theTeams[0]);
//		Game theGame3 = new Game(theTeams[0], theTeams[1]);
//		Game theGame4 = new Game(theTeams[1], theTeams[0]);
////		theGame.setHomeTeam(theTeams[0]);
////		theGame.setAwayTeam(theTeams[1]);
//		Game[] theGames = {theGame, theGame2, theGame3, theGame4};
		return (Game[]) theGames.toArray(new Game[1]);
	}

	public void showBestTeam(Team[] theTeams) {
		Arrays.sort(theTeams);
		Team currBestTeam = theTeams[0];
		System.out.println("\nTeam Points");
		for (Team currTeam : theTeams) {
			System.out.println(
					currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : " + currTeam.getGoalsTotal());
			// System.out.println(currTeam.getTeamName() + " : " +
			// currTeam.getPointsTotal());
			// currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ?
			// currTeam : currBestTeam;
//			if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
//				currBestTeam = currTeam;
//			} else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
//				if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
//					currBestTeam = currTeam;
//				}
//			}
		}
		System.out.println("Winner of the league is " + currBestTeam.getTeamName());
	}

	public String getLeagueAnnouncement(Game[] theGames) {
		Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(),
				theGames[theGames.length - 1].getTheDateTime().toLocalDate());
		return "The League is scheduled to run for " + thePeriod.getMonths() + " month(s), and " + thePeriod.getDays()
				+ " day(s)\n";
	}

	public void showBestPlayers(Team[] theTeams) {
		ArrayList<Player> thePlayers = new ArrayList<Player>();
		for (Team currTeam : theTeams) {
			thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
		}
		Collections.sort(thePlayers,
				(p1, p2) -> Double.valueOf(p2.getGoalsScored()).compareTo(Double.valueOf(p1.getGoalsScored())));
		System.out.println("\n\nBest Players");
		for (Player currPlayer : thePlayers) {
			System.out.println(currPlayer.getPlayerName() + " : " + currPlayer.getGoalsScored());
		}
	}

}
