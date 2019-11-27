import java.util.ArrayList;

public class GameModel {
	
	
	private Board _board;
	private ArrayList<Player> _players;

	private int _boardSize;
	private int _numberOfPlayers;
	private int _streaksToWin;
	private int _numberOfTurns;
	private int _playerTurn;
	
	
	public GameModel(int boardSize, int numberOfPlayers, int streaksToWin) {
		
		this._boardSize = boardSize;
		this._board = new Board(boardSize);
		this._players = new ArrayList<Player>();
		this._numberOfPlayers = numberOfPlayers;
		this._streaksToWin = streaksToWin;
		this._playerTurn = 1;
		this._numberOfTurns = 0;
		
		char array[] = {'O','X','K','J'};
		
		
		for (int i = 0; i < numberOfPlayers; i++) {
			
			Player player = new Player(array[i]);
			this._players.add(player);
		}
	}
	
	public int getWhosTurn() { //rename
		_playerTurn = (_numberOfTurns % _numberOfPlayers);
		return _playerTurn;	
	}
	
	public void addNumberOfTurns() { 
		_numberOfTurns +=1;
	}
	
	public int getNumberOfTurns() {
		return _numberOfTurns;
	}
	
	public char getPlayerToken(int playerTurn) {
		return _players.get(playerTurn).getToken();
		
	}
	
	public void restartGame() {
		_board.resetBoard(this._boardSize);
		_numberOfTurns = 0;
		_playerTurn = 0;
	}
	
	public boolean ifvalidMove(int row, int col) {
		
			if (this._board.getSquare(row, col) == ' ') {
				return true;
			}
			else {
				return false;
			} 
	}
	
	public void move(int row, int col, char playerToken) {
		
		this._board.setSquare(row, col, playerToken);	
	}
		
	public boolean ifPlayerWin(char playerToken) {
		
		if(this._board.checkIfWin(this._boardSize, this._streaksToWin, playerToken)) { //boardsize
			return true;
		}
		else {
			return false;
		}
	}	
		
}
