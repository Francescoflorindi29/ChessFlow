package it.univaq.lpo.chessflow.gui;

import it.univaq.lpo.chessflow.model.Color;
import it.univaq.lpo.chessflow.model.PieceName;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class ChessBoardBuilderGUI {
	
	public static PieceGUI BLACK_PAWN = new PieceGUI(PieceName.PAWN, Color.BLACK);
	public static PieceGUI WHITE_PAWN = new PieceGUI(PieceName.PAWN, Color.WHITE);
	
	public static ChessBoardGUI buildChessBoard(ChessBoardGUI chessboard) {
		addPawns(chessboard);
		
		return chessboard;
	}
	
	@SneakyThrows
	private static void addPawns(ChessBoardGUI chessboard) {
		for(int col = 0; col < ChessBoardGUI.SIZE; col++) {
			CoordinatesGUI coordinates = new CoordinatesGUI(1, col);
			chessboard.drawPieceAt(WHITE_PAWN, coordinates);
		}
		
		for(int col = 0; col < ChessBoardGUI.SIZE; col++) {
            CoordinatesGUI coordinates = new CoordinatesGUI(6, col);
            chessboard.drawPieceAt(BLACK_PAWN, coordinates);
        }
	}
	
	@SneakyThrows
	private static addKings(ChessBoardGUI chessboard) {
	}
	

}
