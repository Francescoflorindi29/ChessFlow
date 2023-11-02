package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Square {
	
	private int row;
	private int column;
	private Color color;
}
