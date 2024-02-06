package it.univaq.lpo.chessflow.gui;

import java.util.function.Consumer;

import it.univaq.lpo.chessflow.errors.BusinessException;

public interface ChessBoardGUI {
	
	public static int SIZE = 8;
	
	public void onPieceMoved(Consumer<PieceMoveGUI> executedMove);
	
	public void drawPieceAt(PieceGUI piece, CoordinatesGUI coordinate) throws BusinessException;
	public void clearSquareAt(CoordinatesGUI coordinate) throws BusinessException;
}
