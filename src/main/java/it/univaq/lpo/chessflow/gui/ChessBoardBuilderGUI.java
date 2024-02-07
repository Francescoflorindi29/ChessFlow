package it.univaq.lpo.chessflow.gui;

import it.univaq.lpo.chessflow.gui.data.ChessCoordinatesGui;
import it.univaq.lpo.chessflow.gui.data.CoordinatesGui;
import it.univaq.lpo.chessflow.gui.data.PieceGui;
import it.univaq.lpo.chessflow.model.Color;
import it.univaq.lpo.chessflow.model.PieceName;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class ChessBoardBuilderGui {
	
	public static PieceGui BLACK_PAWN = new PieceGui(PieceName.PAWN, Color.BLACK);
	public static PieceGui WHITE_PAWN = new PieceGui(PieceName.PAWN, Color.WHITE);
	
	public static ChessBoardGui buildChessBoard(ChessBoardGui chessboard) {
		addPawns(chessboard);
		
		return chessboard;
	}
	
	@SneakyThrows
	private static void addPawns(ChessBoardGui chessboard) {
		for(int col = 0; col < ChessCoordinatesGui.CHESSBOARD_SIZE; col++) {
			CoordinatesGui coordinates = new CoordinatesGui(col, 1);
			chessboard.drawPieceAt(WHITE_PAWN, coordinates);
		}
		
		for(int col = 0; col < ChessCoordinatesGui.CHESSBOARD_SIZE; col++) {
            CoordinatesGui coordinates = new CoordinatesGui(col, 6);
            chessboard.drawPieceAt(BLACK_PAWN, coordinates);
        }
	}
	
	@SneakyThrows
	private static void addKings(ChessBoardGui chessboard) {
	}
	

}
