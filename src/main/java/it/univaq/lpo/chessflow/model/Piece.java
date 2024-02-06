package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Builder
public class Piece {

	private final long id;
	private @NonNull PieceName name;
	private final int weight;
}
