package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square {
	
	private long id;
	private long boardId;
	
	private int row;
	private int column;
	private Color color;
	
	private Long pieceId;
	
	public boolean isPieceOver() {
		return this.pieceId != null;
	}
}
