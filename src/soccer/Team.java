package soccer;

public class Team implements Comparable<Team> {

	private String teamName;

	private Player[] playerArray;

	private int pointsTotal;

	private int goalsTotal;

	public Team() {
	}

	public Team(String teamName) {
		this.teamName = teamName;
	}

	public Team(String teamName, Player[] playerArray) {
		this(teamName);
		this.playerArray = playerArray;
	}

	public void incPointsTotal(int pointsTotal) {
		this.pointsTotal += pointsTotal;
	}

	public void incGoalsTotal(int goalsTotal) {
		this.goalsTotal += goalsTotal;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Player[] getPlayerArray() {
		return playerArray;
	}

	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}

	public int getPointsTotal() {
		return pointsTotal;
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}

	public int getGoalsTotal() {
		return goalsTotal;
	}

	public void setGoalsTotal(int goalsTotal) {
		this.goalsTotal = goalsTotal;
	}

	@Override
	public int compareTo(Team theTeam) {
		int returnValue = -1;
		if (this.getPointsTotal() < theTeam.getPointsTotal()) {
			returnValue = 1;
		} else if (this.getPointsTotal() == theTeam.getPointsTotal()) {
			if (this.getGoalsTotal() < theTeam.getGoalsTotal()) {
				returnValue = 1;
			}
		}
		return returnValue;
	}

}