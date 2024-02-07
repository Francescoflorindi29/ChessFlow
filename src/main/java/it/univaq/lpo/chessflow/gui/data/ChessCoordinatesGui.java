package it.univaq.lpo.chessflow.gui.data;

import it.univaq.lpo.chessflow.errors.BusinessException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChessCoordinatesGui {

    public static int CHESSBOARD_SIZE = 8;
    public static List<CoordinatesGui> CHESSBOARD_COORDINATES = getAllPossibleChessCoordinates();

    private static List<CoordinatesGui> getAllPossibleChessCoordinates() {
        List<CoordinatesGui> result = new ArrayList<>();
        for(int row = 0; row < CHESSBOARD_SIZE; row++) {
            for(int col = 0; col < CHESSBOARD_SIZE; col++) {
                CoordinatesGui coordinate = new CoordinatesGui(row, col);
                result.add(coordinate);
            }
        }

        return Collections.unmodifiableList(result);
    }

    public static void checkValidCoordinatesOrThrowBusinessException(CoordinatesGui coordinatesGui) throws BusinessException {
        if(coordinatesGui.getX() >= CHESSBOARD_SIZE) {
            throw new BusinessException("illegal X coordinate " + coordinatesGui.getX());
        }
        if(coordinatesGui.getY() >= CHESSBOARD_SIZE) {
            throw new BusinessException("illegal Y coordinate " + coordinatesGui.getY());
        }
    }

    public static Comparator<CoordinatesGui> comparatorByRowThenByColumn() {
        return Comparator
                .comparingInt(CoordinatesGui::getY)
                .thenComparing(CoordinatesGui::getX);
    }

}
