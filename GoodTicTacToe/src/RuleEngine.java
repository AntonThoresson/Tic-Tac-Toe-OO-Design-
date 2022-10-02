
public class RuleEngine {
	private Controller controller;
	private Player player;
	protected Board board;
	boolean gameOver;
	int winCount;
	int size = 3;

	public RuleEngine(Player _player) {
		player = _player;
		gameOver = false;
		winCount = size;
		board = new Board(size, size);
		board.createBoard();

	}

	public boolean isMoveValid(int r, int c) {
		if (gameOver) {
			return false;
		} else {
			if (board.getCell(r, c) == ' ') {
				board.setCell(r, c, player.getPlayerTurn());
				player.increasePlayerTurnCounter();
				if (isWin()) {
					gameOver = true;
					return true;
				}
				return true;
			}
			return false;
		}
	}
	
	private boolean isRowWin() {
		int rowCounter = 1;
		for (int r = 0; r < board.getRows(); ++r) {
			for (int c = 1; c < board.getCols(); ++c) {
				if (board.getCell(r, c-1) != ' ' && board.getCell(r, c-1) == board.getCell(r, c)) {
					rowCounter += 1;
				}
				else {
					rowCounter = 1;
				}
				if (rowCounter == winCount) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean isColWin() {
		int colCounter = 1;
		for (int c = 0; c < board.getCols(); ++c) {
			for (int r = 1; r < board.getRows(); ++r) {
				if (board.getCell(r-1, c) != ' ' && board.getCell(r-1, c) == board.getCell(r, c)) {
					colCounter += 1;
				}
				else {
					colCounter = 1;
				}
				if (colCounter == winCount) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isRightDiagonalWin() {
		int diagonalCounter = 1;
		for (int r = 1; r < board.getRows(); r++) {
			if (board.getCell(r,r) != ' ' && board.getCell(r, r) == board.getCell(r-1, r-1)) {
				diagonalCounter += 1;
			}
			else {
				diagonalCounter = 1;
			}
			if (diagonalCounter == winCount) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isLeftDiagonalWin() {
		int diagonalCounter = 1;
		int c = board.getCols()-1;
		for (int r = 0; r < board.getRows()-1; r++, c--) {
			if (board.getCell(r, c) != ' ' && board.getCell(r, c) == board.getCell(r+1, c-1)) {
				diagonalCounter += 1;
			}
			else {
				diagonalCounter = 1;
			}
			if (diagonalCounter == winCount) {
				return true;
			}
		}
		return false;
	}

	public boolean isWin() {
		if (isRowWin() || isColWin() || isRightDiagonalWin() || isLeftDiagonalWin()) {
			return true;
		}
		return false;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public int getSize() {return size;}
}
