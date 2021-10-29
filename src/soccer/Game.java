package soccer;

 

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

 

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] gameEvents;
    private LocalDateTime theDateTime;

 

    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }

 

    public void playGame() {
        // playGame(6);
        ArrayList<GameEvent> eventList = new ArrayList<GameEvent>();
        GameEvent currEvent;
        for (int i = 1; i <= 90; i++) {
            if (Math.random() > 0.8) {
                // System.out.println(i);
                currEvent = Math.random() > 0.8 ? new Goal() : new Possession();
                currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam : awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam()
                        .getPlayerArray()[(int) (Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
            }
        }
        this.gameEvents = new GameEvent[eventList.size()];
        eventList.toArray(gameEvents);
    }

 

//    public void playGame(int maxGoals) {
////        Game currGame = theGames[0];
//        int numberOfGoals = (int) (Math.random() * (maxGoals + 1));
//        // System.out.println(numberOfGoals);
//        GameEvent[] theGoals = new GameEvent[numberOfGoals];
//        // System.out.println(theGoals.length);
//        this.setEvents(theGoals);
//        GameUtils.addGameGoals(this);
//    }

 

    public String getDescription() {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        returnString.append(homeTeam.getTeamName() + " vs " + awayTeam.getTeamName() + "\n" + "Date "
                + this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
        for (GameEvent currEvent : this.getEvents()) {
            if (currEvent instanceof Goal) {
                if (currEvent.getTheTeam() == homeTeam) {
                    homeTeamGoals++;
                    homeTeam.incGoalsTotal(1);
                } else {
                    awayTeamGoals++;
                    awayTeam.incGoalsTotal(1);
                }
                currEvent.getThePlayer().incGoalsScored();
            }
            returnString.append(currEvent + " after " + currEvent.getTheTime() + " mins by "
                    + currEvent.getThePlayer().getPlayerName() + " of " + currEvent.getTheTeam().getTeamName() + "\n");
        }
        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a draw!");
            homeTeam.incPointsTotal(1);
            awayTeam.incPointsTotal(1);

 

        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            homeTeam.incPointsTotal(2);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");

 

        }
        returnString.append(" (" + homeTeamGoals + " - " + awayTeamGoals + ") \n");

 

        return returnString.toString();
    }

 

    public Team getHomeTeam() {
        return homeTeam;
    }

 

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

 

    public Team getAwayTeam() {
        return awayTeam;
    }

 

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

 

    public GameEvent[] getEvents() {
        return gameEvents;
    }

 

    public void setEvents(GameEvent[] gameEvents) {
        this.gameEvents = gameEvents;
    }

 

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

 

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }

 

}