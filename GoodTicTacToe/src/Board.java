
public class Board {
	private int rows;
	private int cols;
	private char[][] board;
	
	
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols; 
		this.board = new char[rows][cols];
	}
	
	public void createBoard() {
		for (int r = 0; r < rows; ++r)
			for (int c = 0; c < cols; ++c)
				board[r][c] = ' ';
	}
	

	public int getRows() {
		return rows; 
	}
	
	public int getCols() {
		return cols;
	}
	
	public void setCell(int r, int c, char playerChar) {
		board[r][c] = playerChar;
	}
	
	
	public char getCell(int r, int c) {
		return board[r][c];
	}
}
	

	

