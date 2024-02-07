package it.univaq.lpo.chessflow.gui.data;

import lombok.NonNull;

public interface BoardCellGui {

    public static PieceGui NO_PIECE_ON = null;

    @NonNull CoordinatesGui getCoordinates();
    PieceGui getPieceOn();
}
