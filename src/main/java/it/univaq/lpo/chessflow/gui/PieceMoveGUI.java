package it.univaq.lpo.chessflow.gui;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PieceMoveGUI {
	
	private PieceGUI piece;
	private CoordinatesGUI initalPosition;
	private CoordinatesGUI finalPosition;

}
