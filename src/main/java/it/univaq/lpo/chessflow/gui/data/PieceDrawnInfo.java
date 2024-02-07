package it.univaq.lpo.chessflow.gui.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PieceDrawnInfo {
    CoordinatesGui coordinates;
    PieceGui piece;
}
