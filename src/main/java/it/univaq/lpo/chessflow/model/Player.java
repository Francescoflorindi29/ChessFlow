package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
	private String name;
	private long id;
	private PlayerType type;
}
