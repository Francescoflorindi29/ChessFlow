package it.univaq.lpo.chessflow.model;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public abstract class Square {

	protected final int squareCoordinate;

	private static final Map<Integer, EmptySquare> EMPTY_SQUARE_CACHE = createAllPosibleEmptySquare();

	private Square(int squareCoordinate) {
		this.squareCoordinate = squareCoordinate;
	}

	public static Square createSquare(final int squareCoordinate, final Piece piece) {
		return piece != null ? new OccupiedSquare(squareCoordinate, piece) : EMPTY_SQUARE_CACHE.get(squareCoordinate);
	}

	private static Map<Integer, EmptySquare> createAllPosibleEmptySquare() {
		final Map<Integer, EmptySquare> emptySquareMap = new HashMap<>();

		for (int i = 0; i < 64; i++) {
			emptySquareMap.put(i, new EmptySquare(i));
		}
		return ImmutableMap.copyOf(emptySquareMap);
	}

	public abstract boolean isSquareOccupied();

	public abstract Piece getPiece();

	public static final class EmptySquare extends Square {

		EmptySquare(int coordinate) {
			super(coordinate);
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

	public static final class OccupiedSquare extends Square {

		private final Piece pieceOnSaqure;

		OccupiedSquare(int squareCoordinate, Piece pieceOnSquare) {
			super(squareCoordinate);
			this.pieceOnSaqure = pieceOnSquare;
		}

		@Override
		public boolean isSquareOccupied() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return this.pieceOnSaqure;
		}
	}
}
