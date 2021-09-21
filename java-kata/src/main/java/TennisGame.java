
public class TennisGame {

	private String p1;
	private String p2;

	private int scoreP1 = 0;
	private int scoreP2 = 0;

	public TennisGame(String p1, String p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public String score() {
		if (playersHaveEqualScore()) {
			return handleEqualScore();
		} else {
			String gameState = "";
			int diff = scoreP1 - scoreP2;
			int absDiff = Math.abs(diff);
			if (absDiff == 1) {
				gameState = "Advantage";
			} else if (absDiff == 2) {
				gameState = "Game";
			}

			return gameState + " " + ((scoreP1 < scoreP2) ? p2 : p1);
		}
	}

	private boolean playersHaveEqualScore() {
		return scoreP1 == scoreP2;
	}

	private String handleEqualScore() {
		if (scoreP1 == 0) {
			return "Love all";
		} else if (scoreP1 == 1) {
			return "Fifteen all";
		} else if (scoreP1 == 2) {
			return "Thirty all";
		} else {
			return "Deuce";
		}
	}

	public void newGame() {
		this.scoreP1 = 0;
		this.scoreP2 = 0;
	}

	public void round(int pointsP1, int pointsP2) {
		this.scoreP1 = pointsP1;
		this.scoreP2 = pointsP2;
	}
}