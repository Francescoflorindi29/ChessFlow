package it.univaq.lpo.chessflow.model;

public class BoardUtils {

	public static final int NUM_TILES = 64;
	public static final int NUM_TILES_FOR_ROW = 8;

	public static final boolean[] FIRST_COLUMN = initColumn(0);
	public static final boolean[] SECOND_COLUMN = initColumn(1);
	public static final boolean[] SEVENTH_COLUMN = initColumn(6);
	public static final boolean[] EIGHTH_COLUMN = initColumn(7);

	private BoardUtils() {
		throw new RuntimeException("Non puoi istanziarmi");
	}

	private static boolean[] initColumn(int columnNumber) {
		final boolean[] column = new boolean[NUM_TILES];
		do {
			column[columnNumber] = true;
			columnNumber += NUM_TILES_FOR_ROW;
		} while (columnNumber < NUM_TILES);
		return column;
	}

	public static boolean isValidSquareCoordinate(final int coordinate) {
		return coordinate >= 0 && coordinate < NUM_TILES;
	}
}
