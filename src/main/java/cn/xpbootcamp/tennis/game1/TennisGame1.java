package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private static final String[] scoreAlias = {"Love", "Fifteen", "Thirty", "Forty"};

    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (isPlayer1(playerName)) {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String showScoreOnBoard() {
        if (isDraw()) {
            return getScoreOfDraw();
        } else if (isOnePlayerMoreThanFour()) {
            return getScoreWithOnePlayerMoreThanFour();
        } else {
            return getScoreWhenDifferentAndLessThanFour();
        }
    }

    private boolean isPlayer1(String playerName) {
        return playerName.equals("player1");
    }

    private boolean isDraw() {
        return score1 == score2;
    }

    private boolean isOnePlayerMoreThanFour() {
        return score1 >= 4 || score2 >= 4;
    }

    private String getScoreOfDraw() {
        return score1 < 3 ? scoreAlias[score1] + "-All" : "Deuce";
    }

    private String getScoreWithOnePlayerMoreThanFour() {
        int dif = score1 - score2;
        String winner = dif > 0 ? "player1" : "player2";
        return (Math.abs(dif) == 1 ? "Advantage " : "Win for ") + winner;
    }

    private String getScoreWhenDifferentAndLessThanFour() {
        return scoreAlias[score1] + "-" + scoreAlias[score2];
    }
}