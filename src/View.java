
import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class View {

	
	private Controller controller;
	private JFrame _frame;
	private JPanel _myMainPanel;
	private JPanel _myButtonPanel;
	private JPanel _myOptionsPanel;
	private JPanel _myTextPanel;
	private JLabel _mylabel;
	private JButton _restartButton;
	private JButton _addViewButton;
	private JButton[][] _buttons; 
	private int _boardSize;
	
	
	public View(Controller _controller, int boardSize) {
		
		this._frame = new JFrame("TicTacToe");
		this._myMainPanel = new JPanel();
		this._myButtonPanel = new JPanel();
		this._myTextPanel = new JPanel();
		this._myOptionsPanel = new JPanel();
		this.controller = _controller;
		this._boardSize = boardSize;
		

		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_myButtonPanel.setLayout(new GridLayout(_boardSize,_boardSize));
		_buttons = new JButton[_boardSize][_boardSize];
		
		setButtons();
		
		_restartButton = new JButton("restart");
		_addViewButton = new JButton("Add view");
		_myOptionsPanel.setLayout(new GridLayout(1,1));
		_myOptionsPanel.setPreferredSize(new Dimension(50,50));
		_myOptionsPanel.add(_restartButton);
		_myOptionsPanel.add(_addViewButton);
		
		_restartButton.addActionListener(new ActionListener() {
		            @Override
					public void actionPerformed(ActionEvent e) {controller.restartClicked();}
		        });
		
		_addViewButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {controller.addViewClicked();}
        });

		_mylabel = new JLabel("", SwingConstants.CENTER);
        _myTextPanel.setLayout(new GridLayout(1,1));
        _myTextPanel.setPreferredSize(new Dimension(150,50));
        _myTextPanel.add(_mylabel);
       
        _myMainPanel.setLayout(new BoxLayout(_myMainPanel, BoxLayout.Y_AXIS));
        _myMainPanel.add(_myOptionsPanel);
        _myMainPanel.add(_myButtonPanel);
        _myMainPanel.add(_myTextPanel);
        

        _frame.getContentPane().add(_myMainPanel);

        //Display the window.
        _frame.pack();
        _frame.setVisible(true);

	}
	
	public void resetBoard(){
		
		for(int i = 0; i< _boardSize; i++) {
			for(int j = 0; j<_boardSize; j++) {
				this._buttons[i][j].setText("");
			}
		}
	}
	
	public void playerTurn(int playerTurn) {
		
		 _mylabel.setText("player" + (playerTurn) + "'s turn");
	}
	public void placeTokenOnViewBoard(int _r, int _c, String playerToken) {
		this._buttons[_r][_c].setText(playerToken);
	}
	
	public void playerWin(int playerTurn) {
		_mylabel.setText("Player " + playerTurn + " WON!!!");
	}
	
	public void setButtons() {
		
		for(int r = 0; r < _boardSize; r++) {
		    for(int c = 0; c < _boardSize; c++) {
		        final int _r = r;
		        final int _c = c;
		        
		        
				JButton button = _buttons[r][c] = new JButton();
		        button.setPreferredSize(new Dimension(50, 50));
		        button.addActionListener(new ActionListener() {
		            @Override
					public void actionPerformed(ActionEvent e) {controller.unitClicked(_r, _c);}
		        });
		        _myButtonPanel.add(button);
		    }
		 }
	}
}
