package it.univaq.lpo.chessflow.model;

public abstract class Square {

	int squareCoordinate;

	Square(int squareCoordinate) {
		this.squareCoordinate = squareCoordinate;
	}

	public abstract boolean isSquareOccupied();

	public abstract Piece getPiece();

	public static final class EmptySquare extends Square {
		
		EmptySquare(int coordinate) {
			super (coordinate);
		}
		
		@Override
		public boolean isSquareOccupied() {
			return false;
		}
		
		@Override
		public Piece getPiece() {
			return null;
		}
	}
	

}
