package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
	private String name;
	private int id;
	private PlayerType type;
}
