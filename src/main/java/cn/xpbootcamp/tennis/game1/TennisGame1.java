package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (isEqualScore()) {
            score = getEqualScore();
        } else if (isMoreThanForty()) {
            score = getWinner();
        } else {
            score = getTempScore(m_score1) + '-' + getTempScore(m_score2);
        }
        return score;
    }

    private String getWinner() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult != -1) {
            if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        } else {
            score = "Advantage player2";
        }
        return score;
    }

    private String getTempScore(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }

    private String getEqualScore() {
        String score;
        switch (m_score1) {
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

    private boolean isMoreThanForty() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private boolean isEqualScore() {
        return m_score1 == m_score2;
    }
}