package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveHistoryEntry {

	private Piece piece;
	private Square destinationSquare;
	private int seqNum;
}
