package it.univaq.lpo.chessflow.repository;

import it.univaq.lpo.chessflow.errors.BusinessException;
import it.univaq.lpo.chessflow.model.Piece;

public interface PieceRepository {
	
	public Piece[] getChessPieces() throws BusinessException;
	
}
