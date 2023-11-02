package it.univaq.lpo.chessflow;

import java.util.Arrays;

import it.univaq.lpo.chessflow.repository.*;

public class ChessFlowApplication {

	public static void main(String[] args) {
		PieceRepository pieceRepository = new PieceRepositoryJsonImpl();
		System.out.println(Arrays.toString(pieceRepository.getChessPieces()));
		
	}
	
}
