import java.util.ArrayList;

public class Controller {
	
	private View _view;
	private GameModel _gameModel;
	private ArrayList<View> _views;
	private int _playerTurn;
	private char _playerToken;
	
	public Controller(){
			
		this._views = new ArrayList<View>();    
		_gameModel = new GameModel(3, 2, 3);
        _view = new View(this , 3);            
        _views.add(_view);							
        
        this._playerTurn = _gameModel.getWhosTurn();
        this._playerToken = _gameModel.getPlayerToken(_playerTurn);
        _view.playerTurn(_playerTurn);
     
	}
	
	
	public void unitClicked(int _r, int _c) {
		
		this._playerTurn = _gameModel.getWhosTurn();  
		this._playerToken = _gameModel.getPlayerToken(_playerTurn);
		
		
	
		if (_gameModel.ifvalidMove(_r, _c)) { 
			
			_gameModel.move(_r, _c, _playerToken);
			
			if(_gameModel.ifPlayerWin(_playerToken) ) {
				
				for(int i = 0; i< 2; i++) {
					
					this._views.get(i).placeTokenOnViewBoard(_r,_c, Character.toString(_playerToken));  
					this._views.get(i).playerWin(_playerTurn);                                           
				}
			}
			else {
				_gameModel.addNumberOfTurns();
				int nextplayer = _gameModel.getWhosTurn();
				
				for(int i = 0; i < 2 ; i++) {	
					this._views.get(i).placeTokenOnViewBoard(_r,_c, Character.toString(_playerToken));
					this._views.get(i).playerTurn(nextplayer);
				}
			}
		}
	}

	public void restartClicked() {
		
		_gameModel.restartGame();
		_playerTurn = _gameModel.getWhosTurn();
		for(int i = 0; i<2; i++) {
			_views.get(i).resetBoard();
			_views.get(i).playerTurn(_playerTurn);
		}
	}
	public void addViewClicked() {
		_view = new View(this,3);
		_views.add(_view);
	}
}
