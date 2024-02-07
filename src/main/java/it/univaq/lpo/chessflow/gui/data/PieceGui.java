package it.univaq.lpo.chessflow.gui.data;

import it.univaq.lpo.chessflow.model.Color;
import it.univaq.lpo.chessflow.model.PieceName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;


@AllArgsConstructor
@Value
@Builder
public class PieceGui {
	@NonNull PieceName pieceName;
	@NonNull Color color;
}
