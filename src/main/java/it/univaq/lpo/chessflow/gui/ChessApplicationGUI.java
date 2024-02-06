package it.univaq.lpo.chessflow.gui;

import java.util.function.Consumer;

public interface ChessApplicationGUI {
	
	public ChessBoardGUI getBoard();
	public void display(String[] args);
	public void onPieceMoved(Consumer<PieceMoveGUI> executedMove);

}
