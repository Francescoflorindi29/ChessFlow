package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {

	private MoveHistoryEntry[][] history;
	private Player whitePlayer;
	private Player blackPlayer;
	private Color turn;
}
