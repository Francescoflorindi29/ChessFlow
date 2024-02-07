package it.univaq.lpo.chessflow.gui.data;

import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class PieceMovedInfo {
	
	PieceGui piece;
	CoordinatesGui initialPosition;
	CoordinatesGui finalPosition;

}
