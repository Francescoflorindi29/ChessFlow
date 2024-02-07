package it.univaq.lpo.chessflow.gui;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.data.PieceMovedInfo;

import java.util.function.Consumer;

public interface ChessApplicationGui {
	
	ChessBoardGui getBoard();
	void run(String[] args) throws BusinessException;
	void addOnPieceMoved(Consumer<PieceMovedInfo> onPieceMovedCallback);
	void removeOnPieceMoved(Consumer<PieceMovedInfo> onPieceMovedCallback);

}
