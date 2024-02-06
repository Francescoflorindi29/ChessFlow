package it.univaq.lpo.chessflow.gui;

import it.univaq.lpo.chessflow.model.Color;
import it.univaq.lpo.chessflow.model.PieceName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PieceGUI {
	
	private PieceName pieceName;
	private Color color;
	
}
