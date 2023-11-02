package it.univaq.lpo.chessflow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MoveDescription {

	private MoveDirection direction;
	private MoveWay way;
	private int length;
}
