package it.univaq.lpo.chessflow.model;

public abstract class Move {

	final Board board;
	final Piece movedPiece;
	final int destinationCoordinate;

	public Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
		this.board = board;
		this.movedPiece = movedPiece;
		this.destinationCoordinate = destinationCoordinate;
	}

	public static final class MajorMove extends Move {

		MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
			super(board, movedPiece, destinationCoordinate);

		}
	}

	public static final class AttackMove extends Move {

		final Piece attackedPiece;

		AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate,
				final Piece attackedPiece) {
			super(board, movedPiece, destinationCoordinate);
			this.attackedPiece = attackedPiece;
		}

	}
}
