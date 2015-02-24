
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
        if (playerName == player1Name)
            score1 ++;
        if (playerName == player2Name)
            score2 ++;
    }

    public String getScore() {
    	
    	if (score1 == score2)
        	return parity(score1);
    	
        if (score1>=4 || score2>=4)
        	return advantageOrWin() + " " + winningPlayer();
        
        return calculateRunningScoreString();
    }

	private String calculateRunningScoreString() {
		return runningScore(score1) + "-" + runningScore(score2);
	}

	private String runningScore(int value) {
		if (value == 0)
			return "Love";
		if (value == 1)
			return "Fifteen";
		if (value == 2)
			return "Thirty";
		if (value == 3)
			return "Forty";
		else
			return "";
	}

	private String parity(int score) {
		if(score >= 3)
			return "Deuce";
		return runningScore(score) + "-All";
	}

	private String advantageOrWin() {
		if (isWiningScore()) 
			return "Win for";
		else 
			return "Advantage";
	}

	private String winningPlayer() {
		if (score1 > score2)
			return player1Name;
		else
			return player2Name;
	}

	private boolean isWiningScore() {
		return Math.abs(score1-score2) >= 2;
	}
}
 /*
			SCRATCHBOOK
			
		-wonPoint wrong condition "player1" !!?!?	OK	OK
		-m_score name is ugly	OK	OK
		-wonPoint might be ugly <<-- Interface (is it ok to change that?)
		-getScore is weird and difficult to understand.	OK	OK
		-is there no forty-all? <<- Misunderstanding, solved ;)
		-advantageOrWin is too complex? does it solve 2 functions?	OK	OK
		-math.abs in conditional looks terrible	OK	OK
		-Running score switch doesn't look compact enough	OK	OK
		-That useless For cycle in the running Score calculation	OK	OK
		-Can I map Love, Fifteen, Thirty in a map? is it worth?
		-parity calculation duplicates the Love, Fifteen, Thirty information...	OK	OK
		
*/