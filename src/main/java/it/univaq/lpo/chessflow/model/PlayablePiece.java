package it.univaq.lpo.chessflow.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper=true)
public class PlayablePiece extends Piece {
	
	private final Color color;
	private boolean captured = false;
	
	public PlayablePiece(int id, @NonNull PieceName name, int weight, Color color) {
		super(id, name, weight);
		this.color = color;
	}	
}
