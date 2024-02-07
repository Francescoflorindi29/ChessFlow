package it.univaq.lpo.chessflow.gui;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.gui.data.*;


public interface ChessBoardGui {

	void clearSquareAt(CoordinatesGui coordinate) throws BusinessException;
	boolean drawPieceAt(PieceGui piece, CoordinatesGui coordinate) throws BusinessException;
	BoardCellGui getCell(CoordinatesGui coordinatesGui) throws BusinessException;
	Iterator<List<BoardCellGui>> rowsIterator();
	void addOnPieceDrawn(Consumer<PieceDrawnInfo> onPieceDrawnCallback);
	void removeOnPieceDrawn(Consumer<PieceDrawnInfo> onPieceDrawnCallback);
	void reset();
}

