import javax.swing.JButton;

public class Board {
	
	private char[][] _board;
	
	public Board(int boardSize) {
		
		_board = new char[boardSize][boardSize];
		
		for(int x = 0; x < boardSize; x++)
			for(int y = 0; y < boardSize; y++) {
				_board[x][y] = ' ';
			}
	}
	
	public char getSquare(int row, int col){
		return _board[row][col];
	}
	
	public void setSquare(int row, int col, char playerToken) {
		_board[row][col] = playerToken;
	}
	
	public void resetBoard(int boardSize) {
		for(int x = 0; x < boardSize; x++)
			for(int y = 0; y < boardSize; y++) {
				_board[x][y] = ' ';
			}
	}
	
	public boolean checkIfWin(int boardsize, int streaksToWin, char playerToken) {
		
		int streakCounter = 0;
		
		for(int i = 0; i < boardsize ;i++) {//check rows |x|x|x|
			for (int j = 0; j < boardsize; j++) {
				if(_board[i][j] == playerToken) {
					streakCounter+=1;
				}
				if(streakCounter== streaksToWin) {
					return true;
				}
			}
			streakCounter = 0;
		}
		
		for(int i = 0; i < boardsize; i++){   //check columns
			for(int j = 0; j < boardsize;j++){
				if(_board[j][i] == playerToken) {
					streakCounter++;
				}
				if(streakCounter== streaksToWin){
					return true;
				}
			}
			streakCounter = 0;
		}
		
		for(int i = 0; i < boardsize; i++){	//check diagonal left to right
			if(_board[i][i] == playerToken) {
				streakCounter ++;
			}
			if(streakCounter==streaksToWin) {
				return true;
			}
		}
		
		streakCounter =0;
		for(int i = 0 ; i <boardsize;i++) {
			if(_board[i][(boardsize-1)-i] == playerToken) {
				streakCounter++;
			}
			if(streakCounter == streaksToWin) {
				return true;
			}
			
			
		}
		
		return false;
			
	}

		
}

