package it.univaq.lpo.chessflow.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;

import it.univaq.lpo.chessflow.model.Move.AttackMove;
import it.univaq.lpo.chessflow.model.Move.MajorMove;

public class Knight extends Piece {

	private final static int[] POSSIBLE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(final int piecePosition, final Alliance pieceAlliance) {
		super(piecePosition, pieceAlliance);
	}

	@Override
	public Collection<Move> calculateLegalMoves(final Board board) {
		
	
		final List<Move> legalMoves = new ArrayList<>();
		
		for (final int currentCoordinateOffset : POSSIBLE_MOVE_COORDINATES) {
			final int possibleDestinationCoordinate = this.piecePosition + currentCoordinateOffset;
			if (BoardUtils.isValidSquareCoordinate(possibleDestinationCoordinate)) {
				if (isFirstColumnExclusion(this.piecePosition, currentCoordinateOffset)
						|| isSecondColumnExclusion(this.piecePosition, currentCoordinateOffset)
						|| isSeventhColumnExclusion(this.piecePosition, currentCoordinateOffset)
						|| isEighthColumnExclusion(this.piecePosition, currentCoordinateOffset)) {
					continue;
				}

				final Square possibleDestinationSquare = board.getSquare(possibleDestinationCoordinate);
				if (!possibleDestinationSquare.isSquareOccupied()) {
					legalMoves.add(new MajorMove(board, this, possibleDestinationCoordinate));
				} else {
					final Piece pieceAtDestination = possibleDestinationSquare.getPiece();
					final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

					if (this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new AttackMove(board, this, possibleDestinationCoordinate, pieceAtDestination));
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10
				|| candidateOffset == 6 || candidateOffset == 15);
	}

	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || candidateOffset == 6);
	}

	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6
				|| candidateOffset == 10 || candidateOffset == 17);
	}

}
