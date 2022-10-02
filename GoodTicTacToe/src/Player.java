
public class Player {
	private Controller controller;
	private RuleEngine ruleEngine;
	private int playerTurnCounter;
	
	
	public Player(Controller _controller) {
		controller = _controller;
		ruleEngine = new RuleEngine(this);
		playerTurnCounter = 0;
	}
	
	public boolean move(int r, int c) {
		if (ruleEngine.isMoveValid(r, c)) {
			return true;
		}
		return false;
	}
	
	
	public char getPlayerTurn() {
		if (playerTurnCounter % 2 == 0) {
			return 'X';
		}
		return 'O';
	}
	
	public void increasePlayerTurnCounter() {
		playerTurnCounter += 1;
	}
	
	public boolean isGameOver() {
		return ruleEngine.isGameOver();
	}

	public int getSize() {return ruleEngine.getSize();}
}
