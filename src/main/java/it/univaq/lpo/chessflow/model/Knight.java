package it.univaq.lpo.chessflow.model;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Knight extends Piece {

	private final static int[] POSSIBLE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {
		int possibleDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();
		for (final int currentCoordinateOffset : POSSIBLE_MOVE_COORDINATES) {
			possibleDestinationCoordinate = this.piecePosition + currentCoordinateOffset;
			if (BoardUtils.isValidSquareCoordinate(possibleDestinationCoordinate)) {
				if (isFirstColumnExclusion(this.piecePosition, currentCoordinateOffset)) {
					continue;
				}

				final Square possibleDestinationSquare = board.getSquare(possibleDestinationCoordinate);
				if (!possibleDestinationSquare.isSquareOccupied()) {
					legalMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = possibleDestinationSquare.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new Move());
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17) || (candidateOffset == -10))
				|| candidateOffset == 6 || candidateOffset == 15;
	}

	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SECOND_COLUMN[currentPosition] && ((candidateOffset == -10) || candidateOffset == 6);
	}

	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && ((candidateOffset == -6) || candidateOffset == 10);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && ((candidateOffset == -15) || (candidateOffset == -6))
				|| (candidateOffset == 10) || (candidateOffset == 17);
	}

}
