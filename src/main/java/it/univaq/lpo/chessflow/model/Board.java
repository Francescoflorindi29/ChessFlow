package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {

	private long id;
	private Square[][] squares;
	
}
