package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

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

    private boolean isPlayer1(String playerName) {
        return playerName.equals("player1");
    }

    public String getScore() {
        if (isDraw()) {
            return getScoreOfDraw();
        } else if (score1 >= 4 || score2 >= 4) {
            return getScoreWithOnePlayerMoreThanFour();
        } else {
            return getScoreWhenDifferentAndLessThanFour();
        }
    }

    private boolean isDraw() {
        return score1 == score2;
    }

    private String getScoreWhenDifferentAndLessThanFour() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = score1;
            else {
                score += "-";
                tempScore = score2;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private String getScoreWithOnePlayerMoreThanFour() {
        String score;
        int minusResult = score1 - score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String getScoreOfDraw() {
        String score;
        switch (score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}