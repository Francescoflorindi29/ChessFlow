package it.univaq.lpo.chessflow.gui.data;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class BoardCellGuiImpl implements BoardCellGui {
    @NonNull private final CoordinatesGui coordinates;
    private PieceGui pieceOn;
}
