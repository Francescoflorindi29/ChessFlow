package it.univaq.lpo.chessflow.model;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

	private final static int[] POSSIBLE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {

		int possibleDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();
		
		for (final int currentCoordinate : POSSIBLE_MOVE_COORDINATES) {

			possibleDestinationCoordinate = this.piecePosition + currentCoordinate;
			
			if ()
		}
	}
}
